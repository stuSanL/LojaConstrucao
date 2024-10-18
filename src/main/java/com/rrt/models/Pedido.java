package com.rrt.models;

import java.sql.Date;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Date data_pedido;
    private String hora_pedido;
    private String status;

    public Pedido(int id, Cliente cliente, Date data_pedido, String hora_pedido, String status) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.hora_pedido = hora_pedido;
        this.status = status;
    }
    public Pedido(){

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

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getHora_pedido() {
        return hora_pedido;
    }

    public void setHora_pedido(String hora_pedido) {
        this.hora_pedido = hora_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
