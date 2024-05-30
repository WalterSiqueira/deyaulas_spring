function mostrarFormulario(idFormulario) {
  // Esconder todos os formulários
  var forms = document.getElementsByClassName("formulario");
  for (var i = 0; i < forms.length; i++) {
    forms[i].style.display = "none";
  }
  // Mostrar o formulário correspondente ao botão clicado
  var formulario = document.getElementById(idFormulario);
  formulario.style.display = "block";
}
