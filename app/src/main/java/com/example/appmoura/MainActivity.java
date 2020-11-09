package com.example.appmoura;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public int metaInicial;

    private RecyclerView listaOp;//criaçao do método
    private List<opcoes> listaOpcoes = new ArrayList<>();
    private Context context;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaOp = findViewById(R.id.listaOp);

        //Listagem de itens
        this.opcoes();

        //Adaptador
        Adaptador adaptador = new Adaptador(listaOpcoes);

        //Configurar Recycleview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());//instanciando o layout
        listaOp.setLayoutManager(layoutManager);//define para listaOp o layout criando acima
        listaOp.setHasFixedSize(true);
        listaOp.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        listaOp.setAdapter(adaptador);//define o adaptador do layout

        //Evento de click
        listaOp.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        listaOp,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                switch (position) {
                                    case 0:
                                        opcoes opcao = listaOpcoes.get(position);
                                        Intent intent = new Intent(getApplicationContext(), inicioTurno.class);
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), hora1.class);
                                        startActivity(intent);
                                        break;
                                    case 2:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), hora2.class);
                                        startActivity(intent);
                                        break;
                                    case 3:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), hora3.class);
                                        startActivity(intent);
                                        break;
                                    case 4:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), hora4.class);
                                        startActivity(intent);
                                        break;
                                    case 5:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), hora5.class);
                                        startActivity(intent);
                                        break;
                                    case 6:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), hora6.class);
                                        startActivity(intent);
                                        break;
                                    case 7:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), hora7.class);
                                        startActivity(intent);
                                        break;
                                    case 8:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(), fimTurno.class);
                                        startActivity(intent);
                                        break;
                                    case 9:
                                        opcao = listaOpcoes.get(position);
                                        intent = new Intent(getApplicationContext(),total.class);
                                        startActivity(intent);
                                        break;
                                }
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    //opções do recyclerView
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

        opcao = new opcoes("Total", "0");
        this.listaOpcoes.add(opcao);
    }
}

