package com.rrt.models;

import java.sql.Date;

public class Avaliacoes {
    private int id;
    private Produto produto;
    private Cliente cliente;
    private int classificacao;
    private String comentario;
    private Date data;


    public Avaliacoes(int id, Produto produto, Cliente cliente, int classificacao, String comentario, Date data) {
        this.id = id;
        this.produto = produto;
        this.cliente = cliente;
        this.classificacao = classificacao;
        this.comentario = comentario;
        this.data = data;
    }

    public Avaliacoes() {

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
