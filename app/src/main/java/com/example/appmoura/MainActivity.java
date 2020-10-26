package com.example.appmoura;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaOp;//criaçao do método
    private List<opcoes> listaOpcoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaOp = findViewById(R.id.listaOp);

        //listagem de itens
        this.opcoes();

        //adaptador
        Adaptador adaptador = new Adaptador(listaOpcoes);


        //configurar Recycleview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());//instanciando o layout
        listaOp.setLayoutManager(layoutManager);//define para listaOp o layout criando acima
        listaOp.setHasFixedSize(true);
        listaOp.setAdapter(adaptador);//define o adaptador do layout
    }

    public void opcoes(){
        opcoes opcao = new opcoes("Início do turno","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Hora 1","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Hora 2","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Hora 3","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Hora 4","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Hora 5","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Hora 6","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Hora 7","0");
        this.listaOpcoes.add(opcao);

        opcao = new opcoes("Fechamento do turno","0");
        this.listaOpcoes.add(opcao);
    }

//    //botao salvar
//    public void enviar(View view){
//        TextInputEditText campoEquipe = findViewById(R.id.editEquipe);
//        TextInputEditText campoMeta = findViewById(R.id.editMeta);
//        TextInputEditText campoObs = findViewById(R.id.editObservacao);
    }

