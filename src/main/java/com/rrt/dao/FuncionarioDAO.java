package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {
    Connection connection;
    Logger logger;

    public FuncionarioDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(FuncionarioDAO.class.getName());
    }
    public void add(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cargo, salario, numero_vendas, data_nascimento, cpf, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setInt(4, funcionario.getNumero_vendas());
            stmt.setDate(5, funcionario.getData_nascimento());
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(7, funcionario.getEmail());
            stmt.setString(8, funcionario.getSenha());
            stmt.execute();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ? , salario = ?, numero_vendas = ?, data_nascimento = ?, cpf = ?, senha = ?, email = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setInt(4, funcionario.getNumero_vendas());
            stmt.setDate(5, funcionario.getData_nascimento());
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(7, funcionario.getSenha());
            stmt.setString(8, funcionario.getEmail());
            stmt.setInt(9, funcionario.getId());
            stmt.executeUpdate();
        }catch(SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        Funcionario funcionario = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getInt("salario"));
                funcionario.setNumero_vendas(rs.getInt("numero_vendas"));
                funcionario.setData_nascimento(rs.getDate("data_nascimento"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setId(rs.getInt("id"));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return funcionario;
    }
}
