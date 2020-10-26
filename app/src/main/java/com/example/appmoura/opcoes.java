package com.example.appmoura;

public class opcoes {

    private String titulo;
    private String saldo;

    public opcoes(String titulo, String saldo) {
        this.titulo = titulo;
        this.saldo = saldo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
