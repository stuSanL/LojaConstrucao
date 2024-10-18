package com.rrt.models;

import java.sql.Date;

public class Venda {
    private int id;
    private Date data_venda;
    private float toatal_receita;
    private float total_despesa;
    private float lucro;

    public Venda(int id, Date data_venda, float toatal_receita, float total_despesa, float lucro) {
        this.id = id;
        this.data_venda = data_venda;
        this.toatal_receita = toatal_receita;
        this.total_despesa = total_despesa;
        this.lucro = lucro;
    }

    public Venda() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public float getToatal_receita() {
        return toatal_receita;
    }

    public void setToatal_receita(float toatal_receita) {
        this.toatal_receita = toatal_receita;
    }

    public float getTotal_despesa() {
        return total_despesa;
    }

    public void setTotal_despesa(float total_despesa) {
        this.total_despesa = total_despesa;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }
}
