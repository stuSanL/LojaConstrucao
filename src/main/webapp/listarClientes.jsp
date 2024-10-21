<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listar Clientes</title>
</head>
<body>
    <h1>Manter Clientes</h1>
    <form name="listaClientes" action="ClienteController" method="GET">
        <table style="width: 90%" border=1>
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
                <td colspan="8">
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.id}"/></td>
                    <td><c:out value="${cliente.nome}"/></td>
                    <td><c:out value="${cliente.cpf}"/></td>
                    <td><c:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy" /></td>
                    <td><c:out value="${cliente.email}"/></td>
                    <td><c:out value="${cliente.telefone}"/></td>
                    <td><c:out value="${cliente.cep}"/></td>
                    <td><c:out value="${cliente.rua}"/> <c:out value="${cliente.numero}"/>
                        <c:out value="complemento"/> <c:out value="bairro"/> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

</body>
</html>