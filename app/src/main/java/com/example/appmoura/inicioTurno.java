package com.example.appmoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class inicioTurno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_turno);
    }

    //botao salvar
    public void enviar(View view) {
        TextInputEditText campoGrupo = findViewById(R.id.editGrupo);
        TextInputEditText campoMeta = findViewById(R.id.editMeta);
        TextInputEditText campoObs = findViewById(R.id.editObs);;
    }
}