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

public class hora7 extends AppCompatActivity {

    private TextInputEditText acumulado7;
    private TextInputEditText obs7;
    float saldo7, ac7, meta, projecao7;
    private final String DADOS = "Dados";

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora7);

        acumulado7 = findViewById(R.id.ac7);
        obs7 = findViewById(R.id.ob7);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Sétima hora");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    public void salvar7 (View view){

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (acumulado7.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite o acumulado 7", Toast.LENGTH_LONG).show();
        } else {

            //Recuperar valores digitados
            String ACUMULADO7 = acumulado7.getText().toString();
            String OBS7 = obs7.getText().toString();

            //Passa dados para outra activity
//            Intent salvar7 = new Intent(this, MainActivity.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Float.parseFloat(metadiaria);
            ac7 = Float.parseFloat(ACUMULADO7);
            projecao7 = ((ac7 / 7) * 8);
            saldo7 = projecao7 - meta;

            bd.child("hora7").child("acumulado").push().setValue(ACUMULADO7);
            bd.child("hora7").child("obs").push().setValue(OBS7);
            bd.child("hora7").child("projecao").push().setValue(projecao7);
            bd.child("hora7").child("saldo").push().setValue(saldo7);

            int proj = Math.round(projecao7);
            int s = Math.round(saldo7);
            String proje7 = Integer.toString(proj);
            String sald7 = Integer.toString(s);

            editor.putString("acumulado7", ACUMULADO7);
            editor.putString("projeção7", proje7);
            editor.putString("saldo7", sald7);
            editor.putString("obs7", OBS7);
            editor.commit();

//            startActivity(salvar7);
            finish();
        }
    }
}

