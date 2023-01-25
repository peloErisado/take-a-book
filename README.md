# TAKE A BOOK
Práctica de la asignatura Desarrollo de Aplicaciones Distribuidas - Fase I

La página web Take a Book es una aplicación de compra y préstamo de libros de todo tipo.

Las funcionalidades públicas de esta página web serían: ver los libros disponibles que hay para comprar y prestar, ver las valoraciones que hay publicadas de los libros y crear una cuenta de usuario.
Las funcionalidad privadas de Take a Book serán: comprar y prestar libros, escribir valoraciones, seguir a ciertos autores y libros para poder recibir información sobre ellos y administrar la cuenta de usuario.

Take a Book contará con las siguientes entidades:
  - Libro: representa los libros que se pueden encontrar en la página web y que se podrán comprar o tomar prestados.
  - Usuario: representa a los usuarios de la página web.
  - Compra: guarda los datos de una compra. Esta entidad relaciona el o los libros comprados con el usuario que los compra.
  - Préstamo: guarda los datos de interés de un préstamo, por ejemplo la fecha, el usuario y los libros involucrados.
  - Autor: representa a los escritores de los libros disponibles en la web.
  - Valoración: representa la valoración de los usuarios para cada libro. 

Las funcionalidades del servicio interno de la página web serían: envío de correos electrónicos a los usuarios cuando estos se creen una cuenta, hagan una compra o reserva, o en caso de que se agregue a la web un nuevo trabajo de un autor al que siga. Otras funcionalidades internas serán meter nuevos libros y autores, borrar valoraciones y usuarios que incumplan las normas y gestionar el borrado de cuenta de un usuario.

Durante el desarrollo de este proyecto se hará uso de un tablero de Trello: https://trello.com/w/takeabook 
