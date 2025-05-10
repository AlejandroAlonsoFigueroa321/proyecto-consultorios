El proyecto se creo con java21 + springboot + mysql 
Para poder tener info inicial, se tiene que ejecutar mysql lo siguiente:
CREATE DATABASE CONSULTORIOS;
USE CONSULTORIOS;
INSERT INTO DOCTOR(id, apellido_materno, apellido_paterno, especialidad, nombre)
VALUES(1, "Figueroa","Alonso", "Pediatra", "Alejandro");
INSERT INTO DOCTOR(id, apellido_materno, apellido_paterno, especialidad, nombre)
VALUES(2, "Perez","Lopez", "Pediatra", "Mariana");
INSERT INTO DOCTOR(id, apellido_materno, apellido_paterno, especialidad, nombre)
VALUES(3, "Gomez","Martínez", "Pediatra", "Gustavo");


INSERT INTO CONSULTORIO(ID, NUMERO_CONSULTORIO, PISO)
VALUES(1, 45, 3);
INSERT INTO CONSULTORIO(ID, NUMERO_CONSULTORIO, PISO)
VALUES(2, 35, 1);
INSERT INTO CONSULTORIO(ID, NUMERO_CONSULTORIO, PISO)
VALUES(3, 425, 2);

Con eso quedan registrados los doctores y consultorios, lo que va a permitir guardar citas asociadas.

Para ingresar a la pantalla, la url es http://localhost:8080/citas
