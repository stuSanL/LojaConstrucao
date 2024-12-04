package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.ItensLista;
import com.rrt.models.ListaCompras;
import com.rrt.models.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItensListaDAO {

    private Connection connection;
    private ListaComprasDAO listaComprasDAO;
    private Logger logger;
    private ProdutoDAO produtoDAO;

    public ItensListaDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(ItensListaDAO.class.getName());
        this.produtoDAO = new ProdutoDAO();
        this.listaComprasDAO = new ListaComprasDAO();
    }

    public void add(ItensLista itensLista) {
        String sql = "INSERT INTO itens_lista (quantidade, id_lista, id_produto) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, itensLista.getQuantidade());
            stmt.setInt(2, itensLista.getLista().getId());
            stmt.setInt(3, itensLista.getProduto().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar item à lista", e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM itens_lista WHERE id_item = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar item da lista com ID: " + id, e);
        }
    }

    public void update(ItensLista itensLista) {
        String sql = "UPDATE itens_lista SET quantidade = ?, id_lista = ?, id_produto = ? WHERE id_item = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, itensLista.getQuantidade());
            stmt.setInt(2, itensLista.getLista().getId());
            stmt.setInt(3, itensLista.getProduto().getId());
            stmt.setInt(4, itensLista.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar item da lista com ID: " + itensLista.getId(), e);
        }
    }

    public ItensLista findById(int id) {
        String sql = "SELECT * FROM itens_lista WHERE id_item = ?";
        ItensLista itensLista = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            itensLista = new ItensLista(
                    rs.getInt("id_item"),
                    rs.getInt("quantidade"),
                    listaComprasDAO.findById(rs.getInt("id_lista")),
                    produtoDAO.findById(rs.getInt("id_produto"))
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itensLista;
    }

    public List<ItensLista> findAll() {
        String sql = "SELECT * FROM itens_lista";
        List<ItensLista> itensLista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ListaCompras lista = listaComprasDAO.findById(rs.getInt("id_lista"));
                Produto produto = produtoDAO.findById(rs.getInt("produto_id"));
                itensLista.add(new ItensLista(
                        rs.getInt("id"),
                        rs.getInt("quantidade"),
                        lista,
                        produto
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar todos os itens da lista", e);
        }
        return itensLista;
    }




}
