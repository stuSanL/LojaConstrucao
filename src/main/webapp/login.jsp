<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Login</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='/css/login.css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
    
    <a href="/index.html">Voltar</a>
    
    <div class="body">
        <div class="lado-esquerdo">

        </div>
        <div class="lado-direito">
            <form name="buscarCPF" action="LoginController" method="GET">
                <table>
                    <div class="login">
                        <div class="tipo">
                            <h1 class="E">Entrar</h1>
                            <input id="checkbox" type="checkbox">
                            <h1 class="C">Cadastre-se</h1>
                        </div>
                        <div id="entrar">
                            <div class="campo">
                                <input id="cpf1" class="dados" type="text"  name="cpf" size="10" maxlength="80" required/>
                                <label for="cpf1">CPF:</label>
                            </div>
                            <div class="campo">
                                <input id="senha1" class="dados" type="password" name="senha" id="senha" size="10" maxlength="15" required/>
                                <label for="senha1">Senha:</label>
                            </div>
                        </div>
                        <div id="cadastro">
                            <div class="campo c1">
                                <input id="nome" class="dados" type="text" name="cpf" id="cpf" size="10" maxlength="80" required/>
                                <label for="nome">Nome:</label>
                            </div>
                            <div class="campo">
                                <input id="email" class="dados" type="text" name="senha" id="senha" size="10" maxlength="60" required/>
                                <label for="email">E-mail:</label>
                            </div>
                            <div class="campo">
                                <input id="telefone" class="dados" type="text" name="senha" id="senha" size="10" maxlength="60" required/>
                                <label for="telefone">Telefone:</label>
                            </div>
                            <div class="campo">
                                <input id="cep" class="dados" type="text" name="senha" id="senha" size="10" maxlength="60" required/>
                                <label for="cep">CEP:</label>
                            </div>
                            <div class="campo">
                                <input id="bairro" class="dados" type="text" name="senha" id="senha" size="10" maxlength="60" required/>
                                <label for="bairro">Bairro:</label>
                            </div>
                            <div class="campo">
                                <input id="cpf2" class="dados" type="text" name="cpf" id="cpf" size="10" maxlength="15" required/>
                                <label for="cpf2">CPF:</label>
                            </div>
                            <div class="campo">
                                <input id="senha2" class="dados" type="password" name="cpf" id="cpf" size="10" maxlength="15" required/>
                                <label for="senha2">Senha:</label>
                            </div>
                            <div class="campo">
                                <input id="senha3" class="dados" type="password" name="cpf" id="cpf" size="10" maxlength="15" required/>
                                <label for="senha3">Confirmação de senha:</label>
                            </div>
                        </div>
                        
                        <input class="logar" id="be" type="submit" value="Entrar" />
                        <input class="logar" id="bc" type="submit" value="Cadastrar" />
                    </div>
                    
                
                </table>
            </form>
        </div>
    </div>
    
        <script src="/js/funcao-login.js"></script>
        
        <script src="/js/input.js"></script>
        
</body>
</html>
