document.getElementById("checkbox").addEventListener("change", function(){
    var checkbox = this;
    const entrar = document.getElementById('entrar');
    const cadastro = document.getElementById('cadastro');
    const be = document.getElementById('be');
    const bc = document.getElementById('bc');

    if(checkbox.checked){
        entrar.style.animation = '.5s saida';
        be.style.animation = '.5s saida';
        setTimeout(() => {
            entrar.style.display = 'none';
            be.style.display = 'none';
            cadastro.style.display = 'flex';
            bc.style.display = 'flex';
            cadastro.style.animation = '.5s entrada';
            bc.style.animation = '.5s entrada';
        }, 500);
    }else{
        cadastro.style.animation = '.5s saida';
        bc.style.animation = '.5s saida';
        setTimeout(() => {
            entrar.style.display = 'flex';
            be.style.display = 'flex';
            cadastro.style.display = 'none';
            bc.style.display = 'none';
            entrar.style.animation = '.5s entrada';
            be.style.animation = '.5s entrada';
        }, 500);
    }   
});




