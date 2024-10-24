package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO {

    Connection connection;

    public CategoriaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void add(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.execute();
        } catch (SQLException e){
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void alterarNome(String nome, int id) throws SQLException {
        String sql ="UPDATE categoria SET nome = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e){
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e){
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        Categoria categoria = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
            }
        } catch (SQLException e){
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return categoria;
    }


}
