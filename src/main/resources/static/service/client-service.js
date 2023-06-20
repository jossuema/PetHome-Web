const listaClientes = () =>
  fetch("http://localhost:8080/api/clients").then((respuesta) => respuesta.json());

const crearCliente = (cedula, nombre, apellido, email, telefono) => {
  return fetch("http://localhost:8080/api/clients", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({cedula, nombre, apellido, email, telefono}),
  });
};

const eliminarCliente = (id) => {
  return fetch(`http://localhost:8080/api/clients/${id}`, {
    method: "DELETE",
  });
};

const detalleCliente = (id) => {
  return fetch(`http://localhost:8080/perfil/${id}`).then((respuesta) =>
    respuesta.json()
  );
};

const actualizarCliente = (nombre, email, id) => {
  return fetch(`http://localhost:8080/perfil/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ nombre, email }),
  })
    .then((respuesta) => respuesta)
    .catch((err) => console.log(err));
};

export const clientServices = {
  listaClientes,
  crearCliente,
  eliminarCliente,
  detalleCliente,
  actualizarCliente,
};
