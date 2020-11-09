package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class total extends AppCompatActivity {

    private TextView grupoNome;
    private TextView met;

    private Button bt;

    private TextView ac1, proj1, s1, ob1;
    private TextView ac2, proj2, s2, ob2;
    private TextView ac3, proj3, s3, ob3;
    private TextView ac4, proj4, s4, ob4;
    private TextView ac5, proj5, s5, ob5;
    private TextView ac6, proj6, s6, ob6;
    private TextView ac7, proj7, s7, ob7;
    private TextView prodFinal, saldoFinal, scrap, sucata;

    private final String DADOS = "Dados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        final SharedPreferences.Editor editor = preferences.edit();

        grupoNome = findViewById(R.id.grupoNome);
        met = findViewById(R.id.met);

        ac1 = findViewById(R.id.ac1);
        proj1 = findViewById(R.id.proj1);
        s1 = findViewById(R.id.s1);
        ob1 = findViewById(R.id.ob1);

        ac2 = findViewById(R.id.ac2);
        proj2 = findViewById(R.id.proj2);
        s2 = findViewById(R.id.s2);
        ob2 = findViewById(R.id.ob2);

        ac3 = findViewById(R.id.ac3);
        proj3 = findViewById(R.id.proj3);
        s3 = findViewById(R.id.s3);
        ob3 = findViewById(R.id.ob3);

        ac4 = findViewById(R.id.ac4);
        proj4 = findViewById(R.id.proj4);
        s4 = findViewById(R.id.s4);
        ob4 = findViewById(R.id.ob4);

        ac5 = findViewById(R.id.ac5);
        proj5 = findViewById(R.id.proj5);
        s5 = findViewById(R.id.s5);
        ob5 = findViewById(R.id.ob5);

        ac6 = findViewById(R.id.ac6);
        proj6 = findViewById(R.id.proj6);
        s6 = findViewById(R.id.s6);
        ob6 = findViewById(R.id.ob6);

        ac7 = findViewById(R.id.ac7);
        proj7 = findViewById(R.id.proj7);
        s7 = findViewById(R.id.s7);
        ob7 = findViewById(R.id.ob7);

        prodFinal = findViewById(R.id.prodFinal);
        saldoFinal = findViewById(R.id.saldoFinal);
        scrap = findViewById(R.id.scrap);
        sucata = findViewById(R.id.sucata);

        //activity inicio
        String grupo = preferences.getString("grupo","");
        String meta = preferences.getString("meta","");
        grupoNome.setText("Grupo: " + grupo);
        met.setText("Meta diária: "+ meta);

        //hora1
        String acumulado1 = preferences.getString("acumulado1","");
        String projeção1 = preferences.getString("projeção1","");
        String saldo1 = preferences.getString("saldo1","");
        String obs1 = preferences.getString("obs1","");
        ac1.setText("Acumulado1: " + acumulado1);
        proj1.setText("Projeção1: " + projeção1);
        s1.setText("Saldo1: " + saldo1);
        ob1.setText("Obs1: " + obs1);

        //hora2
        String acumulado2 = preferences.getString("acumulado2","");
        String projeção2 = preferences.getString("projeção2","");
        String saldo2 = preferences.getString("saldo2","");
        String obs2 = preferences.getString("obs2","");
        ac2.setText("Acumulado2: " + acumulado2);
        proj2.setText("Projeção2: " + projeção2);
        s2.setText("Saldo2: " + saldo2);
        ob2.setText("Obs2: " + obs2);

        //hora3
        String acumulado3 = preferences.getString("acumulado3","");
        String projeção3 = preferences.getString("projeção3","");
        String saldo3 = preferences.getString("saldo3","");
        String obs3 = preferences.getString("obs3","");
        ac3.setText("Acumulado3: " + acumulado3);
        proj3.setText("Projeção3: " + projeção3);
        s3.setText("Saldo3: " + saldo3);
        ob3.setText("Obs3: " + obs3);

        //hora4
        String acumulado4 = preferences.getString("acumulado4","");
        String projeção4 = preferences.getString("projeção4","");
        String saldo4 = preferences.getString("saldo4","");
        String obs4 = preferences.getString("obs4","");
        ac4.setText("Acumulado4: " + acumulado4);
        proj4.setText("Projeção4: " + projeção4);
        s4.setText("Saldo4: " + saldo4);
        ob4.setText("Obs4: " + obs4);

        //hora5
        String acumulado5 = preferences.getString("acumulado5","");
        String projeção5 = preferences.getString("projeção5","");
        String saldo5 = preferences.getString("saldo5","");
        String obs5 = preferences.getString("obs5","");
        ac5.setText("Acumulado5: " + acumulado5);
        proj5.setText("Projeção5: " + projeção5);
        s5.setText("Saldo5: " + saldo5);
        ob5.setText("Obs5: " + obs5);

        //hora6
        String acumulado6 = preferences.getString("acumulado6","");
        String projeção6 = preferences.getString("projeção6","");
        String saldo6 = preferences.getString("saldo6","");
        String obs6 = preferences.getString("obs6","");
        ac6.setText("Acumulado6: " + acumulado6);
        proj6.setText("Projeção6: " + projeção6);
        s6.setText("Saldo6: " + saldo6);
        ob6.setText("Obs6: " + obs6);

        //hora7
        String acumulado7 = preferences.getString("acumulado7","");
        String projeção7 = preferences.getString("projeção7","");
        String saldo7 = preferences.getString("saldo7","");
        String obs7 = preferences.getString("obs7","");
        ac7.setText("Acumulado7: " + acumulado7);
        proj7.setText("Projeção7: " + projeção7);
        s7.setText("Saldo7: " + saldo7);
        ob7.setText("Obs7: " + obs7);

        //fim do turno
        String pFinal = preferences.getString("prodFinal","");
        String sFinal = preferences.getString("saldoFinal","");
        String scrapp = preferences.getString("scrap","");
        String sucat = preferences.getString("sucata","");
        prodFinal.setText("Produção final: " + pFinal);
        saldoFinal.setText("Saldo final: " + sFinal);
        scrap.setText("Scrap: " + scrapp);
        sucata.setText("Sucata: " + sucat);


        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Total");     //Titulo para ser exibido na sua Action Bar em frente à seta
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
