<%@ page import="com.rrt.models.Funcionario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tmmds
  Date: 22/11/2024
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Funcionarios</title>
</head>
<body>
<h1>Listar Funcionarios</h1>
<form name="buscarPorId" method="get" action="funcionarios">
  <input type="hidden" name="acao" value="buscarPorId">
  <label>ID <input type="number" name="id"></label>
    <input type="submit" value="Buscar"/>
</form>
<form name="buscarPorCPF" method="get" action="funcionarios">
    <input type="hidden" name="acao" value="buscarPorCPF">
    <label>CPF <input type="text" name="cpf"> <!--pattern="\d{3}.\d{3}.\d{3}-\d{2}"--></label>
    <input type="submit" value="Buscar">
</form>
<h1>Manter Funcionarios</h1>
<form method="get" name="listarFuncionarios" action="funcionarios">
    <table border="1" width="90%">
        <thead>
        <tr>
            <td>ID</td>
            <td>Nome</td>
            <td>Cargo</td>
            <td>Salario</td>
            <td>Numero de Vendas</td>
            <td>Data de Nascimento</td>
            <td>CPF</td>
            <td>Email</td>
            <td colspan="8">Ação</td>
        </tr>
        </thead>
        <tbody>
        <%
            List<Funcionario> listaFuncionarios = (List<Funcionario>) request.getAttribute("listaFuncionarios");
            for(Funcionario f : listaFuncionarios) {
        %>
        <tr>
            <td><%=f.getId()%></td>
            <td><%=f.getNome()%></td>
            <td><%=f.getCargo()%></td>
            <td><%=f.getSalario()%></td>
            <td><%=f.getNumero_vendas()%></td>
            <td><%=f.getData_nascimento()%></td>
            <td><%=f.getCpf()%></td>
            <td><%=f.getEmail()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</form>
</body>

<a href="index.html">Menu</a>
</html>
