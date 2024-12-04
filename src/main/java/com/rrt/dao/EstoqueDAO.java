package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Cliente;
import com.rrt.models.Estoque;
import com.rrt.models.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstoqueDAO {
    Connection connection;
    Logger logger;

    public EstoqueDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(EstoqueDAO.class.getName());

    }

    public void add(Estoque estoque) throws SQLException {
        String sql = "INSERT INTO estoque (id_produto, quantidade, data_entrada, data_saida) VALUES (?, ?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, estoque.getProduto().getId());
            stmt.setInt(2, estoque.getQuantidade());
            stmt.setString(3, String.valueOf(estoque.getData_entrada()));
            stmt.setString(4, String.valueOf(estoque.getData_saida()));

            stmt.executeUpdate();
        } catch (SQLException e){
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public Estoque findById(int id) {
        String sql = "SELECT * FROM estoque WHERE id = ?";
        Estoque estoque = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                estoque = new Estoque(
                        rs.getInt("id"),
                        produtoDAO.findById(rs.getInt("id_produto")),
                        rs.getInt("quantidade"),
                        Date.valueOf(rs.getString("data_entrada")),
                        Date.valueOf(rs.getString("data_saida"))
                        );
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE,null,e);
        }
        return estoque;
    }

    public void update(Estoque estoque) {
        String sql = "UPDATE estoque SET id_produto = ?, quantidade = ?, data_entrada = ?, data_saida = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, estoque.getProduto().getId());
            stmt.setInt(2, estoque.getQuantidade());
            stmt.setString(3, String.valueOf(estoque.getData_entrada()));
            stmt.setString(4, String.valueOf(estoque.getData_saida()));
            stmt.setInt(5, estoque.getId());

            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void deleteById(int id){
        String sql = "DELETE FROM estoque WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }
    public List<Estoque> findAll() {
        String sql = "SELECT * FROM estoque";
        List<Estoque> estoque = new ArrayList<Estoque>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                estoque.add(new Estoque(
                        rs.getInt("id"),
                        produtoDAO.findById(rs.getInt("id_produto")),
                        rs.getInt("quantidade"),
                        Date.valueOf(rs.getString("data_entrada")),
                        Date.valueOf(rs.getString("data_saida")))
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return estoque;
    }
}
