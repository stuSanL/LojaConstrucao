package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Venda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    private Connection connection;
    private Logger logger;

    public VendaDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(VendaDAO.class.getName());
    }

    public void add(Venda venda) {
        String sql = "INSERT INTO venda (data_venda, total_receita, total_despesas, lucro) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(venda.getData_venda()));
            stmt.setFloat(2, venda.getTotal_receita());
            stmt.setFloat(3, venda.getTotal_despesa());
            stmt.setFloat(4, venda.getLucro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar venda", e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM venda WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar venda com ID: " + id, e);
        }
    }

    public void update(Venda venda) {
        String sql = "UPDATE venda SET data_venda = ?, total_receita = ?, total_despesas = ?, lucro = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(venda.getData_venda()));
            stmt.setFloat(2, venda.getTotal_receita());
            stmt.setFloat(3, venda.getTotal_despesa());
            stmt.setFloat(4, venda.getLucro());
            stmt.setInt(5, venda.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar venda com ID: " + venda.getId(), e);
        }
    }

    public Venda findById(int id) {
        String sql = "SELECT * FROM venda WHERE id = ?";
        Venda venda = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                venda = new Venda(
                        rs.getInt("id"),
                        rs.getDate("data_venda"),
                        rs.getFloat("total_receita"),
                        rs.getFloat("total_despesa"),
                        rs.getFloat("lucro")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar venda com ID: " + id, e);
        }
        return venda;
    }

    public List<Venda> findAll() {
        String sql = "SELECT * FROM venda";
        List<Venda> vendasList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendasList.add(new Venda(
                        rs.getInt("id"),
                        rs.getDate("data_venda"),
                        rs.getFloat("total_receita"),
                        rs.getFloat("total_despesa"),
                        rs.getFloat("lucro")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar todas as vendas", e);
        }
        return vendasList;
    }

    public List<Venda> findByDateRange(Date startDate, Date endDate) {
        String sql = "SELECT * FROM venda WHERE data_venda BETWEEN ? AND ?";
        List<Venda> vendasList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendasList.add(new Venda(
                        rs.getInt("id"),
                        rs.getDate("data_venda"),
                        rs.getFloat("total_receita"),
                        rs.getFloat("total_despesa"),
                        rs.getFloat("lucro")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar vendas por intervalo de datas", e);
        }
        return vendasList;
    }
}
