package com.rrt.models;

import java.sql.Date;

public class Estoque {
    private int id;
    private Produto produto;
    private int quantidade;
    private Date data_entrada;
    private Date data_saida;

    public Estoque(int id, Produto produto, int quantidade, Date data_entrada, Date data_saida) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }

    public Estoque() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }
}

