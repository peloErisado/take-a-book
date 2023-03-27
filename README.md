# TAKE A BOOK
# Práctica de la asignatura Desarrollo de Aplicaciones Distribuidas - Fase I

## Índice

- [Informacion](#información) :clipboard:
- [Funcionalidades](#funcionalidades) :memo:
  - [Públicas](#funcionalidades-públicas) :unlock:
  - [Privadas](#funcionalidades-privadas) :lock:
  - [Servicio interno](#funcionalidades-del-servicio-interno) :email:
  - [Servicio web](#funcionalidades-web) :globe_with_meridians:
 - [Entidades](#entidades) :raising_hand:
 - [Herramientas](#herramientas) :hammer:
 - [Capturas de pantalla](#capturas-de-pantalla) :computer:
 - [Diagrama de navegación](#diagrama-de-navegación) :file_folder:
 - [Diagrama de clases UML](#diagrama-de-clases-UML) :chart:
 - [Diagrama Entidad/Relación](#diagrama-entidad-relación) :floppy_disk:
 - [Navegación](#navegación) 
 - [Diagrama de clases y templates](#diagrama-de-clases-y-templates)
 - [Documentación de la interfaz del servicio interno](#documentación-de-la-interfaz-del-servicio-interno)
 - [Instrucciones para desplegar la aplicación](#instrucciones-para-desplegar-la-aplicación)

## Información
La página web Take a Book es una aplicación de compra y préstamo de libros de todo tipo.

## Funcionalidades

### Funcionalidades públicas
Las funcionalidades públicas de esta página web serían: ver los libros disponibles que hay para comprar y prestar, ver las valoraciones que hay publicadas de los libros y crear una cuenta de usuario.

### Funcionalidades privadas
Las funcionalidad privadas de Take a Book serán: comprar y prestar libros, escribir valoraciones, seguir a ciertos autores y libros para poder recibir información sobre ellos y administrar la cuenta de usuario.

### Funcionalidades del servicio interno
Las funcionalidades del servicio interno de la página web serían: envío de correos electrónicos a los usuarios cuando estos se creen una cuenta, hagan una compra o reserva, o en caso de que se agregue a la web un nuevo trabajo de un autor al que siga.

### Funcionalidades web
Las funcionalidades web serán: meter nuevos libros y autores, borrar valoraciones y usuarios que incumplan las normas y gestionar el borrado de cuenta de un usuario.

## Entidades
Take a Book contará con las siguientes entidades:
  - Libro: representa los libros que se pueden encontrar en la página web y que se podrán comprar o tomar prestados.
  - Usuario: representa a los usuarios de la página web.
  - Compra: guarda los datos de una compra. Esta entidad relaciona el o los libros comprados con el usuario que los compra.
  - Préstamo: guarda los datos de interés de un préstamo, por ejemplo la fecha, el usuario y los libros involucrados.
  - Autor: representa a los escritores de los libros disponibles en la web.
  - Valoración: representa la valoración de los usuarios para cada libro. 

## Herramientas
Durante el desarrollo de este proyecto se hará uso de un tablero de Trello: https://trello.com/w/takeabook 


# Práctica de la asignatura Desarrollo de Aplicaciones Distribuidas - Fase II

## Capturas de pantalla de la aplicación

- Pantalla principal

![Pantalla principal](https://media.discordapp.net/attachments/1074012790051848212/1079916490616221718/image.png?width=993&height=559)

- Pantalla de autores

![Pantalla de autores](https://media.discordapp.net/attachments/1074012790051848212/1079917383029887076/image.png?width=993&height=559)

- Pantalla de libros

![Pantalla de libros](https://media.discordapp.net/attachments/1074012790051848212/1079916030010343594/image.png?width=993&height=559)

- Pantalla de un libro concreto 

![Pantalla de libro](https://media.discordapp.net/attachments/1074012790051848212/1079916135492890645/image.png?width=993&height=559)

- Pantalla de registro

![Pantalla de registro](https://media.discordapp.net/attachments/1074012790051848212/1079917454232391750/image.png?width=993&height=559)

- Pantalla de inicio de sesión

![Pantalla de inicio de sesión](https://media.discordapp.net/attachments/1074012790051848212/1079917469134766151/image.png?width=993&height=559)

- Pantalla de mis pedidos

![Pantalla de mis compras](https://media.discordapp.net/attachments/1074012790051848212/1079916200634630214/image.png?width=993&height=559)

- Pantalla de compra

![Pantalla de compra](https://media.discordapp.net/attachments/1074012790051848212/1079917663679168532/image.png?width=993&height=559)

## Diagrama de navegación

![Diagrama de navegación](https://github.com/peloErisado/take-a-book/blob/main/images_Readme/DiagramaNavegacion.drawio.png?raw=true)

## Diagrama de clases UML

![Diagrama de navegación](https://github.com/peloErisado/take-a-book/blob/main/images_Readme/Diagrama%20de%20clase.drawio.png?raw=true)

## Diagrama Entidad/Relación

![Diagrama de navegación](https://github.com/peloErisado/take-a-book/blob/main/images_Readme/DiagramaER.drawio.png?raw=true)

# Práctica de la asignatura Desarrollo de Aplicaciones Distribuidas - Fase III

## Navegación
En este apartado se van a mostrar las diferentes pantallas con las que cuenta la aplicación hasta este punto del desarrollo. En primer lugar se van a mostrar las pantallas por las que puede navegar un usuario que no se ha registrado:

- Pantalla principal

![Pantalla principal](https://media.discordapp.net/attachments/1074012790051848212/1089922463124684911/image.png?width=907&height=443)

- Pantalla de autores

![Pantalla de autores](https://media.discordapp.net/attachments/1074012790051848212/1079917383029887076/image.png?width=993&height=559)

-Pantalla de un autor concreto

![Pantalla de un autor concreto](https://media.discordapp.net/attachments/1074012790051848212/1089922714724221049/image.png?width=895&height=436)

- Pantalla de libros

![Pantalla de libros](https://media.discordapp.net/attachments/1074012790051848212/1089922563158839356/image.png?width=881&height=431)

- Pantalla de un libro concreto 

![Pantalla de libro](https://media.discordapp.net/attachments/1074012790051848212/1089922923990630531/image.png?width=881&height=430)

- Pantalla de registro

![Pantalla de registro](https://media.discordapp.net/attachments/1074012790051848212/1089922819514716230/image.png?width=881&height=432)

- Pantalla de inicio de sesión

![Pantalla de inicio de sesión](https://media.discordapp.net/attachments/1074012790051848212/1079917469134766151/image.png?width=993&height=559)

Una vez el usuario se ha registrado, tenndrá más funcionalidades en la aplicación. Estas funcionalidades se podrán ver en el header en todo moomento.

-Pantalla principal

![Pantalla principal](https://media.discordapp.net/attachments/1074012790051848212/1089925365822128228/image.png?width=895&height=437)

- Pantalla de mis pedidos

![Pantalla de mis compras](https://media.discordapp.net/attachments/1074012790051848212/1079916200634630214/image.png?width=993&height=559)

- Pantalla de compra

![Pantalla de compra](https://media.discordapp.net/attachments/1074012790051848212/1079917663679168532/image.png?width=993&height=559)

- Pantalla de escribir valoraciones

![Pantalla de escribir valoraciones](https://media.discordapp.net/attachments/1074012790051848212/1089923930845876254/image.png?width=895&height=437)

Por último, si el usuario se ha registrado como Admin, podrá acceder a algunas funcionalidades extra, como pueden ser la edición, añadido o el borrado de libros y autores.

- Pantalla de autores

![Pantalla de autores](https://media.discordapp.net/attachments/1074012790051848212/1089923697223139328/image.png?width=895&height=437)

- Pantalla de autor

![Pantalla de autor](https://media.discordapp.net/attachments/1074012790051848212/1089923773542707250/image.png?width=895&height=436)

- Pantalla de edición de libro

![Pantalla de edición de libro](https://media.discordapp.net/attachments/1074012790051848212/1089925265142063156/image.png?width=895&height=436)

El esquema de navegación de esta fase quedaría de la siguiente forma:

![Diagrama de navegación](https://media.discordapp.net/attachments/689611233586053158/1090058508499685386/Fase3-DiagramaNavegacion.jpg?width=565&height=559)

## Diagrama de clases y templates

![Diagrama de clases y templates](https://media.discordapp.net/attachments/689611233586053158/1090058508197691422/Fase3-Diagrama_de_clase.jpg?width=382&height=559)

## Documentación de la interfaz del servicio interno

La comunicación entre la aplicación y el servicio interno se realiza a través del broker de mensajes RabbitMQ alojado en un contenedor del entorno Docker. Para controlar esta comunicación, se han creado dos colas de mensajes desde las que el servicio interno puede recibir mensajes de la aplicación.

"test_queue": cola de mensajes utilizada para labores de testing y prueba de funcionalidades nuevas. No se usa en el producto final.
"mail_queue": cola hacia donde se envían todos los mensajes que tienen que ver con el envío de mails a usuarios.

Para hacer uso de estas colas de mensajes se han creado don clases: la clase Producer es la encargada de codificar y enviar toda la información de los mensajes desde la aplicación al servicios interno, mediante que la clase Consumer es la encargada de recibir esos mensajes, decodificarlos y utilizar la información recibida para enviar un correo mediante JavaMail.

## Instrucciones para desplegar la aplicación

La aplicación se ha diseñado utilizando herramientas Maven y Spring y se ha empaquitado en archivos .jar para su ejecución. Para esta empaquetación se ha utilizado el entorno de de desarrollo Eclipse "Spring Tool Suite", que permite hacer un empaquetado sencillo de la aplicación mediante Maven Install.

Para la base de datos y el la comunicación del servicio interno se han utilizado containers del entorno Docker. Para poder iniciar la base de datos es necesario, primero, instalar Docker en el ordenador. La forma más sencilla de hacerlo es mediante [DockerDesktop](https://www.docker.com/products/docker-desktop/), que ofrece una interfad de usuario sencilla de usar.

Para generar el contenedor de MySQL se ha utilizado la siguiente secuencia en la Shell:
```ruby
docker run -p 3306:3006 --name take_a_book -e MYSQL_ROOT_PASSWORD=ppassword
```
Esto genera un container de MySQL al que se puede acceder utilizando MySQL Workbench, conectándose a la dirección IP y puerto 3306 del equipo en el que se haya iniciado el contenedor.

Para el intercambio de mensajes entre servicio interno y aplicación se ha utilizado el broker de mensajes RabbitMQ. Este servicios se puede incializar en un contenedor de Docker utilizando la siguiente secuencia:
```ruby
docker run --rm -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management
```
Con ambos contenedores de Docker inicializados, lo primero que hay que hacer es configurar la base de datos. Para ello habrá que acceder al contenedor de MySQL desde MySQL Workbench e introducir la siguiente secuencia de querys.
```ruby
create database take_a_book;
create user 'adming'@'%' indentified by 'TheyllNeverGuessThisPassword';
grant all on take_a_book.* to 'admin'@'%';
```
Estas Query crean la base de datos take_a_book, donde se crearán automáticamente todas las tablas referentes a los diferentes elementos de la aplicación y crea un usuario admin con todos los permisos asociados.

Una vez hecho esto, ya sólo falta poner en funcionamiento la aplicación. Para eso, una vez empaquetada la aplicación en un .jar, sólo habrá que introducir esta secuando en la Shell desde el fichero donde se encuentre almacenado el .jar.
```ruby
java -jar <nombre_del_empaquetado>.jar
```
Haciendo esto tanto con el servicio interno como con la aplicación se pone en funcionamiento todas las funcionalidades de la página web.
