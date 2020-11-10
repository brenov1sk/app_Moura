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

public class hora4 extends AppCompatActivity {

    private TextInputEditText acumulado4;
    private TextInputEditText obs4;

    float  ac4, saldo4, meta, projecao4;
    private final String DADOS = "Dados";

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora4);

        acumulado4 = findViewById(R.id.ac4);
        obs4 = findViewById(R.id.ob4);

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Quarta hora");     //Titulo para ser exibido na sua Action Bar em frente à seta
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    public void salvar4 (View view){

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (acumulado4.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite o acumulado 4", Toast.LENGTH_LONG).show();
        } else {

            //Recuperar valores digitados
            String ACUMULADO4 = acumulado4.getText().toString();
            String OBS4 = obs4.getText().toString();

            //Passa dados para outra activity
//            Intent salvar4 = new Intent(this, MainActivity.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Float.parseFloat(metadiaria);
            ac4 = Float.parseFloat(ACUMULADO4);
            projecao4 = ((ac4 / 4) * 8);
            saldo4 = projecao4 - meta;

            bd.child("hora4").child("acumulado").push().setValue(ACUMULADO4);
            bd.child("hora4").child("obs").push().setValue(OBS4);
            bd.child("hora4").child("projecao").push().setValue(projecao4);
            bd.child("hora4").child("saldo").push().setValue(saldo4);

            String proje4 = Float.toString(projecao4);
            String sald4 = Float.toString(saldo4);

            editor.putString("acumulado4", ACUMULADO4);
            editor.putString("projeção4", proje4);
            editor.putString("saldo4", sald4);
            editor.putString("obs4", OBS4);
            editor.commit();

//            startActivity(salvar4);
            finish();
        }
    }
}

