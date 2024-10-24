package com.rrt.dao;

import com.rrt.Connection.ConnectionFactory;
import com.rrt.models.Consulta;
import com.rrt.models.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaDAO {
    Connection connection;
    Logger logger;
    ClienteDAO clienteDAO = new ClienteDAO();
    public ConsultaDAO() {
        this.connection = ConnectionFactory.getConnection();
        this.logger = Logger.getLogger(ConsultaDAO.class.getName());
    }

    public void add(Consulta consulta) {
        String sql = "INSERT INTO consulta (id_cliente, id_funcionario, data, confirmacao, horario) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getCliente().getId());
            stmt.setInt(2, consulta.getFuncionario().getId());
            stmt.setDate(3, consulta.getData());
            stmt.setString(4, consulta.getConfirmacao());
            stmt.setString(5, consulta.getHorario());
            stmt.executeUpdate();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void alterar(Consulta consulta) {
        String sql = "UPDATE consulta SET id_cliente = ?, id_funcionario = ?, data = ?, confirmacao = ?, horario = ? WHERE id = ? ";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, consulta.getCliente().getId());
            stmt.setInt(2, consulta.getFuncionario().getId());
            stmt.setString(3, String.valueOf(consulta.getData()));
            stmt.setString(4, String.valueOf(consulta.getConfirmacao()));
            stmt.setString(5, String.valueOf(consulta.getHorario()));
            stmt.setInt(6, consulta.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM consulta WHERE id = ? ";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    public List<Consulta> findAllByCliente(int id_cliente){
        List<Consulta> listaConsultasCliente = new ArrayList<Consulta>();
        String sql = "SELECT * FROM consulta WHERE id_cliente = ? ";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id_cliente);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                //consulta.setCliente(clienteDAO.findById(rs.getInt("id_cliente")));
                //consulta.setFuncionario(funcionarioDAO.findById(rs.getInt("id_funcionario")));
                consulta.setData(rs.getDate("data"));
                consulta.setConfirmacao(rs.getString("confirmacao"));
                consulta.setHorario(rs.getString("horario"));
                listaConsultasCliente.add(consulta);
            }
        }catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return listaConsultasCliente;
    }

    public List<Consulta> findAllByFuncionario(int id_funcionario){
        String sql = "SELECT * FROM consulta WHERE id_funcionario = ? ";
        List<Consulta> listaConsultasFuncionario = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_funcionario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                //consulta.setCliente(clienteDAO.findById(rs.getInt("id_cliente")));
                //consulta.setFuncionario(funcionarioDAO.findById(rs.getInt("id_funcionario")));
                consulta.setData(rs.getDate("data"));
                consulta.setConfirmacao(rs.getString("confirmacao"));
                consulta.setHorario(rs.getString("horario"));
                listaConsultasFuncionario.add(consulta);
            }
        }catch(SQLException e){
                logger.log(Level.SEVERE, null, e);
        }
        return listaConsultasFuncionario;
    }

    public List<Consulta> findAll(){
        String sql = "SELECT * FROM consulta ";
        List<Consulta> listaConsultas = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                //consulta.setCliente(clienteDAO.findById(rs.getInt("id_cliente")));
                //consulta.setFuncionario(funcionarioDAO.findById(rs.getInt("id_funcionario")));
                consulta.setData(rs.getDate("data"));
                consulta.setConfirmacao(rs.getString("confirmacao"));
                consulta.setHorario(rs.getString("horario"));
                listaConsultas.add(consulta);
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE, null, e);
        }
        return listaConsultas;
    }
}
