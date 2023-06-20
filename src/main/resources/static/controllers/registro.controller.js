import { clientServices } from "../service/client-service.js";

const formulario = document.querySelector("[data-form]");

formulario.addEventListener("submit", (evento) => {
  evento.preventDefault();
  const cedula = document.querySelector("[data-cedula]").value;
  const nombre = document.querySelector("[data-nombre]").value;
  const apellido = document.querySelector("[data-apellido]").value;
  const email = document.querySelector("[data-email]").value;
  const telefono = document.querySelector("[data-telefono]").value;

  clientServices
    .crearCliente(cedula, nombre, apellido, email, telefono)
    .then(() => {
      window.location.href = "/screens/registro_completado.html";
    })
    .catch((err) => console.log(err));
});
