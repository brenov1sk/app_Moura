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

public class fimTurno extends AppCompatActivity {

    private int prodf, saldof, meta;
    private TextInputEditText prodFinal, scrap, sucata;
    private final String DADOS = "Dados";
    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_turno);

        prodFinal = findViewById(R.id.prodFinal);
        scrap = findViewById(R.id.scrap);
        sucata = findViewById(R.id.sucata);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Fim do expediente");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    public void salvarfinal(View view) {

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (prodFinal.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite a produção final", Toast.LENGTH_LONG).show();
        } else {

            String PRODFINAL = prodFinal.getText().toString();
            String SCRAP = scrap.getText().toString();
            String SUCATA = sucata.getText().toString();

//            Intent salvar8 = new Intent(this, fimResultado.class);

            String metadiaria = preferences.getString("meta", "0");
            meta = Integer.parseInt(metadiaria);
            prodf = Integer.parseInt(PRODFINAL);
            saldof = (prodf - meta);

            bd.child("fimTurno").child("produção_final").push().setValue(PRODFINAL);
            bd.child("fimTurno").child("saldo_final").push().setValue(saldof);
            bd.child("fimTurno").child("scrap").push().setValue(SCRAP);
            bd.child("fimTurno").child("sucata").push().setValue(SUCATA);

            String saldoFinal = Integer.toString(saldof);

            editor.putString("prodFinal", PRODFINAL);
            editor.putString("saldoFinal", saldoFinal);
            editor.putString("scrap", SCRAP);
            editor.putString("sucata", SUCATA);
            editor.commit();

//            startActivity(salvar8);
            finish();
        }
    }
}
