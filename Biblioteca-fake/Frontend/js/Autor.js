function save() {
    var data = {
        'personaId': { 'id': $('#personaId').val(),},
        'fechaNacimiento': $('#fechaNacimiento').val(),
        'fechaMuerte': $('#fechaMuerte').val(), 
        'state': parseInt($('#state').val())
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor',
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
        'personaId': { 'id': $('#persona').val(),},
        'fechaNacimiento': $('#fechaNacimiento').val(),
        'fechaMuerte': $('#fechaMuerte').val(),
        'state': parseInt($('#state').val()),
        
    };
    var id = $('#id').val(); 
    var jsonData = JSON.stringify(data);

    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor/' + id, 
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
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor',
        method: 'GET',
        dataType: 'json',
        success: function(response){
            var html = '';
            var data = response.data;
            if(Array.isArray(data)){
                data.forEach(function (item){
                    html += `<tr>
                    <td>${item.personaId.nombre}</td>
                    <td>${item.fechaNacimiento}</td>
                    <td>${item.fechaMuerte === null ? 'Sigue con vida': 'Fallecido'}</td>
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

function loadPersona(){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/persona',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var options = '';

            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(item){
                    options += `<option value="${item.id}">${item.nombre}</option>`;
                });
                $('#personaId').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar las ciudades: ',error);
        }
    });
}

function findById(id){
    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id); 
            $('#personaId').val(data.data.personaId.id); 
            $('#fechaNacimiento').val(data.data.fechaNacimiento); 
            $('#fechaMuerte').val(data.data.fechaMuerte);  
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
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor/' + id,
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
    $('#personaId').val('');
    $('#fechaNacimiento').val('');
    $('#fechaMuerte').val('');
    $('#state').val('');
}
