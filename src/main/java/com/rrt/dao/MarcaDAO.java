package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Categoria;
import com.rrt.models.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarcaDAO {

    Connection connection;
    Logger logger;

    public MarcaDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(MarcaDAO.class.getName());
    }

    public void add(Marca marca){
            String sql = "INSERT INTO marca (nome) VALUES (?)";
            try(PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, marca.getNome());
                stmt.execute();
            } catch (SQLException e){
                logger.log(Level.SEVERE, null, e);
            }
    }

    public void updateNome(String nome, int id) {
        String sql ="UPDATE marca SET nome = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM marca WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public Marca findById(int id) {
        String sql = "SELECT * FROM marca WHERE id = ?";
        Marca marca = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            marca = new Marca(
                    rs.getInt("id"),
                    rs.getString("nome")
            );
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return marca;
    }

    public List<Marca> findAll() {
        String sql = "SELECT * FROM marca";
        List<Marca> marcas = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                marcas.add(new Marca(
                        rs.getInt("id"),
                        rs.getString("nome")
                ));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return marcas;
    }

    public List<Marca> findByNome(String nome) {
        String sql = "SELECT * FROM marca WHERE nome like ?";
        List<Marca> marcas = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                marcas.add(new Marca(
                        rs.getInt("id"),
                        rs.getString("nome")
                ));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return marcas;
    }
}
