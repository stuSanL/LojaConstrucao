package com.rrt.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:sqlite:./database/BD.db";//jdbc:sqlite:Loja_Construcao/data/mydatabase.db
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASS = "org.sqlite.JDBC";

    // Carrega o driver
    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Falha ao carregar o driver JDBC", e);
        }
    }

    // Método para obter a conexão
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao conectar ao banco de dados", e);
        }
    }

    // Método para fechar a conexão
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
