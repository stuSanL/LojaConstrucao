package com.rrt.controller;

import com.rrt.dao.ClienteDAO;
import com.rrt.models.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ClienteDAO clienteDAO;
    private static final String MANTER_CLIENTE = "manterCliente.jsp";
    private static final String LISTAR_CLIENTES = "listarClientes.jsp";
    private static final String CADASTRO_CLIENTE = "manterCliente.jsp";
    private static final String LOGIN_CLIENTES = "login.jsp";
    private static final String SUCESSO = "sucesso.jsp";
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    public LoginController() {
        super();
        this.clienteDAO = new ClienteDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String avancar = "";

        if(acao.equalsIgnoreCase("criar")){
            avancar = CADASTRO_CLIENTE;
        }
        else if (acao.equalsIgnoreCase("buscarPorCPF")) {

            String cpf = request.getParameter("cpf");
            Cliente cliente = clienteDAO.findbyCPF(cpf);
            String senha = request.getParameter("senha");
            if(senha.equals(cliente.getSenha())){
                avancar = SUCESSO;

            }else{
                avancar = LOGIN_CLIENTES;
            }

        }else {
            logger.info("Iniciando else");
            List<Cliente> listaClientes = clienteDAO.findAll();
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("teste", "está ok");
            logger.info("requests feitas");
            avancar = LOGIN_CLIENTES;
        }

        RequestDispatcher pagina = request.getRequestDispatcher(avancar);
        pagina.forward(request, response);
        logger.info("avançando para " + avancar);
    }

//    @lombok.SneakyThrows
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//
//            throws ServletException, IOException {
//
//        String id_pessoa = request.getParameter("id_pessoa");
//        String nome = request.getParameter("nome");
//        String dataNascimento = request.getParameter("dataNascimento");
//        String email = request.getParameter("email");
//        String telefone = request.getParameter("telefone");
//
//        if (id_pessoa.isEmpty()) {
//
//            Cliente pessoa = new Cliente();
//            pessoa.setNome(nome);
//            pessoa.setEmail(email);
//            pessoa.setTelefone(telefone);
//            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            LocalDate locaDate = LocalDate.parse(dataNascimento, formato);
//            pessoa.setData_nascimento(Date.valueOf(locaDate));
//
//            clienteDAO.add(pessoa);
//
//            request.setAttribute("listaPessoas", clienteDAO.findAll());
//
//            RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_CLIENTES);
//
//            pagina.forward(request, response);
//
//        } else {
//
//            Cliente pessoa = new Cliente();
//
//            pessoa.setId(Integer.parseInt(id_pessoa));
//            pessoa.setNome(nome);
//            pessoa.setEmail(email);
//            pessoa.setTelefone(telefone);
//
//            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            LocalDate locaDate = LocalDate.parse(dataNascimento, formato);
//            pessoa.setData_nascimento(Date.valueOf(locaDate));
//
//            clienteDAO.updateNameById(pessoa);
//            request.setAttribute("listaPessoas", clienteDAO.findAll());
//            RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_PESSOAS);
//            pagina.forward(request, response);
//
//        }
//
//    }
}
