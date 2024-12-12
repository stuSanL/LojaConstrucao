<%@ page import="com.rrt.models.Cliente" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!doctype html>
<html lang="pt">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>Listar Clientes</title>
</head>
<body>
<h1>Listar Clientes</h1>
<br>
    <h1>Manter Clientes</h1>
    <form name="listarClientes" action="cliente" method="GET">
        <table style="width: 90%" border="1">
            <thead>
            <tr>
                <td>ID</td>
                <td>Nome</td>
                <td>CPF</td>
                <td>Data de Nascimento</td>
                <td>Email</td>
                <td>Telefone</td>
                <td>CEP</td>
                <td>Endereço</td>
                <td colspan="8">Ações</td>
            </tr>
            </thead>
            <tbody>
            <% List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");%>
            <% for(Cliente cliente : listaClientes){ %>
            <tr>
                <td><%=cliente.getId()%></td>
                <td><%=cliente.getNome()%></td>
                <td><%=cliente.getCpf()%></td>
                <td><%=cliente.getData_nascimento()%></td>
                <td><%=cliente.getEmail()%></td>
                <td><%=cliente.getTelefone()%></td>
                <td><%=cliente.getCep()%></td>
                <td><%=cliente.getRua()%> <%=cliente.getNumero()%> <%=cliente.getComplemento()%> <%=cliente.getBairro()%> </td>
            </tr>
            <%}%>
            </tbody>
            <tfoot>
                <td colspan="8"><a href="">Incluir novo cliente</a></td>
            </tfoot>
        </table>
    </form>

</body>

<p>
    <a href="index.html">Menu</a>
</p>
</html>