# Bienvenido a GestionesBancariasAPI!

Servicio API REST realizado en Java Spring Boot.

# Versiones

Java 17
Maven
Spring boot 3.2.0
Packaging Jar

## EJECUTAR CONTENEDOR DE DOCKER CON BASE DE DATOS.

Ejecutar el archivo yaml, llamado despliegue, utilizar el siguiente comando: docker-compose -f despliegue.yml up, luego de ejecutar el archivo, verificar que el contenedor se encuentre arriba, utilizar un gestor de bd para conectarse a la instancia, server: localhost, port:1433, username:sa, password:SQL#1234, una vez hecho eso, ejecutar los script de base de datos en el siguiente orden:
NOTA: ESTOS ARCHIVO SE ENCUENTRAN EN LAS CARPETAS, DDL, DML Y TRIGGERS EL ORDEN DE EJECUCION ES EL SIGUIENTE:

1. SQLQuery_DDL_CreateDB_1
2. SQLQuery_DDL_CreateTablas_2
3. SQLQuery_NumeroCuenta_3 <-- verificar que se tiene selecciona la base de datos creada anteriormente cuando se ejecute la creación de los triggers.
4. SQLQuery_NumeroChequera_4 <-- verificar que se tiene selecciona la base de datos creada anteriormente cuando se ejecute la creación de los triggers.
5. SQLQuery_DML_5

## Ejecutar el proyecto

Construir el proyecto para que MAVEN gestione la descarga de todas las dependencias que este utiliza.

## Cadena de conexión a base de datos

La cadena de conexión ya se encuentra definida en el properties del proyecto, con los parámetros necesarios para lograr su conexión una vez la instancia de la base de datos ya este levantada de forma local.

## Puerto de escucha del servicio

El servicio ya esta configurado para escuchar peticiones a través del puerto: 9000.
