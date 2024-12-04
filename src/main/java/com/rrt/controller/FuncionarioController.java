package com.rrt.controller;

import com.rrt.dao.FuncionarioDAO;
import com.rrt.models.Funcionario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CADASTRAR = "manterFuncionario.jsp";
    private static final String LISTAR = "listarFuncionarios.jsp";
    final FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        super();
        this.funcionarioDAO = new FuncionarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String acao=request.getParameter("acao");
        String avancar = "";

        if(acao.equalsIgnoreCase("cadastrar")) {
            avancar = CADASTRAR;
        } else if(acao.equalsIgnoreCase("listarTodos")) {
            List<Funcionario> listaFuncionarios = funcionarioDAO.findAll();
            request.setAttribute("listaFuncionarios", listaFuncionarios);
            avancar = LISTAR;
        } else if(acao.equalsIgnoreCase("buscarPorId")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Funcionario funcionario = funcionarioDAO.findById(id);
            List<Funcionario> listaFuncionarios = new ArrayList<>();
            listaFuncionarios.add(funcionario);
            request.setAttribute("listaFuncionarios", listaFuncionarios);
            avancar = LISTAR;
        } else if(acao.equalsIgnoreCase("buscarPorCPF")){
            String cpf = request.getParameter("cpf");
            Funcionario funcionario = funcionarioDAO.findByCPF(cpf);
            List<Funcionario> listaFuncionarios = new ArrayList<>();
            listaFuncionarios.add(funcionario);
            request.setAttribute("listaFuncionarios", listaFuncionarios);
            avancar = LISTAR;
        } else {
            List<Funcionario> listaFuncionarios = funcionarioDAO.findAll();
            request.setAttribute("listaFuncionarios", listaFuncionarios);
            avancar = LISTAR;
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);
    }
}
