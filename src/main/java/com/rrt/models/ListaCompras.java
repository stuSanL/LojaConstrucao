package com.rrt.models;

import java.sql.Date;

public class ListaCompras {

    private int id;
    private Cliente cliente;
    private Date data_criacao;
    private String compartilhada_com;

    public ListaCompras(int id, Cliente cliente, Date data_criacao, String compartilhada_com) {
        this.cliente = cliente;
        this.data_criacao = data_criacao;
        this.compartilhada_com = compartilhada_com;
    }

    public ListaCompras(){}

    @Override
    public String toString() {
        return "ListaCompras{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", data_criacao=" + data_criacao +
                ", compartilhada_com='" + compartilhada_com + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getCompartilhada_com() {
        return compartilhada_com;
    }

    public void setCompartilhada_com(String compartilhada_com) {
        this.compartilhada_com = compartilhada_com;
    }
}
