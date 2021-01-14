//permitir alteração nos campos do usuário - Página minha_conta.html
const btnAlterar = document.querySelector('#alterar');
const meuForm = document.querySelectorAll('input, select, date, button');
btnAlterar.addEventListener('click', () => {
    meuForm.forEach((campo) => {
        campo.removeAttribute('disabled');
    })
    meuForm[0].focus();
});