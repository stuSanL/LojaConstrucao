package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Cliente;
import jakarta.servlet.annotation.WebServlet;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    //private static final Logger logger = LoggerFactory.getLogger(ClienteDAO.class);
    Connection connection;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void add(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, data_nascimento, email, telefone, cep, rua, numero, complemento, bairro, cpf, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, String.valueOf(cliente.getData_nascimento()));
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getRua());
            stmt.setString(7, cliente.getNumero());
            stmt.setString(8, cliente.getComplemento());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getCpf());
            stmt.setString(11, cliente.getSenha());
            stmt.execute();
        } catch (SQLException e){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public Cliente findbyCPF(String cpf) {
        String sql = "SELECT FROM Pessoa WHERE cpf = ?";
        Cliente cliente = new Cliente();

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,cpf);


            ResultSet rs = statement.executeQuery();
            rs.next();
            cliente = new Cliente();
            cliente.setSenha(rs.getString("senha"));


        }catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return cliente;
    }

    public List<Cliente> findAll(){
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setData_nascimento(Date.valueOf(rs.getString("data_nascimento")));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSenha(rs.getString("senha"));
                clientes.add(cliente);
            }
        } catch (SQLException e){
            //logger.error(e.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return clientes;
    }

}
