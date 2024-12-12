const botao = document.getElementById('botao-menu');
const menuMobile = document.getElementById('menu-mobile');
let statusMenu = false;

const b1 = document.getElementById('b1');
const b2 = document.getElementById('b2');
const b3 = document.getElementById('b3');

function abrirMenu(){
    if(statusMenu == false){
        menuMobile.style.display = 'flex';
        menuMobile.style.animation = 'abrir-menu .5s';
        botao.style.backgroundColor = 'rgba(255, 255, 255, 0.20)';
        b1.style.marginBottom = '0';
        b1.style.transform = 'rotate(45deg)';
        b2.style.opacity = '0';
        b3.style.marginTop = '0';
        b3.style.transform = 'rotate(-45deg)';

        statusMenu = true;
    }else{
        menuMobile.style.animation = 'fechar-menu .5s';
        botao.style.backgroundColor = 'transparent';
        b1.style.marginBottom = '20px';
        b1.style.transform = 'rotate(0deg)';
        b2.style.opacity = '100%';
        b3.style.marginTop = '20px';
        b3.style.transform = 'rotate(0deg)';
        setTimeout(() => {
            menuMobile.style.display = 'none';
        }, 500);

        statusMenu = false;
    }
    
}
