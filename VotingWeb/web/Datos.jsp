<%-- 
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Datos.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=, text/html; charset=UTF-81" http-equiv="Content-Type">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="css/datos.css" rel="stylesheet" type="text/css"/>
        <script src="js/encabezado.js" type="text/javascript"></script>
        <script src="js/redirect.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Satisfy|Vollkorn|Cookie|Abel|Crimson" rel="stylesheet">
        <title>Analizar Datos</title>
    </head>
    <body>
       <div id = 'encabezado' class="w3-sidebar w3-bar-block w3-indigo w3-animate-left" style="display:none">
            <button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Menu &times;</button>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectVotar()">Votar</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectDatos()">Analizar Datos</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectPass()">Cambiar contraseña</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectConfig()">Configuración</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectLogout()">Cerrar sesión</a>
       </div>
       <div id='cuerpo'class="w3-container">
           <button class="w3-button w3-indigo w3-xxlarge" onclick="w3_open()">&#9776;</button>
           <form id="config" action="ServicioDatos" method="POST">
               <h2 name="titulo">Datos recolectados de las votaciones</h2>
               <!-- aqui ingreso los datos recolectados de los partidos -->
               <h3 name="totalVotantes">Total de votantes<p name="votantes"></p></h3>
               <h3 name="votosEfectivos">Votantes con voto efectivo<p name="efectivos"></p></h3>
               <h3 name="abstinencia">Votantes que se abstuvieron<p name="abs"></p></h3>
               <h3 name="totalVotos">Total de votos por partido<p name="votos"></p></h3>
               <!-- aqui se hace en el js, una lista con los partidos. Poner atributo name a los partidos para poder agarrarlos en el servlet -->
               <h3 name="ganador">Ganador<p name="gano"></p></h3>
               <button type="submit">Descargar XML</button>
           </form>
       </div>
    </body>
</html>
