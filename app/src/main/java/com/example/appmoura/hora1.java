package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class hora1 extends AppCompatActivity {

    private TextInputEditText acumulado1;
    private TextInputEditText obs1;

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    int saldo1, ac1, meta;
    int projecao1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora1);

        acumulado1 = findViewById(R.id.acumulado1);
        obs1 = findViewById(R.id.obs1);

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

        //Recuperando valores
        String ACUMULADO1 = acumulado1.getText().toString();
        String OBS1 = obs1.getText().toString();

        //Passando dados
        Intent salvar1 = new Intent(hora1.this, MainActivity.class);

        bd.child("hora1").child("acumulado").push().setValue(ACUMULADO1);
        bd.child("hora1").child("obs").push().setValue(OBS1);

        System.out.println("hora1" + ACUMULADO1);
        System.out.println("hora1" + OBS1);

        meta = 45;
        ac1 = Integer.parseInt(ACUMULADO1);
        projecao1 = ((ac1/1)*8);
        saldo1 = projecao1 - meta;

        bd.child("hora1").child("projecao").push().setValue(projecao1);
        bd.child("hora1").child("saldo").push().setValue(saldo1);
        
        System.out.println("a projeçao 1 e " + projecao1 + "e o saldo e " + saldo1);

        startActivity(salvar1);
    }
}
