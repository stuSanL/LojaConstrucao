<%@ page import="com.rrt.models.Cliente" %>
<%@ page import="java.util.List" %>
<%@ page import="com.rrt.models.Produto" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>

<h1>Lista de Produtos</h1>
<form method="get" action="produto" name="buscarPorId">
    <input type="hidden" name="acao" value="buscarPorId"/>
    ID <input type="number" name="id"/>
    <input type="submit" value="Buscar"/>
</form>
<br>
<h1>Manter Produtos</h1>
<form method="get" action="produto" name="listarProdutos">
    <table style="width: 90%" border="1">
        <thead>
        <tr>
            <td>ID</td>
            <td>Nome</td>
            <td>Preço</td>
            <td>Categoria</td>
            <td>Marca</td>
            <td>Especificações</td>
            <td>Disponibilidade</td>
            <td>Ação</td>
        </tr>
        </thead>
        <tbody>
        <%
            DecimalFormat dfmt = new DecimalFormat("#.##");
            List<Produto> listaProdutos = (List<Produto>) request.getAttribute("listaProdutos");
            for(Produto produto : listaProdutos){
        %>
        <tr>
            <td><%=produto.getId()%></td>
            <td><%=produto.getNome()%></td>
            <td>R$<%=dfmt.format(produto.getPreco())%></td>
            <td><%=produto.getCategoria().getNome()%></td>
            <td><%=produto.getMarca().getNome()%></td>
            <td><%=produto.getEspecificacoes()%></td>
            <td><%=produto.getDisponibilidade()%></td>
            <td>Atualizar Deletar</td>
        </tr>
        <%}%>
        </tbody>
        <tfoot>
        <td colspan="8"><a href="LojaContrucao/produto?acao=criar"><center>Incluir novo produto</center></a> </td>
        </tfoot>
    </table>
</form>
</body>
<p>
    <a href="index.html">Menu</a>
</p>
</html>