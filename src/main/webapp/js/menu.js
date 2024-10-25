var menu = ` 
<style>
    :root{
    --c1: #ffffff;
    --c2: #000000;
    --c3: #0A3D62;
    --c4: #808080;
    --c5: #F4B400;
}

body{
    margin: 0;
    padding: 0;
    background-color: var(--c1);
}

nav{
    background-color: var(--c3);
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    align-items: center;
    width: 100%;
    height: 70px;
}

.alinhameto-botao-menu{
    display: flex;
    flex-direction: row;
    margin: 0;
    padding: 0;
    align-items: center;
    justify-content: space-around;
    width: 40%;
}

.botao-menu{
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-decoration: none;
    list-style: none;
    font-family: Arial, Helvetica, sans-serif;
    color: var(--c1);
    text-shadow: 1px 1px 1px black;
}

.nome{
    color: var(--c1);
    text-decoration: none;
    z-index: 10;
}

.nome-login{
    padding: 5px;
    border-radius: 5px;
    border: solid 2px var(--c1);
}

.nome:hover{
    cursor: pointer;
}

.area-pesquisa{
    background-color: transparent;
    display: flex;
    height: 35px;
    flex-direction: row;
    align-items: center;
    margin: auto 0;
    background-color: var(--c1);
    border: solid 2px var(--c1);
    border-radius: 50px;
}

.barra-pesquisas{
    background-color: transparent;
    border: none;
    font-size: 15px;
    height: 35px;
    background-color: transparent;
    border-radius: 50px 0 0 50px;
    padding: 0 10px;
}

.fa-magnifying-glass{
    display: flex;
    font-size: 20px;
    padding: 10px;
    border-radius: 0 20px 20px 0;
    color: var(--c3);
    text-shadow: 1px 1px 1px black;
}


.logo-menu{
    color: var(--c1);
    font-family: Arial, Helvetica, sans-serif;
    text-shadow: 2px 2px 2px black;
    transition: all .5s;
    color: var(--c1);
    text-decoration: none;
    font-size: 30px;
}
.logo-menu2{
    display: none;
}


.drop-bar{
    display: flex;
    align-items: center;
    flex-direction: column;
    position: absolute;
    display: none;
    padding: 30px 20px 10px 20px;
    background-color: var(--c3);
    animation: anim .5s;
    overflow: hidden;
    margin-top: 200px;
}

.drop{
    width: 100%;
    padding: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: var(--c3);
    border-radius: 10px;
    color: var(--c1);
    text-decoration: none;
    text-shadow: 1px 1px 1px black;
    animation: opcoes .8s;
}

.botao-menu:hover{
    .drop-bar{
        display: flex;
    }
}

.drop:hover{
    background-color: rgba(255, 255, 255, 0.20);
}

.botao-menu-mobile{
    display: none;
}

@keyframes anim{
    0%{
        opacity: 0%;
    }
    100%{
        opacity: 100%;
    }
}

@keyframes opcoes{
    0%{
        opacity: 0%;
    }50%{
        opacity: 0%;
    }100%{
        opacity: 100%;
    }
}

@media (max-width: 900px){
    nav{
        align-items: flex-start;
    }

    .logo-menu{
        font-size: 25px;
    }

    .alinhameto-botao-menu{
        display: none;
        flex-direction: column;
        justify-content: start;
        position: absolute;
        background-color: var(--c3);
        margin-top: 69px;
        right: 0;
        height: 100vh;
    }

    @keyframes abrir-menu {
        from{
            right: -100%;
        }to{
            right: 0;
        }
    }
    @keyframes fechar-menu {
        from{
            right: 0;
        }to{
            right: -100%;
        }
    }

    .botao-menu-mobile{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: min-content;
        margin: 0;
        padding: 10px 5px;
        background-color: transparent;
        border: none;
        margin: auto 0;
        border-radius: 5px;
        background-color: var(--c3);
        height: 50px;
        width: 50px;
    }

    .barra{
        position: absolute;
        height: 4px;
        width: 30px;
        background-color:white;
        margin: 2.5px 5px;
        border-radius: 50px;
        transition: all .5s;
    }
    #b1{
        margin-bottom: 20px;
    }
    #b3{
        margin-top: 20px;
    }

    .botao-menu{
        width: 100%;
        height: auto;
    }

    .nome{
        font-size: 20px;
        padding: 10px;
        width: 80%;
    }

    .drop-bar{
        position: relative;
        margin-top: 0;
        padding: 0 20px 10px 20px;
        width: 70%;
    }

    .drop{
        display: flex;
        justify-content: start;
        width: 100%;
    }
}

@media (max-width: 500px){
    .alinhameto-botao-menu{
        width: 70%;
    }
    .logo-menu{
        display: none;
    }
    .logo-menu2{
        display: flex;
    }
}
</style>
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
                <a class="nome">Listar</a>
                <div class="drop-bar">
                    <a href="/LojaConstrucao/cliente?acao=listarTodos" class="drop">Listar clientes</a>
                    <a href="" class="drop">Teste2</a>
                    <a href="" class="drop">Teste3</a>
                    <a href="" class="drop">Teste4</a>
                </div>
            </li>
            <li class="botao-menu">
                <a class="nome">Exemplo2</a>
                <div class="drop-bar">
                    <a href="" class="drop">Teste1</a>
                    <a href="" class="drop">Teste2</a>
                    <a href="" class="drop">Teste3</a>
                    <a href="" class="drop">Teste4</a>
                </div>
            </li>
            <li class="botao-menu">
                <a class="nome">Exemplo3</a>
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
                    <a href="" class="drop">Teste</a>
                    <a href="" class="drop">Teste</a>
                    <a href="" class="drop">Teste</a>
                    <a href="" class="drop">Teste</a>
                </div>
            </li>
            <li class="botao-menu">
                <a href="/LojaConstrucao/login?acao=login" class="nome nome-login"><i class="fa-solid fa-user"></i>&#160;Login</a>
            </li>
        </ul>
    </nav>
`
document.body.insertAdjacentHTML("afterbegin", menu);