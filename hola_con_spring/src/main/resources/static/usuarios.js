 async function hola() {
    const datosTable = await fetch('usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const conent = await datosTable.json();
    console.log(conent)
    let listaUser = "";
    conent.forEach(function (e){
        let usuario ='<tr><td>'+ e.id + '</td>' +
            '<td>'+e.nombre+'</td>' +
            '<td>' + e.apellido+'</td>' +
            '<td>'+ e.telefono+'</td>' +
            '<td>'+ e.email +'</td>' +
            '<td>'+ e.password+'</td>' +
            '<td>' +
            '   <img id="eliminar" src="https://img.icons8.com/office/25/null/delete--v1.png" alt="eliminar" title="eliminar"/>' +
            '   <img id="editar" src="https://img.icons8.com/office/27/null/pencil--v1.png" alt="editar" title="editar"/>' +
            '</td></tr>'
        listaUser += usuario;
    })
     document.querySelector("#datos tbody").outerHTML = listaUser;
 }

hola();