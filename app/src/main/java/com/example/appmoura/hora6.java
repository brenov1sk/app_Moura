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

public class hora6 extends AppCompatActivity {

    private TextInputEditText acumulado6;
    private TextInputEditText obs6;

    float saldo6, ac6, meta, projecao6;
    private final String DADOS = "Dados";

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora6);

        acumulado6 = findViewById(R.id.ac6);
        obs6 = findViewById(R.id.ob6);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Sexta hora");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    public void salvar6 (View view){

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (acumulado6.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite o acumulado 6", Toast.LENGTH_LONG).show();
        } else {

            //Recuperar valores digitados
            String ACUMULADO6 = acumulado6.getText().toString();
            String OBS6 = obs6.getText().toString();

            //Passa dados para outra activity
//            Intent salvar6 = new Intent(this, MainActivity.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Float.parseFloat(metadiaria);
            ac6 = Float.parseFloat(ACUMULADO6);
            projecao6 = ((ac6 / 6) * 8);
            saldo6 = projecao6 - meta;

            bd.child("hora6").child("acumulado").push().setValue(ACUMULADO6);
            bd.child("hora6").child("obs").push().setValue(OBS6);
            bd.child("hora6").child("projecao").push().setValue(projecao6);
            bd.child("hora6").child("saldo").push().setValue(saldo6);

            int proj = Math.round(projecao6);
            int s = Math.round(saldo6);
            String proje6 = Integer.toString(proj);
            String sald6 = Integer.toString(s);

            editor.putString("acumulado6", ACUMULADO6);
            editor.putString("projeção6", proje6);
            editor.putString("saldo6", sald6);
            editor.putString("obs6", OBS6);
            editor.commit();

//            startActivity(salvar6);
            finish();
        }
    }
}
