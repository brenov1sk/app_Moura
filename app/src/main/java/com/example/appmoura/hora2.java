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

public class hora2 extends AppCompatActivity {

    private TextInputEditText acumulado2;
    private TextInputEditText obs2;

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    float saldo2, projecao2, ac2, meta;
    private final String DADOS = "Dados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora2);

        acumulado2 = findViewById(R.id.ac2);
        obs2 = findViewById(R.id.ob2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Segunda hora");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    public void salvar2 (View view){

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (acumulado2.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite o acumulado 2", Toast.LENGTH_LONG).show();
        } else {

            //Recuperar valores digitados
            String ACUMULADO2 = acumulado2.getText().toString();
            String OBS2 = obs2.getText().toString();

            //Passa dados para outra activity
//            Intent salvar2 = new Intent(hora2.this, MainActivity.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Float.parseFloat(metadiaria);
            ac2 = Float.parseFloat(ACUMULADO2);
            projecao2 = ((ac2 / 2) * 8);
            saldo2 = projecao2 - meta;

            int proj = Math.round(projecao2);
            int s = Math.round(saldo2);

            bd.child("hora2").child("acumulado").push().setValue(ACUMULADO2);
            bd.child("hora2").child("obs").push().setValue(OBS2);
            bd.child("hora2").child("projecao").push().setValue(projecao2);
            bd.child("hora2").child("saldo").push().setValue(saldo2);

            String proje = Integer.toString(proj);
            String sald = Integer.toString(s);

            editor.putString("acumulado2", ACUMULADO2);
            editor.putString("projeção2", proje);
            editor.putString("saldo2", sald);
            editor.putString("obs2", OBS2);
            editor.commit();

//            startActivity(salvar2);
            finish();
        }
    }
}
