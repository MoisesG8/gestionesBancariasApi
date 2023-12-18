# Bienvenido a GestionesBancariasAPI!

Servicio API REST realizado en Java Spring Boot.


# Versiones

Java 17
Maven 
Spring boot 3.2.0
Packaging Jar

## Ejecutar el proyecto

Construir el proyecto para que MAVEN gestione la descarga de todas las dependencias que este utiliza, previamente ya debe estar levantado el contenedor de docker que contiene la base de datos a la cual el servicio se va a conectar,
la base de datos escuchará peticiones a traves del puerto 1433, luego de eso se debe construir este componente en spring boot y una vez ya este levantado se procede a levantar el componente web construido en Next JS.

## Cadena de conexión a base de datos

La cadena de conexión ya se encuentra definida en el properties del proyecto, con los parámetros necesarios para lograr su conexión una vez la instancia de la base de datos ya este levantada de forma local.

## Puerto de escucha del servicio

El servicio ya esta configurado para escuchar peticiones a través del puerto: 9000.
