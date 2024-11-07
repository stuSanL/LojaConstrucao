package com.rrt.models;

import java.sql.Date;

public class Funcionario {

    private int id;
    private String nome;
    private String cargo;
    private float salario;
    private int numero_vendas;
    private Date data_nascimento;
    private String cpf;
    private String email;
    private String senha;

    public Funcionario(String nome, String cargo, float salario, int numero_vendas, Date data_nascimento, String cpf) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.numero_vendas = numero_vendas;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
    }

    public Funcionario(){

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getNumero_vendas() {
        return numero_vendas;
    }

    public void setNumero_vendas(int numero_vendas) {
        this.numero_vendas = numero_vendas;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", numero_vendas=" + numero_vendas +
                ", data_nascimento=" + data_nascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
