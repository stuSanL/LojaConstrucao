package com.rrt.teste;

import com.rrt.dao.ClienteDAO;
import com.rrt.models.Cliente;

import java.sql.Date;
import java.sql.SQLException;

public class TesteCliente {
    public static void main(String[] args) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNome("Rafael");
        cliente.setData_nascimento(Date.valueOf("2008-10-05"));
        cliente.setEmail("rafael@gmail.com");
        cliente.setTelefone("tel0");
        cliente.setCep("cep0");
        cliente.setRua("rua0");
        cliente.setNumero("numero0");
        cliente.setComplemento("comp0");
        cliente.setBairro("bairro0");
        cliente.setCpf("cpf0");
        cliente.setSenha("senha0");
        ClienteDAO clienteDAO = new ClienteDAO();
        //clienteDAO.add(cliente);
        System.out.println("Clientes: ");
        for(Cliente c : clienteDAO.findAll()){
            System.out.println(c.getNome());
        }
    }
}
