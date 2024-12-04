package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Cliente;
import com.rrt.models.ListaCompras;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaComprasDAO {

    private Connection connection;
    private Logger logger;
    private ClienteDAO clienteDAO;

    public ListaComprasDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(ListaComprasDAO.class.getName());
        this.clienteDAO = new ClienteDAO();
    }

    public void add(ListaCompras listaCompras) {
        String sql = "INSERT INTO lista_compras (id_cliente, data_criacao, compartilhada_com) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, listaCompras.getCliente().getId());
            stmt.setString(2, String.valueOf(listaCompras.getData_criacao().getTime()));
            stmt.setString(3, listaCompras.getCompartilhada_com());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar lista de compras", e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM lista_compras WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar lista de compras com ID: " + id, e);
        }
    }

    public void update(ListaCompras listaCompras) {
        String sql = "UPDATE lista_compras SET id_cliente = ?, data_criacao = ?, compartilhada_com = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, listaCompras.getCliente().getId());
            stmt.setString(2, String.valueOf(listaCompras.getData_criacao()));
            stmt.setString(3, listaCompras.getCompartilhada_com());
            stmt.setInt(4, listaCompras.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar lista de compras com ID: " + listaCompras.getId(), e);
        }
    }

    public ListaCompras findById(int id) {
        String sql = "SELECT * FROM lista_compras WHERE id = ?";
        ListaCompras listaCompras = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = clienteDAO.findById(rs.getInt("cliente_id"));
                listaCompras = new ListaCompras(
                        rs.getInt("id"),
                        cliente,
                        rs.getDate("data_criacao"),
                        rs.getString("compartilhada_com")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar lista de compras com ID: " + id, e);
        }
        return listaCompras;
    }

    public List<ListaCompras> findAll() {
        String sql = "SELECT * FROM lista_compras";
        List<ListaCompras> listas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = clienteDAO.findById(rs.getInt("cliente_id"));
                listas.add(new ListaCompras(
                        rs.getInt("id"),
                        cliente,
                        rs.getDate("data_criacao"),
                        rs.getString("compartilhada_com")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar todas as listas de compras", e);
        }
        return listas;
    }

    public List<ListaCompras> findByCliente(int clienteId) {
        String sql = "SELECT * FROM lista_compras WHERE id_cliente = ?";
        List<ListaCompras> listas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = clienteDAO.findById(rs.getInt("cliente_id"));
                listas.add(new ListaCompras(
                        rs.getInt("id"),
                        cliente,
                        rs.getDate("data_criacao"),
                        rs.getString("compartilhada_com")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar listas de compras por cliente com ID: " + clienteId, e);
        }
        return listas;
    }
}
