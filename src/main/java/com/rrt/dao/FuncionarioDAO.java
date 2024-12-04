package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<Funcionario> findAll(){
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> funcionarios = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            funcionarios = new ArrayList<Funcionario>();
            while (rs.next()){
                Funcionario funcionario = new Funcionario(
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
                funcionarios.add(funcionario);
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return funcionarios;
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
