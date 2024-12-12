package com.rrt.controller;

import com.rrt.dao.ClienteDAO;
import com.rrt.models.Cliente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;*/

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class ClienteController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    private final ClienteDAO clienteDAO;
    private static final String MANTER_CLIENTE = "manterCliente.jsp";
    private static final String LISTAR_CLIENTES = "listarClientes.jsp";
    private static final Logger logger = Logger.getLogger(ClienteController.class.getName());

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
        } else if(acao.equalsIgnoreCase("listarTodos")){
            logger.info("Iniciando listarTodos");
            List<Cliente> listaClientes = clienteDAO.findAll();
            request.setAttribute("listaClientes", listaClientes);
            String teste = "está ok";
            request.setAttribute("teste", teste);
            logger.info("requests feitas. \nNº de Clientes: " + listaClientes.size() + "\nTeste: " + teste);
            avancar = LISTAR_CLIENTES;
        } else {
            logger.info("Iniciando else");
            List<Cliente> listaClientes = clienteDAO.findAll();
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("teste", "está ok");
            logger.info("requests feitas");
            avancar = LISTAR_CLIENTES;
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);
        logger.info("avançando para " + avancar);
    }
}