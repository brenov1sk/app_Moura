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

public class hora3 extends AppCompatActivity {

    private TextInputEditText acumulado3;
    private TextInputEditText obs3;

    float saldo3, ac3, meta, projecao3;
    private final String DADOS = "Dados";

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora3);

        acumulado3 = findViewById(R.id.ac3);
        obs3 = findViewById(R.id.ob3);

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Terceira hora");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    public void salvar3 (View view){

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (acumulado3.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite o acumulado 3", Toast.LENGTH_LONG).show();
        } else {

            //Recuperar valores digitados
            String ACUMULADO3 = acumulado3.getText().toString();
            String OBS3 = obs3.getText().toString();

            //Passa dados para outra activity
//            Intent salvar3 = new Intent(this, MainActivity.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Float.parseFloat(metadiaria);
            ac3 = Float.parseFloat(ACUMULADO3);
            projecao3 = ((ac3 / 3) * 8);
            saldo3 = projecao3 - meta;

            bd.child("hora3").child("acumulado").push().setValue(ACUMULADO3);
            bd.child("hora3").child("obs").push().setValue(OBS3);
            bd.child("hora3").child("projecao").push().setValue(projecao3);
            bd.child("hora3").child("saldo").push().setValue(saldo3);

            int proj = Math.round(projecao3);
            int s = Math.round(saldo3);
            String proje3 = Integer.toString(proj);
            String sald3 = Integer.toString(s);

            editor.putString("acumulado3", ACUMULADO3);
            editor.putString("projeção3", proje3);
            editor.putString("saldo3", sald3);
            editor.putString("obs3", OBS3);
            editor.commit();

//            startActivity(salvar3);
            finish();
        }
    }
}
