package com.rrt.controller;

import com.rrt.dao.ProdutoDAO;
import com.rrt.models.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProdutoController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    private final ProdutoDAO produtoDAO;
    private static final String MANTER_PRODUTO = "manterProduto.jsp";
    private static final String LISTAR_PRODUTO = "listarProdutos.jsp";
    private static final String INDEX = "LojaConstrucao/index.html";
    private static final Logger logger = Logger.getLogger(ProdutoController.class.getName());

    public ProdutoController (){
        super();
        this.produtoDAO = new ProdutoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String avancar = "";

        if(acao.equals("buscarPorId")){
            int id = Integer.parseInt(request.getParameter("id"));
            List<Produto> listaProdutos = new ArrayList<>();
            listaProdutos.add(produtoDAO.findById(id));
            request.setAttribute("listaProdutos", listaProdutos);
            avancar = "listarProdutos.jsp";
        } else if(acao.equalsIgnoreCase("listarProdutos")){
            request.setAttribute("listaProdutos", produtoDAO.findAll());
            avancar = LISTAR_PRODUTO;
        } else {
            logger.info("Caiu no else");
            avancar="";
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);
    }

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String avancar ="";

        if(acao.equals("buscarPorId")){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("produto", produtoDAO.findById(id));
            avancar = "listarProdutos.jsp";
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);
    }*/

}

