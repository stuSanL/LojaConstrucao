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
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ClienteDAO clienteDAO;
    private static final String MANTER_CLIENTE = "manterCliente.jsp";
    private static final String LISTAR_CLIENTES = "listarClientes.jsp";
    private static final String CADASTRO_CLIENTE = "cadastroCliente.jsp";
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


    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String cep = request.getParameter("cep");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String data_nascimento = request.getParameter("data_nascimento");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");



        if (id.isEmpty()) {

            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setSenha(senha);
            cliente.setTelefone(telefone);
            cliente.setCep(cep);
            cliente.setBairro(bairro);
            cliente.setComplemento(complemento);
            cliente.setEmail(email);
            cliente.setNumero(numero);
            cliente.setRua(rua);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(data_nascimento, formatter);
            cliente.setData_nascimento(Date.valueOf(localDate));

            try {
                clienteDAO.add(cliente);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            request.setAttribute("listaClientes", clienteDAO.findAll());

            RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_CLIENTES);

            pagina.forward(request, response);

        } else {

            Cliente cliente = new Cliente();

            cliente.setId(Integer.parseInt(id));
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate locaDate = LocalDate.parse(data_nascimento, formato);
            cliente.setData_nascimento(Date.valueOf(locaDate));

            clienteDAO.updateById(cliente);
            request.setAttribute("listaCliente", clienteDAO.findAll());
            RequestDispatcher pagina = request.getRequestDispatcher(LISTAR_CLIENTES);
            pagina.forward(request, response);

        }

    }
    }


