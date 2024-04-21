function save(){
    var data = {
        
        'fechaInicio' : $('#fechaInicio').val(),
        'fechaFin' : $('#fechaFin').val(),
        'persona' : { 'id' : $('#persona_id').val()},
        'libro' : { 'id' : $('#libro_id').val()},
        'state' : $('#state').val() == 1 ? true : false 
    };

    

    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/seguridad/v1/api/registro',
        method : 'POST',
        dataType : 'json',
        contentType : 'application/json',
        data : jsonData,
        success : function(data){
            alert("Registro guardado.");
            loadData();
            clearData();
        },
        error : function(error){
            console.error('Error al guardar: ',error);
        }
    });
}



function update(){
    var data = {
        'fechaInicio' : $('#fechaInicio').val(),
        'fechaFin' : $('#fechaFin').val(),
        'persona' : { 'id' : $('#persona_id').val()},
        'libro' : { 'id' : $('#libro_id').val()},
        'state' :parseInt ($('#state').val())
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/seguridad/v1/api/registro/' + id, 
        method: "PUT",
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success : function(result){
            alert("Actualizado.");
            loadData(); 
            clearData();

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
        },
        error : function(error){
            console.error('Error al actualizar: ', error);
        }
    });
}

function loadData(){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/registro', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    html += `<tr>
                    <td>${item.fechaInicio}</td>
                    <td>${item.fechaFin}</td>
                    <td>${item.persona.nombre}</td>
                    <td>${item.libro.titulo}</td>
                    <td>${item.state === true ? 'Activo': 'Inactivo'}</td>
                    <td><button onclick="findById(${item.id})">Editar</button></td>
                    <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
                    </tr>`;
                });
            } else {
                console.error('El atributo "data" no es un arreglo: ',data);
            }
            $('#resultData').html(html);
        },
        error : function(error){
            console.error('Error al cargar: ',error);
        }
    });
}


function loadPersona(){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/persona',
        method: "GET",
        dataType: 'json',
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var personas = response.data.map(function(persona) {
                    return {
                        label: persona.nombre, // Mostrar nombre 
                        value: persona.id // El valor que se enviará cuando se seleccione un elemento
                    };
                });
                
                // Inicializar el autocompletado en el campo de entrada #persona
                $('#persona').autocomplete({
                    source : function(request, response){
                        var results = $.ui.autocomplete.filter(personas, request.term);
                        if (!results.length){
                            results = [{label : 'No se encontraron resultados', value: null}];
                        }
                        response(results);
                    },
                    select: function(event, ui){
                        $("#persona_id").val(ui.item.value);
                        $("#persona").val(ui.item.label);
                        console.log("ID de empresa seleccionada: " + ui.item.value);
                        return false;
                    }
    });
} else {
    console.error("No se obtuvo la lista de personas.");
}
        },
        error : function(error){
            console.error("Error de la solicitur: ",error);
        }
    });
}


function loadLibro(){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/libro',
        method: "GET",
        dataType: 'json',
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var libros = response.data.map(function(libro) {
                    return {
                        label: libro.titulo, // Mostrar nombre 
                        value: libro.id // El valor que se enviará cuando se seleccione un elemento
                    };
                });
                
                // Inicializar el autocompletado en el campo de entrada #persona
                $('#libro').autocomplete({
                    source : function(request, response){
                        var results = $.ui.autocomplete.filter(libros, request.term);
                        if (!results.length){
                            results = [{label : 'No se encontraron resultados', value: null}];
                        }
                        response(results);
                    },
                    select: function(event, ui){
                        $("#libro_id").val(ui.item.value);
                        $("#libro").val(ui.item.label);
                        console.log("ID de empresa seleccionada: " + ui.item.value);
                        return false;
                    }
    });
} else {
    console.error("No se obtuvo la lista de personas.");
}
        },
        error : function(error){
            console.error("Error de la solicitur: ",error);
        }
    });
}









function findById(id){
    
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/registro/' + id,
        method : 'GET',
        dataType : 'json',
        success : function(data){
            $('#id').val(data.data.id);
            $('#fechaInicio').val(data.data.fechaInicio);
            $('#fechaFin').val(data.data.fechaFin);
            $('#persona').val(data.data.persona.id);
            $('#libro').val(data.data.libro.id);
            $('#state').val(data.data.state === true ? 1 : 0);

            
            
            
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');

        },
        error : function(error){
            console.error('Error al encontrar: ',error);
        }
    });
}


function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/registro/' + id,
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function(result) {
        alert("Registro eliminado exitoso");
        loadData();
        clearData();
    }).fail(function(xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}


function clearData(){
    $('#fechaInicio').val('');
    $('#fechaFin').val('');
    $('#persona').val('');
    $('#libro').val('');
    $('#state').val('');
}

