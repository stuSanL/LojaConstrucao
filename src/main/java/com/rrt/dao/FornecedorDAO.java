package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDAO {

    private Connection connection;
    private Logger logger;

    public FornecedorDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(FornecedorDAO.class.getName());
    }

    public void add(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (nome, cnpj, telefone, email, cep, rua, numero, complemento, bairro, data_cadastro) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getCep());
            stmt.setString(6, fornecedor.getRua());
            stmt.setString(7, fornecedor.getNumero());
            stmt.setString(8, fornecedor.getComplemento());
            stmt.setString(9, fornecedor.getBairro());
            stmt.setString(10, String.valueOf(fornecedor.getData_cadastro()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar fornecedor", e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM fornecedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar fornecedor com ID: " + id, e);
        }
    }

    public void update(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET nome = ?, cnpj = ?, telefone = ?, email = ?, cep = ?, rua = ?, " +
                "numero = ?, complemento = ?, bairro = ?, data_cadastro = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getCep());
            stmt.setString(6, fornecedor.getRua());
            stmt.setString(7, fornecedor.getNumero());
            stmt.setString(8, fornecedor.getComplemento());
            stmt.setString(9, fornecedor.getBairro());
            stmt.setString(10, String.valueOf(fornecedor.getData_cadastro().getTime()));
            stmt.setInt(11, fornecedor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar fornecedor com ID: " + fornecedor.getId(), e);
        }
    }

    public Fornecedor findById(int id) {
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
        Fornecedor fornecedor = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        Date.valueOf(rs.getString("data_cadastro")));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar fornecedor com ID: " + id, e);
        }
        return fornecedor;
    }

    public List<Fornecedor> findAll() {
        String sql = "SELECT * FROM fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornecedores.add(new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        Date.valueOf(rs.getString("data_cadastro"))
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar todos os fornecedores", e);
        }
        return fornecedores;
    }
}
