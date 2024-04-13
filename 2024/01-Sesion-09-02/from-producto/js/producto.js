function save() {
    var data = {
        'nombre': $('#nombre').val(),
        'precio': $('#precio').val(),
        'cantidad': $('#cantidad').val(),
        'categoria': $('#categoria').val(),
        'descripcion': $('#descripcion').val(),
    };

    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/v1/api/producto',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (data) {
            alert("Registro agregado con éxito");
            loadData();
            clearData();
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
        }
    });
}

function update() {
    var data = {
        'nombre': $('#nombre').val(),
        'precio': $('#precio').val(),
        'cantidad': $('#cantidad').val(),
        'categoria': $('#categoria').val(),
        'descripcion': $('#descripcion').val(),
    };
    var id = $("#id").val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/v1/api/producto/' + id,
        method: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (result) {
            alert("Registro actualizado con éxito");
            loadData();
            clearData();

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
        }
    });
}

function loadData() {
    $.ajax({
        url: 'http://localhost:9000/v1/api/producto',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            var html = '';

            data.forEach(function (item) {
                html += `<tr>
                    <td>${item.nombre}</td>
                    <td>${item.precio}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.categoria}</td>
                    <td>${item.descripcion}</td>
                    <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(`+ item.id + `)"></th>
                    <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(`+ item.id + `)"></th>
                </tr>`;
            });

            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
        }
    });
}

function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/v1/api/producto/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.id);
            $('#nombre').val(data.nombre);
            $('#precio').val(data.precio);
            $('#cantidad').val(data.cantidad);
            $('#categoria').val(data.categoria);
            $('#descripcion').val(data.descripcion);

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
        }
    });
}

function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/v1/api/producto/' + id,
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .done(function (result) {
        alert("Registro eliminado con éxito");
        loadData();
        clearData();
    })
    .fail(function (error) {
        console.error('Error en la solicitud:', error);
    });
}

function clearData() {
    $('#id').val('');
    $('#nombre').val('');
    $('#precio').val('');
    $('#cantidad').val('');
    $('#categoria').val('');
    $('#descripcion').val('');

}

// Llamar a loadData al cargar la página
$(document).ready(function () {
    loadData();
});
