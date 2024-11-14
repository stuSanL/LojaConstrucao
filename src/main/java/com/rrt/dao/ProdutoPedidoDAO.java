package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Produto;
import com.rrt.models.ProdutoPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoPedidoDAO {

    Connection connection;
    Logger logger;
    ProdutoDAO produtoDAO;
    PedidoDAO pedidoDAO;

    public ProdutoPedidoDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(ProdutoPedidoDAO.class.getName());
        this.produtoDAO = new ProdutoDAO();
        this.pedidoDAO = new PedidoDAO();
    }

    public void add(ProdutoPedido produtoPedido) {
        String sql = "INSERT INTO produto_pedido (id_pedido, id_produto, quantidade) VALUES (?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produtoPedido.getPedido().getId());
            stmt.setInt(2, produtoPedido.getProduto().getId());
            stmt.setInt(3, produtoPedido.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void update(int id, int id_pedido, int id_produto, int quantidade) {
        String sql = "UPDATE produto_pedido SET id_pedido =?, id_produto = ?, quantidade = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id_pedido);
            stmt.setInt(2, id_produto);
            stmt.setInt(3, quantidade);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM produto_pedido WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public List<ProdutoPedido> findByPedidoId(int id) {
        String sql = "SELECT * FROM produto_pedido WHERE id_pedido = ?";
        List<ProdutoPedido> produtoPedidos = new ArrayList<ProdutoPedido>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ProdutoPedido produtoPedido = new ProdutoPedido(
                        rs.getInt("id"),
                        produtoDAO.findById(rs.getInt("id_produto")),
                        pedidoDAO.findById(rs.getInt("id_pedido")),
                        rs.getInt("quantidade")
                );
                produtoPedidos.add(produtoPedido);
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtoPedidos;
    }

    public List<ProdutoPedido> findByProdutoId(int id) {
        String sql = "SELECT * FROM produto_pedido WHERE id_produto = ?";
        List<ProdutoPedido> produtoPedidos = new ArrayList<ProdutoPedido>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ProdutoPedido produtoPedido = new ProdutoPedido(
                        rs.getInt("id"),
                        produtoDAO.findById(rs.getInt("id_produto")),
                        pedidoDAO.findById(rs.getInt("id_pedido")),
                        rs.getInt("quantidade")
                );
                produtoPedidos.add(produtoPedido);
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtoPedidos;
    }

    public double PedidoTotalPrice(int id) {
        double precoTotal = 0;
        List<ProdutoPedido> produtoPedidos = this.findByPedidoId(id);
        for(ProdutoPedido produtoPedido : produtoPedidos){
            precoTotal += produtoPedido.getQuantidade() * produtoPedido.getProduto().getPreco();
        }
        return precoTotal;
    }


}
