package com.rrt.controller;


import com.rrt.dao.FornecedorDAO;
import com.rrt.models.Fornecedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class FornecedorController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Logger logger = Logger.getLogger(FornecedorController.class.getName());
    private static final String LISTAR_FORNECEDORES = "listarFornecedores.jsp";
    private FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String avancar = "";

        if(acao.equalsIgnoreCase("buscarPorId")){

        } else if (acao.equalsIgnoreCase("buscarPorNome")){

        } else if (acao.equalsIgnoreCase("listarFornecedores")){
            List<Fornecedor> listaFornecedores = fornecedorDAO.findAll();
            request.setAttribute("listaFornecedores", listaFornecedores);
            avancar = LISTAR_FORNECEDORES;
        } else {
            List<Fornecedor> listaFornecedores = fornecedorDAO.findAll();
            request.setAttribute("listaFornecedores", listaFornecedores);
            avancar = LISTAR_FORNECEDORES;
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
    }
}
