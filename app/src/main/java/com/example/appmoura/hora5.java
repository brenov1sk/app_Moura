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

public class hora5 extends AppCompatActivity {

    private TextInputEditText acumulado5;
    private TextInputEditText obs5;

    float saldo5, ac5, meta, projecao5;
    private final String DADOS = "Dados";

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora5);

        acumulado5 = findViewById(R.id.ac5);
        obs5 = findViewById(R.id.ob5);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Quinta hora");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    public void salvar5 (View view){

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (acumulado5.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite o acumulado 5", Toast.LENGTH_LONG).show();
        } else {

            //Recuperar valores digitados
            String ACUMULADO5 = acumulado5.getText().toString();
            String OBS5 = obs5.getText().toString();

            //Passa dados para outra activity
            Intent salvar5 = new Intent(this, MainActivity.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Float.parseFloat(metadiaria);
            ac5 = Float.parseFloat(ACUMULADO5);
            projecao5 = ((ac5 / 5) * 8);
            saldo5 = projecao5 - meta;

            bd.child("hora5").child("acumulado").push().setValue(ACUMULADO5);
            bd.child("hora5").child("obs").push().setValue(OBS5);
            bd.child("hora5").child("projecao").push().setValue(projecao5);
            bd.child("hora5").child("saldo").push().setValue(saldo5);

            String proje5 = Float.toString(projecao5);
            String sald5 = Float.toString(saldo5);

            editor.putString("acumulado5", ACUMULADO5);
            editor.putString("projeção5", proje5);
            editor.putString("saldo5", sald5);
            editor.putString("obs5", OBS5);
            editor.commit();

            startActivity(salvar5);
        }
    }
}
