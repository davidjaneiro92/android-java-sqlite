package com.example.unicid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.unicid.dao.DiciplinaDao;
import com.example.unicid.model.Disciplina;

import java.text.DecimalFormat;

public class AprovadoAF2 extends AppCompatActivity {

    private EditText nomes;
    private DiciplinaDao dao;
    private Disciplina disciplina;
    private TextView nf;
    private TextView resul;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado_a_f2);

        nomes = findViewById(R.id.nome2);
        nf = findViewById(R.id.notaFinal2);
        resul = findViewById(R.id.resposta3);
        Bundle dados = getIntent().getExtras();

        double diciplina = dados.getDouble("diciplina1");
        String resultado = dados.getString("Resultado1");
        int nome = dados.getInt("nome");

        dao = new DiciplinaDao(this);
        disciplina  = dao.read(nome);
        nomes.setText(disciplina.getNome());

        nf.setText(String.valueOf(diciplina));
        resul.setText(String.valueOf(resultado));

        if (diciplina >= 6) {
            resul.setTextColor(getColor(R.color.Aprovado));
        } else {
            resul.setTextColor(getColor(R.color.Reprovado));
        }

    }
    public void voltar (View view){
        finish();
    }
}