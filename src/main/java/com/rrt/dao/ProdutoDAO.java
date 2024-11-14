package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {

    Connection connection;
    Logger logger;
    CategoriaDAO categoriaDAO;
    MarcaDAO marcaDAO;

    public ProdutoDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(ProdutoDAO.class.getName());
        this.categoriaDAO = new CategoriaDAO();
        this.marcaDAO = new MarcaDAO();
    }

    public void add(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, categoria_id, marca_id, especificacoes, disponibilidade) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getCategoria().getId());
            stmt.setInt(4, produto.getMarca().getId());
            stmt.setString(5, produto.getEspecificacoes());
            stmt.setString(6, produto.getDisponibilidade());
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void deleteById(int id){
        String sql = "DELETE FROM produto WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void update(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, preco = ?, categoria_id = ?, marca_id = ?, especificacoes = ?, disponibilidade = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getCategoria().getId());
            stmt.setInt(4, produto.getMarca().getId());
            stmt.setString(5, produto.getEspecificacoes());
            stmt.setString(6, produto.getDisponibilidade());
            stmt.setInt(7, produto.getId());
            stmt.executeUpdate();
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public Produto findById(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        Produto produto = null;
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getFloat("preco"),
                    categoriaDAO.findById(rs.getInt("categoria_id")),
                    marcaDAO.findById(rs.getInt("marca_id")),
                    rs.getString("especificacoes"),
                    rs.getString("disponibilidade")
            );
        }catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return produto;
    }

    public List<Produto> findAll() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<Produto>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public List<Produto> findByCategoria(int id) {
        String sql = "SELECT * FROM produto WHERE categoria_id = ?";
        List<Produto> produtos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public List<Produto> findByMarca(int id) {
        String sql = "SELECT * FROM produto WHERE marca_id = ?";
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public List<Produto> findLikeNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome like ?";
        List<Produto> produtos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public List<Produto> findUpToPreco(Double preco) {
        String sql = "SELECT * FROM produto WHERE preco <= ? ORDER BY preco";
        List<Produto> produtos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setDouble(1, preco);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public List<Produto> findAbovePreco(Double preco) {
        String sql = "SELECT * FROM produto WHERE preco >= ?";
        List<Produto> produtos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setDouble(1, preco);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public List<Produto> ListByPrecoAsc() {
        String sql = "SELECT * FROM produto ORDER BY preco";
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }

    public List<Produto> ListByPrecoDesc() {
        String sql = "SELECT * FROM produto ORDER BY preco DESC";
        List<Produto> produtos = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        categoriaDAO.findById(rs.getInt("categoria_id")),
                        marcaDAO.findById(rs.getInt("marca_id")),
                        rs.getString("especificacoes"),
                        rs.getString("disponibilidade")
                ));
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return produtos;
    }
}
