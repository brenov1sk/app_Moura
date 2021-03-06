package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class inicioTurno extends AppCompatActivity {

    //Definindo as referencias
    private TextInputEditText editGrupo, editMeta, editObs;
    private TextView teste;
    private Button enviarInicio;

    private DatabaseReference bd = FirebaseDatabase.getInstance().getReference();

    private final String DADOS = "Dados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_turno);

        //Cadastro de usuario


        //Inicializando os itens
        editGrupo = findViewById(R.id.editGrupo);
        editMeta = findViewById(R.id.editMeta);
        editObs = findViewById(R.id.editObs);
        enviarInicio = findViewById(R.id.salvar0);


        //TOOLBAR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Inicio do turno");     //Titulo para ser exibido na sua Action Bar em frente à seta
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

    //Criando método para salvaree
    public void salvar0 (View view){

        SharedPreferences preferences = getSharedPreferences(DADOS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (editMeta.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(), "Digite a meta", Toast.LENGTH_LONG).show();
        } else {

            //Recuperar valores digitados
            String grupo0 = editGrupo.getText().toString();
            String meta0 = editMeta.getText().toString();
            String obs0 = editObs.getText().toString();

            //Passa dados para outra activity
            Intent salvar0 = new Intent(inicioTurno.this, MainActivity.class);

            bd.child("InicioTurno").child("grupo").push().setValue(grupo0);
            bd.child("InicioTurno").child("meta").push().setValue(meta0);
            bd.child("InicioTurno").child("obs").push().setValue(obs0);

            editor.putString("grupo", grupo0);
            editor.putString("meta", meta0);
            editor.commit();

            startActivity(salvar0);
        }
    }
}