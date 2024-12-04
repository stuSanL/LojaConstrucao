package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Cliente;
import com.rrt.models.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//Precisa fazer o ListaCompras primeiro
public class PedidoDAO {

    Connection connection;
    Logger logger;

    public PedidoDAO() {
        this.connection = ConnectionFactory.getConnection();
        logger = Logger.getLogger(PedidoDAO.class.getName());
    }

    public void addPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (id_cliente, data_pedido, hora_pedido, status) " +
                "VALUES (?, ?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setString(2, String.valueOf(pedido.getData_pedido()));
            stmt.setString(3, pedido.getHora_pedido());
            stmt.setString(4, pedido.getStatus());
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public Pedido findById(int id) {
        String sql = "SELECT * FROM pedido WHERE id = ?";
        Pedido pedido = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            ClienteDAO clienteDAO = new ClienteDAO();
            pedido = new Pedido(
                    rs.getInt("id"),
                    clienteDAO.findById(rs.getInt("id_cliente")),
                    Date.valueOf(rs.getString("data_pedido")),
                    rs.getString("hora_pedido"),
                    rs.getString("status")
                    );
        } catch(SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return pedido;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void update(Pedido pedido) {
        String sql = "UPDATE pedido SET id_cliente = ?, data_pedido = ?, hora_pedido = ?," +
                " status = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setString(2, String.valueOf(pedido.getData_pedido()));
            stmt.setString(3, pedido.getHora_pedido());
            stmt.setString(4, pedido.getStatus());
            stmt.setInt(5, pedido.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public List<Pedido> findAll() {
        String sql = "SELECT * FROM pedido";
        List<Pedido> pedidos = new ArrayList<Pedido>();
        Pedido pedido = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.findById(rs.getInt("id_cliente"));
                PedidoDAO pedidoDAO = new PedidoDAO();
                pedido = new Pedido(
                        rs.getInt("id"),
                        clienteDAO.findById(rs.getInt("id_cliente")),
                        Date.valueOf(rs.getString("data_pedido")),
                        rs.getString("hora_pedido"),
                        rs.getString("status")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return pedidos;
    }

    public List<Pedido> findPedidosByCliente(int idCliente) {
        String sql = "SELECT * FROM pedido WHERE id_cliente = ?";
        List<Pedido> pedidos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                PedidoDAO pedidoDAO = new PedidoDAO();
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        clienteDAO.findById(rs.getInt("id_cliente")),
                        Date.valueOf(rs.getString("data_pedido")),
                        rs.getString("hora_pedido"),
                        rs.getString("status")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return pedidos;
    }

    public List<Pedido> findPedidosByStatus(String status) {
        String sql = "SELECT * FROM pedido WHERE status = ?";
        List<Pedido> pedidos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                PedidoDAO pedidoDAO = new PedidoDAO();
                Pedido pedido = new Pedido(
                    rs.getInt("id"),
                    clienteDAO.findById(rs.getInt("id_cliente")), Date.valueOf(rs.getString("data_pedido")),
                    rs.getString("hora_pedido"),
                    rs.getString("status")
                );
                pedidos.add(pedido);
            }
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return pedidos;
    }

    public List<Pedido> findPedidosByData(Date data) {
        String sql = "SELECT * FROM pedido WHERE data_pedido = ?";
        List<Pedido> pedidos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setDate(1, data);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                PedidoDAO pedidoDAO = new PedidoDAO();
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        clienteDAO.findById(rs.getInt("id_cliente")),
                        Date.valueOf(rs.getString("data_pedido")),
                        rs.getString("hora_pedido"),
                        rs.getString("status")
                );
                pedidos.add(pedido);
            }
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return pedidos;
    }


}
