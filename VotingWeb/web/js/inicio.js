/*
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : inicio.js
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/

function init(){
    solicitarDatos("ServicioDatosVotacion");
}

function solicitarDatos(file){
    fetch(file).then(
            (resultados) => {
                return resultados.json();}
            ).then(
            (datosJSON) => {
                cargarTabla(datosJSON);
            }
            );
}

function cargarTabla(datosJSON){
    
    var refTabla = document.getElementById("tabla");
    var id = document.getElementById("votoID");
    
    for(var i = 0; i < datosJSON.partidos.length; i++){
        
        var nuevaFila = refTabla.insertRow(-1);
        var nuevaCelda;
        
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerText = datosJSON.partidos[i].siglas;
        
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerText = datosJSON.partidos[i].candidatoNombre;
    
    }
    
}



