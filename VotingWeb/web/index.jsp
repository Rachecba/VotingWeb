<%-- 
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : index.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Satisfy|Vollkorn|Cookie|Abel" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <div id="h1">
            <h2> Registrarse </h2>
             <div id='imgcontainer'>
             <img src="https://www.shareicon.net/data/512x512/2017/05/30/886553_user_512x512.png" alt=""/> 
            </div>
        </div>
        <form action="ServicioLogin" method="post" id="loginForm">
            <div class="container">
                <label for="username"><br>Usuario</label><br>
                <input type="text" placeholder="Ingrese usuario" name="username" required>
                <label for="password"><br>Contraseña</label><br>
                <input type="password" placeholder="Ingrese contraseña" name="password" required><br>
                <button type="submit">Entrar</button><br>
            </div>
        </form>
        <p id='aviso'>Si es primera vez que ingresa, use su número de cédula como contraseña</p>
    </body>
</html>
