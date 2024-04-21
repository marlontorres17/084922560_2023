function save() {
    var data = {
        'nombre': $('#nombre').val(),
        'direccion': $('#direccion').val(),
        'telefono': $('#telefono').val(),
        'email': $('#email').val(), 
        'state': $('#state').val() == 1 ? true : false 
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/persona',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (data) {
            alert("Registro exitoso");
            loadData();
            clearData();
        },
        error: function (error) {
            console.error('Error al registrar', error)
        }

    });
}



function update() {
    var data = {
        'nombre': $('#nombre').val(),
        'direccion': $('#direccion').val(),
        'telefono': $('#telefono').val(),
        'email': $('#email').val(), 
        'state': parseInt($('#state').val())
    };
    var id = $('#id').val(); 
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/persona/' + id, 
        method: "PUT",
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (result) {
            alert("Actualización exitosa");
            loadData();
            clearData();

            // actualizar botón
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
        },
        error: function (error) {
            console.error("Error al actualizar el registro:", error);
        }
    });
}


function loadData(){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/persona',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var html = '';
            var data = response.data;
            if(Array.isArray(data)){
                data.forEach(function (item){
                    html += `<tr>
                    <td>${item.nombre}</td>
                    <td>${item.direccion}</td>
                    <td>${item.telefono}</td>
                    <td>${item.email}</td>
                    <td>${item.state === true ? 'Activo': 'Inactivo'}</td>
                    <td><button onclick="findById(${item.id})">Editar</button></td>
                    <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
                    </tr>`;
                }); 
            } else {
                console.error('el atributo "data" no es un arreglo: ', data);
            }
            $('#resultData').html(html);
        },
        error: function (error){
            console.error('Error al registrar', error)
        }

    });
}

function findById(id){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/persona/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id); 
            $('#nombre').val(data.data.nombre); 
            $('#direccion').val(data.data.direccion);
            $('#telefono').val(data.data.telefono); 
            $('#email').val(data.data.email);  
            $('#state').val(data.data.state === true ? 1 : 0); 

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function (error){
            console.error('Error al registrar:', error)
        }
    });
}

function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/persona/' + id,
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro eliminado exitoso");
        loadData();
        clearData();
    }).fail(function (xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}


function clearData(){
    $('#id').val('');
    $('#nombre').val('');
    $('#direccion').val('');
    $('#telefono').val('');
    $('#email').val('');
    $('#state').val('');
}