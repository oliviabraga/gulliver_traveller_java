// exibir/ocultar senha
const senha = document.querySelector(".senha");
const icon_senha = document.querySelector('.visibilidade');
icon_senha.addEventListener('click', () => {
    if (senha.type === 'password') {
        senha.type = 'text';
    } else {
        senha.type = 'password';
    }
    senha.focus();
});