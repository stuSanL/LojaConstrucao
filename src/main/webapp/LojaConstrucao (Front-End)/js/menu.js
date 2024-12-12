var menu = ` 
<head>
<link rel='stylesheet' type='text/css' media='screen' href='/backup/backup-menu.css'>
</head>
<nav id="menu">
        <h1 class="logo-menu"><a class="logo-menu" href="">ConstruMax</a></h1>
        <div class="area-pesquisa">
            <input class="barra-pesquisas" type="Text" placeholder="Pesquisar...">
            <i class="fa-solid fa-magnifying-glass"></i>
        </div>
        <button class="botao-menu-mobile" id="botao-menu" onclick="abrirMenu()">
            <section class="barra" id="b1"></section>
            <section class="barra" id="b2"></section>
            <section class="barra" id="b3"></section>
        </button>
        <ul class="alinhameto-botao-menu" id="menu-mobile">
            <li class="botao-menu">
                <a class="nome">Categorias</a>
                <div class="drop-bar">
                    <a href="" class="drop">Teste1</a>
                    <a href="" class="drop">Teste2</a>
                    <a href="" class="drop">Teste3</a>
                    <a href="" class="drop">Teste4</a>
                </div>
            </li>
            <li class="botao-menu">
                <a class="nome">Contato</a>
                <div class="drop-bar">
                    <a href="" class="drop">Teste1</a>
                    <a href="" class="drop">Teste2</a>
                    <a href="" class="drop">Teste3</a>
                    <a href="" class="drop">Teste4</a>
                </div>
            </li>
            <li class="botao-menu">
                <a class="nome">Configurações</a>
                <div class="drop-bar">
                    <a href="/LojaConstrucao/cliente?acao=listarTodos" class="drop">Listar clientes</a>
                    <a href="/LojaConstrucao/produto?acao=listarProdutos" class="drop">Listar Produtos</a>
                    <a href="/LojaConstrucao/funcionarios?acao=listarFuncionarios" class="drop">Listar Funcionários</a>
                    <a href="" class="drop">Teste4</a>
                </div>
            </li>
            <li class="botao-menu">
                <a class="nome"><i class="fas fa-shopping-cart"></i> Carrinho</a>
            </li>
            <li class="botao-menu b-login">
                <a href="/login.html" class="nome-login"><i class="fa-solid fa-user"></i>&#160;Login</a>
            </li>
        </ul>
    </nav>
`
document.body.insertAdjacentHTML("afterbegin", menu);

