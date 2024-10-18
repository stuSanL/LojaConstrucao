package com.rrt.models;

public class ItensLista {
    private int id;
    private int quantidade;
    private ListaCompras lista;
    private Produto produto;

    public ItensLista(int id, int quantidade, ListaCompras lista, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.lista = lista;
        this.produto = produto;
    }

    public ItensLista() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ListaCompras getLista() {
        return lista;
    }

    public void setLista(ListaCompras lista) {
        this.lista = lista;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
