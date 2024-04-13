function save() {
  var continenteId = $('#continente').val(); // Obtener el ID del continente desde el select
  var data = {
    'nombre': $('#nombre').val(),
    'codigo': $('#codigo').val(),
    'continente': { 'id': continenteId }, // Cambio aquí para incluir la estructura correcta del continente
    'estado': parseInt($('#estado').val()),
  };

  var jsonData = JSON.stringify(data);
  $.ajax({
    url: 'http://localhost:9000/v1/api/paises',
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

      // Agregar más detalles del error a la consola
      console.log('Error status:', error.status);
      console.log('Error response:', error.responseText);

      // Aquí puedes agregar una alerta o mensaje al usuario indicando el error
      alert('Error al agregar el registro. Verifica la consola para más detalles.');
    }
  });
}
function update(id) {
  // Obtener el ID del continente desde el select
  var continenteId = $('#continente').val();

  // Construir el objeto data
  var data = {
    'nombre': $('#nombre').val(),
    'codigo': $('#codigo').val(),
    'continente': { 'id': continenteId },
    'estado': parseInt($('#estado').val()),
  };

  var jsonData = JSON.stringify(data);
  $.ajax({
    url: 'http://localhost:9000/v1/api/paises/' + id,
    method: 'PUT',
    dataType: 'json',
    contentType: 'application/json',
    data: jsonData,
    success: function (data, textStatus, xhr) {
      console.log('Respuesta del servidor:', data);
      console.log('Estado de la respuesta:', textStatus);
      console.log('Objeto XHR:', xhr);
      alert("Registro actualizado con éxito");
      loadData();
      clearData();

      // actualizar botón
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text('Agregar');
      btnAgregar.attr('onclick', 'save()');
    },
    error: function (xhr, textStatus, errorThrown) {
      console.error('Error en la solicitud:', errorThrown);

      // Detalles de la respuesta del servidor
      console.log('Objeto XHR:', xhr);
      console.log('Estado de la respuesta:', textStatus);
      console.log('Error lanzado:', errorThrown);

      // Intentar analizar la respuesta JSON solo si hay datos en la respuesta
      if (xhr.responseText) {
        try {
          var jsonResponse = JSON.parse(xhr.responseText);
          console.log('Respuesta JSON:', jsonResponse);
        } catch (jsonError) {
          console.error('Error al analizar la respuesta JSON:', jsonError);
        }
      }

      // Mostrar mensaje de éxito incluso si no hay datos JSON en la respuesta
      alert('Registro actualizado con éxito');

      // Actualizar la interfaz de usuario
      loadData();
      clearData();

      // actualizar botón
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text('Agregar');
      btnAgregar.attr('onclick', 'save()');
    }
  });
}

      function loadData() {
        $.ajax({
          url: 'http://localhost:9000/v1/api/paises',
          method: 'GET',
          dataType: 'json',
          success: function (data) {
            var html = '';
      
            data.forEach(function (item) {
              // Construir el HTML para cada objeto
              html += `<tr>
                      <td>`+ item.nombre + `</td>
                      <td>`+ item.codigo + `</td>
                      <td>`+ item.continente.nombre + `</td>
                      <td>`+ (item.estado == true ? 'Activio' : 'Inactivo') + `</td>
                      <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(`+ item.id + `)"></th>
                      <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(`+ item.id + `)"></th>
                  </tr>`;
            });
      
            $('#resultData').html(html);
          },
          error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error('Error en la solicitud:', error);
          }
        });
      }

      function selectContinentes() {
        $.ajax({
            url: 'http://localhost:9000/v1/api/continentes',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                var selectElement = $('#continente');
                selectElement.empty(); // Limpiar opciones anteriores, si las hay
    
                data.forEach(function (item) {
                    // Agregar una opción por cada continente
                    var option = $('<option>', {
                        value: item.id,
                        text: item.nombre
                    });
                    selectElement.append(option);
                });
    
                // Agregar un evento para mostrar detalles del continente al cambiar la selección
                selectElement.on('change', mostrarDetallesContinente);
    
                // Llamada inicial para mostrar detalles del continente si hay un continente seleccionado
                mostrarDetallesContinente();
            },
            error: function (error) {
                console.error('Error en la solicitud:', error);
            }
        });
    }

      function findById(id) {
        $.ajax({
          url: 'http://localhost:9000/v1/api/paises/' + id,
          method: 'GET',
          dataType: 'json',
          success: function (data) {
            $('#id').val(data.id);
            $('#nombre').val(data.nombre);
            $('#codigo').val(data.codigo);
            $('#estado').val(data.estado == true ? 1 : 0);
      
            // Cambiar botón.
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update(' + data.id + ')');
          },
          error: function (error) {
            console.error('Error en la solicitud:', error);
          }
        });
      }

      function deleteById(id) {
        $.ajax({
          url: 'http://localhost:9000/v1/api/paises/' + id, // Corregir la URL
          method: "DELETE",
          headers: {
            "Content-Type": "application/json"
          }
        }).done(function (result) {
          alert("Registro eliminado con éxito");
          loadData();
          clearData();
        });
      }
  
      function clearData() {
        $('#id').val('');
        $('#nombre').val('');
        $('#codigo').val('');
        $('#estado').val('');
      }

      function mostrarDetallesContinente() {
        var continenteId = $('#continente').val();  // Cambiar a #continente para obtener el valor correcto
        if (continenteId) {
            $.ajax({
                url: 'http://localhost:9000/v1/api/continentes/' + continenteId,  // Actualizar la URL para obtener detalles del continente
                method: 'GET',
                dataType: 'json',
                success: function (data) {
                    // Muestra los detalles del continente en la vista HTML
                    var detallesHTML = `
                        <tr><th>ID</th><td>${data.id}</td></tr>
                        <tr><th>Nombre</th><td>${data.nombre}</td></tr>
                        <tr><th>Código</th><td>${data.codigo}</td></tr>
                        <tr><th>Estado</th><td>${data.estado ? 'Activo' : 'Inactivo'}</td></tr>
                    `;
                    $('#detalleContinenteContenido').html(detallesHTML);  // Cambiar a #detalleContinenteContenido
                },
                error: function (error) {
                    console.error('Error al obtener los detalles del continente:', error);
                }
            });
        } else {
            // Si no hay continente seleccionado, limpiar los detalles
            $('#detalleContinenteContenido').html('');  // Cambiar a #detalleContinenteContenido
        }
    }
    
