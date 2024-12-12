<%@ page import="com.rrt.models.Produto" %>
<%@ page import="com.rrt.models.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rrt.dao.CategoriaDAO" %><%--
  Created by IntelliJ IDEA.
  User: tmmds
  Date: 12/12/2024
  Time: 07:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manter produto</title>
</head>
<body>
<%
Produto produto = (Produto) request.getAttribute("produto");
%>
<h1>Manter Produto</h1>
<form name="manterProduto" method="post" action="produto">
    <table>
        <tr>
            <td><label for="id">ID</label></td>
            <td>
                <input id="id" type="text" readonly="readonly" name="id" size="10" maxlength="10"
                value="<%=produto.getId()%>">
            </td>
        </tr>
        <tr>
            <td><label for="nome">Nome</label></td>
            <td>
                <input id="nome" type="text" value="<%=produto.getNome()%>" name="nome" size="50">
            </td>
        </tr>
        <tr>
            <td><label for="preco">Preco</label></td>
            <td><input id="preco" type="text" size="50" name="preco" value="<%=produto.getPreco()%>"></td>
        </tr>
        <tr>
            <td><label for="categorias">Categoria</label></td>
            <td> <select name="categoria_id" id="categorias">
                <%
                    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                    for (Categoria categoria : categorias) {
                %>
                <option value="<%=categoria.getId()%>"><%=categoria.getNome()%></option>
                <%}%>
            </select> </td>
        </tr>



    </table>
</form>
</body>
</html>
