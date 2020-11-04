package com.example.unicid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.unicid.dao.DiciplinaDao;
import com.example.unicid.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Disciplinas1 extends AppCompatActivity {

    private Button aprovado;
    private EditText gr;
    private DiciplinaDao dao;
    private List<Disciplina> disciplinaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);

       EditText list = findViewById(R.id.lista);
        dao = new DiciplinaDao(this);
        disciplinaList = dao.obterDiciplinas();
        for(Disciplina diciplina : disciplinaList) {
            list.append("ID: " + diciplina.getId() + "\n");
            list.append("Disciplina: " + diciplina.getNome() + "\n\n");

        }

        aprovado = findViewById(R.id.aprovado);
        aprovado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Aprovado.class);
                startActivity(intent);
            }
        });
    }

           public void gravar(View view) {
               EditText gr = findViewById(R.id.textGravar);
               Disciplina disciplina = new Disciplina();
               disciplina.setNome(gr.getText().toString());
               dao = new DiciplinaDao(this);
               long id = dao.insert(disciplina);
               Toast.makeText(getApplicationContext(),"Gravado"+id,Toast.LENGTH_LONG).show();

             EditText list = findViewById(R.id.lista);
               dao = new DiciplinaDao(this);
               disciplinaList = dao.obterDiciplinas();
               for(Disciplina diciplina : disciplinaList){
                  list.append("ID: "+diciplina.getId()+"\n");
                  list.append("Disciplina: "+diciplina.getNome()+"\n\n");

               }

            }

           

    public void voutar (View view){

        finish();
    }


}