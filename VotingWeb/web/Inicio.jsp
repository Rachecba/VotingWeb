<%-- 
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : inicio.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=, text/html; charset=UTF-81" http-equiv="Content-Type">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
        <script src="js/encabezado.js" type="text/javascript"></script>
        <script src="js/redirect.js" type="text/javascript"></script>
        <script src="js/inicio.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Satisfy|Vollkorn|Cookie|Abel|Crimson" rel="stylesheet">
        <title>Votacion</title>
    </head>
    <body onload="init()">
        <div id = 'encabezado' class="w3-sidebar w3-bar-block w3-indigo w3-animate-left" style="display:none">
            <button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Menu &times;</button>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectVotar()">Votar</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectDatos()">Analizar Datos</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectPass()">Cambiar contraseña</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectConfig()">Configuración</a>
            <a href="#" class="w3-bar-item w3-button" onClick ="redirectLogout()">Cerrar sesión</a>
        </div>
        <div id='cuerpo' class="w3-container">
            <button class="w3-button w3-indigo w3-xxlarge" onclick="w3_open()">&#9776;</button>
            <h2>Seleccione su partido favorito</h2>
            <form action="ServicioVotacion" method="POST">
                <table id="tabla">
                    <thead>
                    <th>Partido</th>
                    <th>Candidato</th>
                    </thead>
                    <tbody></tbody>
                </table>
                <label>Voto: </label><input name="voto" type="text" placeholder="Inserte las siglas del partido. En mayusculas.">
                <button type="submit">Enviar votacion</button>
            </form>
            <!-- aqui ingreso en el JS los partidos. Cada partido tendra: Nombre con siglas, Bandera, Candidato. -->
        </div>
    </body>
</html>
