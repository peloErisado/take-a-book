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


