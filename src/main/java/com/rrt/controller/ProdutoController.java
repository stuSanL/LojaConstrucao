package com.rrt.controller;

import com.rrt.dao.CategoriaDAO;
import com.rrt.dao.MarcaDAO;
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
    private final CategoriaDAO categoriaDAO;
    private final MarcaDAO marcaDAO;
    private static final String MANTER_PRODUTO = "manterProduto.jsp";
    private static final String LISTAR_PRODUTOS = "listarProdutos.jsp";
    private static final String INDEX = "LojaConstrucao/index.html";
    private static final Logger logger = Logger.getLogger(ProdutoController.class.getName());

    public ProdutoController (){
        super();
        this.produtoDAO = new ProdutoDAO();
        this.categoriaDAO = new CategoriaDAO();
        this.marcaDAO = new MarcaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String avancar = "";

        if(acao == null){
            avancar = LISTAR_PRODUTOS;
        }else if(acao.equalsIgnoreCase("criar")){
            request.setAttribute("listaProdutos", produtoDAO.findAll());
            avancar = MANTER_PRODUTO;
        }else if(acao.equalsIgnoreCase("buscarPorId")){
            String idS = request.getParameter("id");
            if(idS != null && !idS.isEmpty()){
                int id = Integer.parseInt(idS);
                List<Produto> listaProdutos = new ArrayList<>();
                listaProdutos.add(produtoDAO.findById(id));
                request.setAttribute("listaProdutos", listaProdutos);
                avancar = "listarProdutos.jsp";
            } else {
                logger.info(request.getRequestURI());
                request.setAttribute("listaProdutos", produtoDAO.findAll());
                avancar = "listarProdutos.jsp";
            }
        } else if(acao.equalsIgnoreCase("listarProdutos")){
            request.setAttribute("listaProdutos", produtoDAO.findAll());
            avancar = LISTAR_PRODUTOS;
        } else if(acao.equalsIgnoreCase("atualizar")){
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String preco = request.getParameter("preco");
            String categoria_id = request.getParameter("categoria_id");
            String marca_id = request.getParameter("marca_id");
            String especificacoes = request.getParameter("especificacoes");
            String disponibilidade = request.getParameter("disponibilidade");
            Produto produto = new Produto(
                    Integer.parseInt(id),
                    nome,
                    Double.parseDouble(preco),
                    categoriaDAO.findById(Integer.parseInt(categoria_id)),
                    marcaDAO.findById(Integer.parseInt(marca_id)),
                    especificacoes,
                    disponibilidade
            );
            request.setAttribute("produto", produto);
            request.setAttribute("listaProdutos", produtoDAO.findAll());
            avancar = MANTER_PRODUTO;
        } else {
            logger.info("Caiu no else");
            avancar="";
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String avancar ="";

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        String categoria_id = request.getParameter("categoria_id");
        String marca_id = request.getParameter("marca_id");
        String especificacoes = request.getParameter("especificacoes");
        String disponibilidade = request.getParameter("disponibilidade");

        if(id == null || id.isEmpty()){
            Produto produto = new Produto(
                    nome,
                    Double.parseDouble(preco),
                    categoriaDAO.findById(Integer.parseInt(categoria_id)),
                    marcaDAO.findById(Integer.parseInt(marca_id)),
                    especificacoes,
                    disponibilidade
            );
            produtoDAO.add(produto);
            avancar = LISTAR_PRODUTOS;
        } else {
            Produto produto = new Produto(
                    Integer.parseInt(id),
                    nome,
                    Double.parseDouble(preco),
                    categoriaDAO.findById(Integer.parseInt(categoria_id)),
                    marcaDAO.findById(Integer.parseInt(marca_id)),
                    especificacoes,
                    disponibilidade
            );
            produtoDAO.update(produto);
            avancar = LISTAR_PRODUTOS;
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);
    }

}

