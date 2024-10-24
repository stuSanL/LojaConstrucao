
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--%@ taglib uri="http://jakarta.ee/jstl/core" prefix="c" %-->
<!--%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %-->
<!doctype html>
<html lang="pt">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>Listar Clientes</title>
</head>
<body>
<h1>Listar Telefones</h1>
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
            </tr>
            </thead>
            <tbody>
            <td>Teste: ${teste} <%= request.getParameter("teste")%> </td>
            <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.id}"/></td>
                    <td><c:out value="${cliente.nome}"/></td>
                    <td><c:out value="${cliente.cpf}"/></td>
                    <td><c:out value="${cliente.dataNascimento}"/></td>
                    <td><c:out value="${cliente.email}"/></td>
                    <td><c:out value="${cliente.telefone}"/></td>
                    <td><c:out value="${cliente.cep}"/></td>
                    <td><c:out value="${cliente.rua}"/> <c:out value="${cliente.numero}"/>
                        <c:out value="${cliente.complemento}"/> <c:out value="${cliente.bairro}"/> </td>
                </tr>
            </c:forEach>
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