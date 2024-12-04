package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Avaliacoes;
import com.rrt.models.Produto;
import com.rrt.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvaliacoesDAO {

    private Connection connection;
    private Logger logger;
    private ProdutoDAO produtoDAO;
    private ClienteDAO clienteDAO;

    public AvaliacoesDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(AvaliacoesDAO.class.getName());

    }

    public void add(Avaliacoes avaliacoes) {
        String sql = "INSERT INTO avaliacoes (id_produto, id_cliente, classificacao, cometario, data) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, avaliacoes.getProduto().getId());
            stmt.setInt(2, avaliacoes.getCliente().getId());
            stmt.setInt(3, avaliacoes.getClassificacao());
            stmt.setString(4, avaliacoes.getComentario());
            stmt.setDate(5, new Date(avaliacoes.getData().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar avaliação", e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM avaliacoes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar avaliação com ID: " + id, e);
        }
    }

    public void update(Avaliacoes avaliacoes) {
        String sql = "UPDATE avaliacoes SET id_produto = ?, id_cliente = ?, classificacao = ?, cometario = ?, data = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, avaliacoes.getProduto().getId());
            stmt.setInt(2, avaliacoes.getCliente().getId());
            stmt.setInt(3, avaliacoes.getClassificacao());
            stmt.setString(4, avaliacoes.getComentario());
            stmt.setString(5,String.valueOf(avaliacoes.getData().getTime()));
            stmt.setInt(6, avaliacoes.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar avaliação com ID: " + avaliacoes.getId(), e);
        }
    }

    public Avaliacoes findById(int id) {
        String sql = "SELECT * FROM avaliacoes WHERE id = ?";
        Avaliacoes avaliacoes = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto produto = produtoDAO.findById(rs.getInt("produto_id"));
                Cliente cliente = clienteDAO.findById(rs.getInt("cliente_id"));
                avaliacoes = new Avaliacoes(
                        rs.getInt("id"),
                        produtoDAO.findById(rs.getInt("id_produto")),
                        clienteDAO.findById(rs.getInt("id_cliente")),
                        rs.getInt("classificacao"),
                        rs.getString("comentario"),
                        rs.getDate("data")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar avaliação com ID: " + id, e);
        }
        return avaliacoes;
    }

    public List<Avaliacoes> findAll() {
        String sql = "SELECT * FROM avaliacoes";
        List<Avaliacoes> avaliacoes = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = produtoDAO.findById(rs.getInt("produto_id"));
                Cliente cliente = clienteDAO.findById(rs.getInt("cliente_id"));
                avaliacoes.add(new Avaliacoes(
                        rs.getInt("id"),
                        produtoDAO.findById(rs.getInt("id_produto")),
                        clienteDAO.findById(rs.getInt("id_cliente")),
                        rs.getInt("classificacao"),
                        rs.getString("comentario"),
                        Date.valueOf(rs.getString("data"))
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar todas as avaliações", e);
        }
        return avaliacoes;
    }


}

