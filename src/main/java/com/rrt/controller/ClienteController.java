package com.rrt.controller;

import com.rrt.dao.ClienteDAO;
import com.rrt.models.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClienteDAO clienteDAO;
    private static final String MANTER_CLIENTE = "manterCliente.jsp";
    private static final String LISTAR_CLIENTES = "listarClientes.jsp";

    public ClienteController() {
        super();
        clienteDAO = new ClienteDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String avancar = "";

        if(acao.equalsIgnoreCase("criar")){
            avancar = MANTER_CLIENTE;
        } else if(acao.equalsIgnoreCase("listarTODOS")){
            List<Cliente> listaClientes = null;
            try {
                listaClientes = clienteDAO.findAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("listaClientes", listaClientes);
            avancar = LISTAR_CLIENTES;
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);

    }
}