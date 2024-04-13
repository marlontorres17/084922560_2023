-- Crea un procedimiento almacenado que tome el nombre de una categoría como
-- parámetro y devuelva la lista de películas en esa categoría.

DELIMITER $$
CREATE PROCEDURE consultar_peliculas_por_categoria(IN c_category_name VARCHAR(25))
BEGIN
    SELECT film.title
    FROM category
    INNER JOIN film_category ON category.category_id = film_category.category_id
    INNER JOIN film ON film_category.film_id = film.film_id
    WHERE category.name LIKE CONCAT('%', c_category_name, '%');
END$$
DELIMITER ;

CALL consultar_peliculas_por_categoria('Documentary');

-- Crea un procedimiento almacenado que tome el ID de una película y la nueva
-- duración como parámetros, y actualice la duración de esa película en la base de datos.
DELIMITER $$
CREATE PROCEDURE duracion_pelicula(IN p_film_id SMALLINT UNSIGNED, IN p_nueva_duration SMALLINT UNSIGNED)
BEGIN 
UPDATE film
SET length = p_nueva_duration 
WHERE film_id = p_film_id;
END$$
DELIMITER ;

CALL duracion_pelicula(3, 180);

-- Crea un procedimiento almacenado que tome el ID de un cliente como parámetro
-- y devuelva el total de ingresos generados por ese cliente a través de todas sus
-- transacciones
DROP PROCEDURE IF EXISTS total_cliente_ingresos;
DELIMITER $$ 
CREATE PROCEDURE total_cliente_ingresos(IN p_cliente_id INT, OUT p_total_ingresos DECIMAL(10, 2), OUT p_cliente_nombre VARCHAR(255))
BEGIN 
    SELECT 
        SUM(payment.amount) INTO p_total_ingresos
    FROM customer
    LEFT JOIN rental ON customer.customer_id = rental.customer_id
    LEFT JOIN payment ON rental.rental_id = payment.rental_id
    WHERE customer.customer_id = p_cliente_id;

    IF p_total_ingresos IS NULL THEN
        SET p_total_ingresos = 0.00;
    END IF;

    SELECT 
        CONCAT(customer.first_name, ' ', customer.last_name) INTO p_cliente_nombre
    FROM customer
    WHERE customer.customer_id = p_cliente_id;
END $$

DELIMITER ;

-- @ es para declarar una variable
SET @total_ingresos := 0.00;
SET @nombre_cliente := '';
CALL total_cliente_ingresos(1, @total_ingresos, @nombre_cliente);
SELECT @nombre_cliente AS NombreCliente, @total_ingresos AS TotalIngresos;

-- Crea un procedimiento almacenado que tome el nombre y apellido de un nuevo
-- actor como parámetros, y lo inserte en la tabla de actores.

DELIMITER $$
CREATE PROCEDURE insertar_nuevo_actor(IN p_nombre_actor VARCHAR(45), IN p_apellido_actor VARCHAR(45))
BEGIN
    -- Inserta el nuevo actor en la tabla de actores
    INSERT INTO actor (first_name, last_name)
    VALUES (p_nombre_actor, p_apellido_actor);
END $$

DELIMITER ;

CALL insertar_nuevo_actor('ANACLETO', 'MERCEDES');

-- Crea un procedimiento almacenado que tome el ID de una película como
-- parámetro y elimine la película junto con todas las entradas relacionadas en otras
-- tablas (por ejemplo, actores en esa película).


DELIMITER $$
CREATE PROCEDURE EliminarPelicula(
    IN pelicula_id INT
)
BEGIN
   
    SET foreign_key_checks = 0;

    DELETE FROM film_actor WHERE film_id = pelicula_id;
    DELETE FROM film_category WHERE film_id = pelicula_id;
    DELETE FROM inventory WHERE film_id = pelicula_id;
    DELETE FROM rental WHERE inventory_id IN (SELECT inventory_id FROM inventory WHERE film_id = pelicula_id);

   
    DELETE FROM film WHERE film_id = pelicula_id;

    
    SET foreign_key_checks = 1;
END$$

DELIMITER ;

CALL EliminarPelicula(1);
SET SQL_SAFE_UPDATES = 0;

-- Crea un procedimiento almacenado que devuelva la lista de clientes ordenados
-- por el total de gastos, de mayor a menor.

DROP PROCEDURE clientes_ordenados;
DELIMITER $$
CREATE PROCEDURE clientes_ordenados()
BEGIN 
SELECT
c.customer_id,
CONCAT(c.first_name, ' ', c.last_name),
IFNULL(SUM(p.amount), 0) AS total_gastos
FROM
customer c
LEFT JOIN
payment p ON c.customer_id = p.customer_id
GROUP BY 
c.customer_id
ORDER BY
total_gastos DESC;
 END$$
 
 DELIMITER ;
 
 CALL clientes_ordenados();
 
 -- Crea un procedimiento almacenado que tome el ID de una categoría y el nuevo
-- nombre como parámetros, y actualice el nombre de esa categoría.

DROP PROCEDURE categoria_nombre;
DELIMITER $$
CREATE PROCEDURE categoria_nombre(IN c_category_id SMALLINT UNSIGNED,IN c_nuevo_nombre VARCHAR(45))
BEGIN 
UPDATE category
SET name = c_nuevo_nombre
WHERE category_id = c_category_id;
END$$
DELIMITER ;

CALL categoria_nombre(1, 'ALFONSO');

-- Crea un procedimiento almacenado que devuelva el promedio de duración de
-- películas para cada categoría.

DROP PROCEDURE IF EXISTS peliculas_duracion;
DELIMITER $$

CREATE PROCEDURE PromedioDuracionPorCategoria()
BEGIN
    SELECT 
        c.category_id,
        c.name AS nombre_categoria,
        AVG(f.length) AS promedio_duracion
    FROM 
        category c
    LEFT JOIN 
        film_category fc ON c.category_id = fc.category_id
    LEFT JOIN 
        film f ON fc.film_id = f.film_id
    GROUP BY 
        c.category_id, c.name;

    COMMIT;
END $$
DELIMITER ;

CALL PromedioDuracionPorCategoria();


-- Crea un procedimiento almacenado que tome el nombre de un nuevo género
-- como parámetro y lo inserte en la tabla de géneros.
delimiter $$
CREATE PROCEDURE InsertarNuevoGenero(
    IN nuevo_genero_nombre VARCHAR(255)
)
BEGIN
INSERT INTO category (name) VALUES (nuevo_genero_nombre);

end $$ 
delimiter ; 

call InsertarNuevoGenero('feo');

-- Procedimiento Almacenado para Eliminar un Cliente y sus Órdenes:

drop procedure EliminarClienteYOrdenes;

DELIMITER $$
CREATE PROCEDURE EliminarClienteYOrdenes(
    IN cliente_id INT
)
BEGIN
 DELETE FROM payment WHERE customer_id = cliente_id;

    DELETE FROM rental WHERE customer_id = cliente_id;
    DELETE FROM customer WHERE customer_id = cliente_id;
    
END $$
DELIMITER ;

call EliminarClienteYOrdenes(1);

DELIMITER $$

CREATE PROCEDURE EliminarClienteYOrdenesConDetalles(
    IN cliente_id INT
)
BEGIN

DELETE od
    FROM inventory
    JOIN rental r ON od.rental_id = r.rental_id
    WHERE r.customer_id = cliente_id;

    -- Eliminar órdenes asociadas al cliente
    DELETE FROM rental WHERE customer_id = cliente_id;

    -- Eliminar pagos asociados al cliente
    DELETE FROM payment WHERE customer_id = cliente_id;

    -- Eliminar el cliente
    DELETE FROM customer WHERE customer_id = cliente_id;
END $$

DELIMITER ;

call EliminarClienteYOrdenesConDetalles(1);


-- Crea un procedimiento almacenado que tome el ID de un cliente como parámetro
-- y elimine al cliente junto con todas sus órdenes y detalles asociados.

drop procedure EliminarClienteYOrdenesConDetalles;
DELIMITER $$



CREATE PROCEDURE EliminarClienteYOrdenesConDetalles(
    IN cliente_id INT
)
BEGIN

DELETE FROM rental
    WHERE inventory_id IN (
        SELECT inventory_id
        FROM inventory
        WHERE film_id IN (
            SELECT film_id
            FROM rental
            WHERE customer_id = cliente_id
        )
    );

    -- Eliminar detalles de órdenes asociados al cliente
    DELETE FROM inventory
    WHERE film_id IN (
        SELECT film_id
        FROM rental
        WHERE customer_id = cliente_id
    );

    -- Eliminar pagos asociados al cliente
    DELETE FROM payment WHERE customer_id = cliente_id;

    -- Eliminar el cliente
    DELETE FROM customer WHERE customer_id = cliente_id;
END $$

DELIMITER ;

call EliminarClienteYOrdenesConDetalles(2);


# 12 PROCEDIMIENTO ALMACENADO
delimiter $$
CREATE PROCEDURE PeliculasMasAlquiladas()
BEGIN
SELECT 
        f.film_id,
        f.title,
        COUNT(r.rental_id) AS veces_alquilada
    FROM 
        film f
    LEFT JOIN 
        inventory i ON f.film_id = i.film_id
    LEFT JOIN 
        rental r ON i.inventory_id = r.inventory_id
    GROUP BY 
        f.film_id, f.title
    ORDER BY 
        veces_alquilada DESC;
END $$
DELIMITER ;

CALL PeliculasMasAlquiladas();


-- Crea un procedimiento almacenado que tome el ID de una película y el nuevo
-- precio de alquiler como parámetros, y actualice el precio de alquiler de esa
-- película.

DELIMITER $$

CREATE PROCEDURE ActualizarPrecioAlquiler(
    IN pelicula_id INT,
    IN nuevo_precio DECIMAL(4,2)
)
BEGIN
    -- Actualizar el precio de alquiler de la película
    UPDATE film
    SET rental_rate = nuevo_precio
    WHERE film_id = pelicula_id;
END $$

DELIMITER ;

CALL ActualizarPrecioAlquiler(1, 4.99);

DROP PROCEDURE InsertarNuevaCiudad;
-- Crear procedimiento almacenado para insertar una nueva ciudad
DELIMITER $$

CREATE PROCEDURE InsertarNuevaCiudad(
    IN nombre_ciudad VARCHAR(50),
    IN country_id INT
)
BEGIN
    -- Insertar una nueva ciudad en la tabla de ciudades
    INSERT INTO city (city, country_id) VALUES (nombre_ciudad, country_id);
END $$

DELIMITER ;

CALL InsertarNuevaCiudad('MANGOLANIA', 1);

-- Crear procedimiento almacenado para eliminar actor si no está asociado a ninguna película
DELIMITER $$

CREATE PROCEDURE EliminarActorSiNoAsociado(
    IN actor_id INT
)
BEGIN
    DECLARE contador INT;

    -- Verificar si el actor está asociado a alguna película
    SELECT COUNT(*) INTO contador
    FROM film_actor
    WHERE actor_id = actor_id;

    -- Si el contador es cero, no está asociado a ninguna película y se puede eliminar
    IF contador = 0 THEN
        -- Eliminar el actor
        DELETE FROM actor WHERE actor_id = actor_id;
        SELECT 'El actor ha sido eliminado.' AS Mensaje;
    ELSE
        SELECT 'El actor está asociado a películas y no puede ser eliminado.' AS Mensaje;
    END IF;
END $$

DELIMITER ;

CALL EliminarActorSiNoAsociado(1);





