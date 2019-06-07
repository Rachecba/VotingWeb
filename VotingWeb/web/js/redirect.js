/*
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : redirect.js
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/

function redirectPass(){
    location.replace("password.jsp");
}

function redirectVotar(){
    location.replace("Inicio.jsp");
}

function redirectDatos(){
    location.replace("Datos.jsp");
}

function redirectConfig(){
    location.replace("Configuracion.jsp");
}

function redirectLogout(){
    document.forms[0].action = "ServicioLogout";
    document.forms[0].submit();
}