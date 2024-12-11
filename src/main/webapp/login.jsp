<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<h1>LISTA DE PESSOAS</h1>
<br>
<br>
<form name="buscarCPF" action="login" method="GET">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="hidden" name="acao" value="buscarPorCPF" /></td>
            <td>CPF<input type="text" name="cpf" size="11" maxlength="11"/></td>
            <td>SENHA<input type="text" name="senha" size="10" maxlength="10"/></td>


            <td><input type="submit" value="Buscar" /></td>
        </tr>
    </table>
</form>
<tfoot>
<tr>
    <td colspan='5'><a href="login?acao=criar">Cadastre_se</a></td>
</tr>
</tfoot>
<p>
    <a href="index.html">VOLTAR MENU</a>
</p>

</body>
</html>
