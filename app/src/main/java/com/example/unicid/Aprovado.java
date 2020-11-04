package com.example.unicid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicid.dao.DiciplinaDao;
import com.example.unicid.model.Disciplina;

import java.util.List;

public class Aprovado extends AppCompatActivity {

    private DiciplinaDao dao;
    private Disciplina disciplina;
    private EditText notaA1;
    private EditText notaA2;
    private TextView dis;
    Spinner sistemas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado);

        sistemas = (Spinner) findViewById(R.id.diciplina);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.comboBoxDiciplinas,android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);
        dis = findViewById(R.id.textView2);


    }


    public void alterar(View view){

        String item = sistemas.getSelectedItem().toString();

       int ID;
        ID = 0;
       switch (item){
           case "ID 1":
               ID = 1;
               break;


            case "ID 2":
                ID = 2;
                break;

            case "ID 3":
                ID = 3;
                break;

            case "ID 4":
                ID = 4;
                break;

            case "ID 5":
                ID = 5;
                break;

            case "ID 6":
                ID = 6;
                break;

            case "ID 7":
                ID = 7;
                break;

            case "ID 8":
                ID = 8;
                break;

            case "ID 9":
                ID = 9;
                break;

            case "ID 10":
                ID = 10;
                break;

            default:
                Toast.makeText(getApplicationContext(), "Escolha uma opção "+ID, Toast.LENGTH_LONG).show();
        }
        notaA1 = findViewById(R.id.notaA1);
        notaA2 = findViewById(R.id.notaA2);

        disciplina = new Disciplina();
        disciplina.setId(ID);
        disciplina.setA1(Double.parseDouble(String.valueOf(notaA1.getText())));
        disciplina.setA2(Double.parseDouble(String.valueOf(notaA2.getText())));
        dao = new DiciplinaDao(this);
        dao.update(disciplina);
        //Toast.makeText(getApplicationContext(), "alterando com sucesso", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),aprovado2.class);

        notaA1 = findViewById(R.id.notaA1);
        notaA2 = findViewById(R.id.notaA2);
        double A1,A2;
        A1= Double.parseDouble(String.valueOf(notaA1.getText()));
        A2= Double.parseDouble(String.valueOf(notaA2.getText()));
        String resultado;

        double notaFinal;
        notaFinal = A1+A2;

        if (notaFinal >= 6){
            resultado = "Você foi Aprovado";
        }else{
            resultado = "Infelizmente Você Precisa fazer a Avaliação Final";
        }

        intent.putExtra("Resultado", resultado);
        intent.putExtra("diciplina", notaFinal);
        intent.putExtra("nome",ID);
        startActivity(intent);
}

    public void consultar (View view){

        String item = sistemas.getSelectedItem().toString();


        int ID;
        ID = 0;
        switch (item){
            case "ID 1":
                ID = 1;
                break;


            case "ID 2":
                ID = 2;
                break;

            case "ID 3":
                ID = 3;
                break;

            case "ID 4":
                ID = 4;
                break;

            case "ID 5":
                ID = 5;
                break;

            case "ID 6":
                ID = 6;
                break;

            case "ID 7":
                ID = 7;
                break;

            case "ID 8":
                ID = 8;
                break;

            case "ID 9":
                ID = 9;
                break;

            case "ID 10":
                ID = 10;
                break;

            default:
                Toast.makeText(getApplicationContext(), "Escolha uma opção ", Toast.LENGTH_LONG).show();
        }


        dao = new DiciplinaDao(this);
        disciplina  = dao.read(ID);
        dis.setText(disciplina.getNome());


    }

    }