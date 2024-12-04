
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">

    <title>Cadastro do Cliente</title>
</head>
<body>
<h1>Cadastro do Cliente</h1>
<form name="manterPessoa" action="PessoaController" method="POST">
    <table>
        <tr>
            <td>ID</td>
            <td>
                <input type="text" readonly="readonly" name="id_pessoa"
                       size="10" maxlength="10" value="<c:out value='${pessoa.id}' />" />
            </td>
        </tr>
        <tr>
            <td>Nome</td>
            <td>
                <input type="text" name="nome" size="50" maxlength="250"
                       value="<c:out value='${pessoa.nome}' />" />
            </td>
        </tr>
        <tr>
            <td>Data Nascimento</td>
            <td>
                <input type="text" name="dataNascimento" size="50"
                       maxlength="250" value="<fmt:formatDate value="${pessoa.dataNascimento}" pattern="dd/MM/yyyy" />" />

            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" size="50" maxlength="250" value="<c:out value='${pessoa.email}' />" />
            </td>
        </tr>
        <tr>
            <td>Telefone</td>
            <td>
                <input type="text" name="telefone" size="50" maxlength="250" value="<c:out value='${pessoa.telefone}' />" />
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Salvar" />
            </td>
            <td>
                <input type="button" value="Voltar" onclick="history.back();" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>
