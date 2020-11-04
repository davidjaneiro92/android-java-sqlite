package com.example.unicid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.unicid.dao.DiciplinaDao;
import com.example.unicid.model.Disciplina;

public class aprovado2 extends AppCompatActivity {
    private Button avaliacaoFinal;
    private TextView nf;
    private TextView resul;
    private TextView af;
    private EditText nomes;
    private DiciplinaDao dao;
    private Disciplina disciplina;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado2);

        nomes = findViewById(R.id.nome);
        nf = findViewById(R.id.notaFinal1);
        resul = findViewById(R.id.resposta);
        af = findViewById(R.id.resposta2);
        Bundle dados = getIntent().getExtras();

        double diciplina = dados.getDouble("diciplina");
        String resultado = dados.getString("Resultado");
        int nome = dados.getInt("nome");


        dao = new DiciplinaDao(this);
        disciplina  = dao.read(nome);
        nomes.setText(disciplina.getNome());

        String resposta2 = "Você não Precisa Fazer a Avaliação Final";
        nf.setText(String.valueOf(diciplina));
        resul.setText(String.valueOf(resultado));

        if (diciplina >= 6){
            EditText a1 = findViewById(R.id.notaA1);
            resul.setTextColor(getColor(R.color.Aprovado));
            af.setText(resposta2);
        }else{

            resul.setTextColor(getColor(R.color.Reprovado));
            avaliacaoFinal = findViewById(R.id.avaliacaoFinal);
            avaliacaoFinal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AprovadoAF.class);
                    startActivity(intent);
                }
                });
        }

    }
    public void voltar (View view){
        finish();
    }

}