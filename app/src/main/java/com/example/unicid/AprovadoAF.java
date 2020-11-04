package com.example.unicid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicid.dao.DiciplinaDao;
import com.example.unicid.model.Disciplina;

public class AprovadoAF extends AppCompatActivity {
    private Button caucularNotaAF;
    private DiciplinaDao dao;
    private Disciplina disciplina;
    Spinner sistemas;
    private Button caucular;

    private String sDisciplina;
    private EditText a1;
    private EditText a2;
    private EditText af;
    private TextView textViewDiciplina;
    private EditText notaAF;
    private EditText notaA1;
    private EditText notaA2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado_a_f);

        sistemas = (Spinner) findViewById(R.id.diciplina2);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.comboBoxDiciplinas,android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);

        a1 = findViewById(R.id.notaA1);
        a2 = findViewById(R.id.notaA2);
        af = findViewById(R.id.notaAF);
        textViewDiciplina = findViewById(R.id.teViewDiciplina);
        String item = sistemas.getSelectedItem().toString();


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
        textViewDiciplina.setText(disciplina.getNome());
        a1.setText(String.valueOf(disciplina.getA1()));
        a2.setText(String.valueOf(disciplina.getA2()));


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
                Toast.makeText(getApplicationContext(), "Escolha uma opção ", Toast.LENGTH_LONG).show();
        }
        notaAF = findViewById(R.id.notaAF);

        disciplina = new Disciplina();
        disciplina.setId(ID);
        disciplina.setA1(Double.parseDouble(String.valueOf(notaAF.getText())));
        dao = new DiciplinaDao(this);
        dao.update(disciplina);


        Intent intent = new Intent(getApplicationContext(),AprovadoAF2.class);


        double A1,A2,AF;
        A1= Double.parseDouble(String.valueOf(a1.getText()));
        A2= Double.parseDouble(String.valueOf(a2.getText()));
        AF= Double.parseDouble(String.valueOf(af.getText()));
        String resultado;

        double notaFinal;
        if(A1>A2){
            notaFinal = A1+AF;
        }else {
            notaFinal = A2 + AF;
        }

        if (notaFinal >= 6){
            resultado = "Você foi Aprovado";
        }else{
            resultado = "Infelizmente Você Reprovado";
        }

        intent.putExtra("Resultado1", resultado);
        intent.putExtra("diciplina1", notaFinal);
        intent.putExtra("nome",ID);
        startActivity(intent);

    }

}
