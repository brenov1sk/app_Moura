package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class fimResultado extends AppCompatActivity {

    private final String DADOS = "Dados";
    private TextView prodFinal, saldoFinal, scrap, sucata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_resultado);

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);

        prodFinal = findViewById(R.id.prodFinal);
        saldoFinal = findViewById(R.id.saldoFinal);
        scrap = findViewById(R.id.scrap);
        sucata = findViewById(R.id.sucata);

        //fim do turno
        String pFinal = preferences.getString("prodFinal","");
        String sFinal = preferences.getString("saldoFinal","");
        String scrapp = preferences.getString("scrap","");
        String sucat = preferences.getString("sucata","");
        prodFinal.setText("PRODUÇÃO FINAL: " + pFinal);
        saldoFinal.setText("SALDO FINAL: " + sFinal);
        scrap.setText("SCRAP: " + scrapp);
        sucata.setText("SUCATA: " + sucat);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Fim do turno");     //Titulo para ser exibido na sua Action Bar em frente à seta
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
}
