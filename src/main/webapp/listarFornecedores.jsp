<%@ page import="com.rrt.models.Fornecedor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fornecedores</title>
</head>
<body>
<h1>Lista de Fornecedores</h1>
<form method="get" action="fornecedor" name="buscarPorId">

</form>
<form method="get" action="fornecedor" name="buscarPorNome">

</form>
<br>
<h1>Manter Produtos</h1>
<form method="get" action="fornecedor" name="listarFornecedores">
    <table style="width: 90%", border="1">
        <thead>
        <tr>
            <td>ID</td>
            <td>Nome</td>
            <td>CNPJ</td>
            <td>Telefone</td>
            <td>Email</td>
            <td>Endereço</td>
            <td>CEP</td>
            <td>Data de Cadastro</td>
            <td colspan="8">Ação</td>
        </tr>
        </thead>
        <tbody>
        <%
            List<Fornecedor> listaFornecedores = (List<Fornecedor>) request.getAttribute("listaFornecedores");
            for(Fornecedor fornecedor : listaFornecedores) {
        %>
        <tr>
            <td><%=fornecedor.getId()%></td>
            <td><%=fornecedor.getNome()%></td>
            <td><%=fornecedor.getCnpj()%></td>
            <td><%=fornecedor.getTelefone()%></td>
            <td><%=fornecedor.getEmail()%></td>
            <td><%=fornecedor.getRua() + " nº" + fornecedor.getNumero() + " " + fornecedor.getComplemento() + " Bairro " + fornecedor.getBairro()%></td>
            <td><%=fornecedor.getCep()%></td>
            <td><%=fornecedor.getData_cadastro()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</form>
</body>
<a href="index.html">Voltar ao Menu</a>
</html>
