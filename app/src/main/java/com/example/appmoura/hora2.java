package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class hora2 extends AppCompatActivity {

    private TextInputEditText acumulado2;
    private TextInputEditText obs2;

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

//    int ;
    float saldo2, projecao2, ac2, meta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora2);

        acumulado2 = findViewById(R.id.acumulado2);
        obs2 = findViewById(R.id.obs2);

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

        //Recuperar valores digitados
        String ACUMULADO2 = acumulado2.getText().toString();
        String OBS2 = obs2.getText().toString();

        //Passa dados para outra activity
        Intent salvar2 = new Intent(hora2.this, MainActivity.class);

        meta = 100; //RESGATR DB
        ac2 = Integer.parseInt(ACUMULADO2);
        projecao2 = ((ac2/2)*7);
        saldo2 = projecao2 - meta;

        bd.child("hora2").child("acumulado").push().setValue(ACUMULADO2);
        bd.child("hora2").child("obs").push().setValue(OBS2);
        bd.child("hora2").child("projecao").push().setValue(projecao2);
        bd.child("hora2").child("saldo").push().setValue(saldo2);
        
        System.out.println("INICIO " + ACUMULADO2);
        System.out.println("INICIO " + OBS2);
        System.out.println(ac2);
        System.out.println("a projeçao e " + projecao2 + " e o saldo e " + saldo2);

        startActivity(salvar2);
    }
}
