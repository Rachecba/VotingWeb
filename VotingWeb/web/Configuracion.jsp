<%-- 
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Configuracion.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>
<%@page import="modelo.beans.Archivo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=, text/html; charset=UTF-81" http-equiv="Content-Type">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="css/inicio.css" rel="stylesheet" type="text/css"/>
        <script src="js/encabezado.js" type="text/javascript"></script>
        <script src="js/redirect.js" type="text/javascript"></script>
        <script src="js/config.js" type="text/javascript"></script>
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
            <h2>Configuración de Votaciones</h2>
            <p>En esta página podrá configurar las votaciones que desee. Más abajo se presentan las opciones de configuración.</p>
            <form id="config" action="ServicioConfig" method="POST" enctype="multipart/form-data">
                <p>Cargar usuarios desde archivo de texto o XML. <strong>Archivo:&nbsp;</strong><input type="file" id="archivo" name="archivo" /></p> <!-- aqui ingreso un botocinto como el de la tarea para que seleccione el archivo -->
                <p>Asocie un candidato a cada partido    <strong>Candidato:</strong><select name="candidatos" id="selectCand"></select><strong>Partido:</strong><select name="partidos" id="selectPart"></select> <button onclick="agregar()">Agregar</button></p> <!-- aqui puedo hacer un tipo de drop down, donde hayan dos y seleccione un candidato para cada uno o algo asi-->
                <div id="partidosCandidatos" name="formulario">
                    <p><strong>Partidos y Candidatos</strong></p>
                </div><!-- aqui van los candidatos con su partido  -->
                <p>Fecha de inicio <input type='date' name="fecha_inicio"></p> <!-- aqui pongo un calendario -->
                <p>Fecha final <input type='date' name="fecha_final"></p> <!-- aqui pongo un calendario -->
                <button type="submit">Enviar</button> <!-- este boton crea la votacion, solo que no se a donde van los datos de la votacion.. van a votacion-partido -->
            </form>
        </div>
    </body>
</html>
