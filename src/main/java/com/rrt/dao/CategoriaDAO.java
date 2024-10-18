package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            e.printStackTrace();
        }
    }


}
