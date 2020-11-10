package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class hora1 extends AppCompatActivity {

    private TextInputEditText acumulado1;
    private TextInputEditText obs1;

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    int saldo1, ac1, meta, projecao1;
    private final String DADOS = "Dados";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora1);

        acumulado1 = findViewById(R.id.ac1);
        obs1 = findViewById(R.id.ob1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Primeira hora");     //Titulo para ser exibido na sua Action Bar em frente à seta
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:
                break;
        }
        return true;
    }

    //botao salvar
    public void salvar1(View view) {

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (acumulado1.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite o acumulado 1", Toast.LENGTH_LONG).show();
        } else {

            //Recuperando valores
            String ACUMULADO1 = acumulado1.getText().toString();
            String OBS1 = obs1.getText().toString();

            //Passando dados
//            Intent salvar1 = new Intent(hora1.this, MainActivity.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Integer.parseInt(metadiaria);
            ac1 = Integer.parseInt(ACUMULADO1);
            projecao1 = ((ac1 / 1) * 8);
            saldo1 = projecao1 - meta;

            bd.child("hora1").child("acumulado").push().setValue(ACUMULADO1);
            bd.child("hora1").child("obs").push().setValue(OBS1);
            bd.child("hora1").child("projecao").push().setValue(projecao1);
            bd.child("hora1").child("saldo").push().setValue(saldo1);

            String projeçãozinha = Integer.toString(projecao1);
            String saldinho = Integer.toString(saldo1);

            editor.putString("acumulado1", ACUMULADO1);
            editor.putString("projeção1", projeçãozinha);
            editor.putString("saldo1", saldinho);
            editor.putString("obs1", OBS1);
            editor.commit();

//            startActivity(salvar1);
            finish();
        }
    }
}
