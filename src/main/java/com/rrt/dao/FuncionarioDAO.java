package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Funcionario;

import java.sql.*;
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

    public Funcionario findById(int id) {
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

    public Funcionario findByCPF(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";
        Funcionario funcionario = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            funcionario = new Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cargo"),
                    rs.getFloat("salario"),
                    rs.getInt("numero_vendas"),
                    Date.valueOf(rs.getString("data_nascimento")),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("senha")
            );
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return funcionario;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void update(Funcionario funcionario) {
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

    public void updateSenha(String senha) {
        String sql = "UPDATE funcionario SET senha = ? WHERE id = ?";
        try(PreparedStatement stmt  = connection.prepareStatement(sql)){
            stmt.setString(1, senha);
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

}
