package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO {

    Connection connection;
    Logger logger;

    public CategoriaDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(CategoriaDAO.class.getName());
    }

    public void add(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.execute();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void updateNome(String nome, int id){
        String sql ="UPDATE categoria SET nome = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public Categoria findById(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        Categoria categoria = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            categoria = new Categoria(
                    rs.getInt("id"),
                    rs.getString("nome")
            );
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return categoria;
    }

    public List<Categoria> findAll() {
        String sql = "SELECT * FROM categoria";
        List<Categoria> categorias = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categorias.add(new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome")
                ));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return categorias;
    }

    public List<Categoria> findByNome(String nome){
        String sql = "SELECT * FROM categoria WHERE nome like ?";
        List<Categoria> categorias = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categorias.add(new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome")
                ));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return categorias;
    }

}
