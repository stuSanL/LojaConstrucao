package com.rrt.models;

public class Produto {
    private int id;
    private String nome;
    private float preco;
    private Categoria categoria;
    private Marca marca;
    private String especificacoes;
    private String disponibilidade;


    public Produto(int id, String nome, float preco, Categoria categoria, Marca marca, String especificacoes, String disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.marca = marca;
        this.especificacoes = especificacoes;
        this.disponibilidade = disponibilidade;
    }
    public Produto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
