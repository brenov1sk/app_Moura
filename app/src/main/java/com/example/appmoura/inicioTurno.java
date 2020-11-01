package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class inicioTurno extends AppCompatActivity {

    //Definindo as referencias
    private TextInputEditText editGrupo, editMeta, editObs;
    private TextView teste;
    private Button enviarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_turno);

        //Inicializando os itens
        editGrupo = findViewById(R.id.editGrupo);
        editMeta = findViewById(R.id.editMeta);
        editObs = findViewById(R.id.editObs);
        teste = findViewById(R.id.testekkk);

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

    //Criando método para salvar
    public void salvar0 (View view){

        //Recuperar valores digitados
        String grupo0 = editGrupo.getText().toString();
        String meta0 = editMeta.getText().toString();
        String obs0 = editObs.getText().toString();

        teste.setText(grupo0); //text view de teste

        Intent salvar = new Intent(inicioTurno.this, MainActivity.class);
        salvar.putExtra("grupo", grupo0);
        salvar.putExtra("meta", meta0);
        salvar.putExtra("obs", obs0);

        startActivity(salvar);
    }
}