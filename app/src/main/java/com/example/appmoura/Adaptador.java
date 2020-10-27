package com.example.appmoura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//        Adapter.MyViewHolder
public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {

    private List<opcoes> opcoes;
    public Adaptador(List<opcoes> lista) {
        this.opcoes = lista;
    }

    @NonNull



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        opcoes opcao = opcoes.get(position);
        holder.titulo.setText(opcao.getTitulo());
        //holder.saldo.setText(opcao.getSaldo());

    }

    @Override
    public int getItemCount() {
        return opcoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        //TextView saldo;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            //saldo = itemView.findViewById(R.id.textSaldo);

        }
    }
}
