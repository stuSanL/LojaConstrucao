const container = document.querySelector('.menu-produtos');
const scrollStep = 1000; // Define o valor para rolar em pixels
const scrollInterval = 10000; // Intervalo em milissegundos (10 segundos)

function scrollHorizontally(step) {
    if (container) {
        const maxScrollLeft = container.scrollWidth - container.clientWidth;
        const threshold = scrollStep / 2; // Tolerância para considerar "próximo do final"
        const newScrollLeft = container.scrollLeft + step;

        if (step > 0 && newScrollLeft >= maxScrollLeft - threshold) {
            // Se está próximo do final, rola diretamente até o final
            container.scrollTo({ left: maxScrollLeft, behavior: 'smooth' });
            // Após um pequeno atraso, volta ao início
            setTimeout(() => {
                container.scrollTo({ left: 0, behavior: 'smooth' });
            }, scrollInterval); // Ajuste o tempo conforme necessário
        } else if (step < 0 && newScrollLeft <= threshold) {
            // Se está próximo do início, rola diretamente até o início
            container.scrollTo({ left: 0, behavior: 'smooth' });
            // Após um pequeno atraso, volta ao final
            setTimeout(() => {
                container.scrollTo({ left: maxScrollLeft, behavior: 'smooth' });
            }, scrollInterval); // Ajuste o tempo conforme necessário
        } else {
            // Rola normalmente
            container.scrollBy({
                left: step,
                behavior: 'smooth',
            });
        }
    }
}

// Define um intervalo para rolar automaticamente
setInterval(() => {
    scrollHorizontally(scrollStep);
}, scrollInterval);

// Adiciona evento ao botão para rolar manualmente para frente
const scrollButtonNext = document.querySelector('#bn');
if (scrollButtonNext) {
    scrollButtonNext.addEventListener('click', () => {
        scrollHorizontally(scrollStep);
        
    });
}

// Adiciona evento ao botão para rolar manualmente para trás
const scrollButtonPrev = document.querySelector('#bp');
if (scrollButtonPrev) {
    scrollButtonPrev.addEventListener('click', () => {
        scrollHorizontally(-scrollStep);
    });
}