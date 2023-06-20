import { clientServices } from "../service/client-service.js";

//backticks
const crearNuevaLinea = (id, cedula, nombre, apellido, email, telefono) => {
  const linea = document.createElement("tr");
  const contenido = `
    <td class="td">${cedula}</td>
    <td class="td" data-td>
      ${nombre}
    </td>
    <td class="td" data-td>
      ${apellido}
    </td>
    <td>${email}</td>
    <td class="td" data-td>
      ${telefono}
    </td>
    <td>
      <ul class="table__button-control">
        <li>
          <a
            href="../screens/editar_cliente.html?id=${id}"
            class="simple-button simple-button--edit"
          >
            Editar
          </a>
        </li>
        <li>
          <button class="simple-button simple-button--delete" type="button" id="${id}">
            Eliminar
          </button>
        </li>
      </ul>
    </td>
  `;
  linea.innerHTML = contenido;
  const btn = linea.querySelector("button");
  btn.addEventListener("click", () => {
    const id = btn.id;
    clientServices
      .eliminarCliente(id)
      .then((respuesta) => {
        console.log(respuesta);
      })
      .catch((err) => alert("Ocurrió un error"));
  });

  return linea;
};

const table = document.querySelector("[data-table]");

clientServices
  .listaClientes()
  .then((data) => {
    data.forEach(({ nombre, email, id, cedula, apellido, telefono}) => {
      const nuevaLinea = crearNuevaLinea(id, cedula, nombre, apellido, email, telefono);
      table.appendChild(nuevaLinea);
    });
  })
  .catch((error) => alert("Ocurrió un error"));
