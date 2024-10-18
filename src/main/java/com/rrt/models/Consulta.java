package com.rrt.models;

import java.sql.Date;

public class Consulta {

    private int id;
    private Cliente cliente;
    private Funcionario funcionario;
    private Date data;
    private String horario;
    private String confirmacao;

    public Consulta(Cliente cliente, Funcionario funcionario, Date data, String horario, String confirmacao) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.data = data;
        this.horario = horario;
        this.confirmacao = confirmacao;
    }
    public Consulta() {}

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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(String confirmacao) {
        this.confirmacao = confirmacao;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", funcionario=" + funcionario +
                ", data=" + data +
                ", horario='" + horario + '\'' +
                ", confirmacao='" + confirmacao + '\'' +
                '}';
    }
}
