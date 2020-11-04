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

public class MainActivity extends AppCompatActivity {

    private Button buttonTela2;

    Spinner sistemas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sistemas = (Spinner) findViewById(R.id.spOpcao);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.combo_box,android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);
        String item = sistemas.getSelectedItem().toString();


        buttonTela2 = findViewById(R.id.buttonTela2);
        buttonTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText ra = findViewById(R.id.ra);

                EditText nome = findViewById(R.id.nomeAluno);

                String item = sistemas.getSelectedItem().toString();
                EditText turma = findViewById(R.id.turma);


                if (ra.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Preencha os Campos", Toast.LENGTH_LONG).show();

                    } else if (nome.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Preencha os Campos", Toast.LENGTH_LONG).show();

                    } else if (item.equals("Selecione uma Opção")) {
                        Toast.makeText(getApplicationContext(), "Escolha uma Opção", Toast.LENGTH_LONG).show();

                    } else if (turma.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Preencha os Campos", Toast.LENGTH_LONG).show();

                } else{
                    Intent intent = new Intent(getApplicationContext(), Disciplinas1.class);
                    startActivity(intent);

                }
                }
        });
    }
    public void voltar (View view){
        finish();

    }
}