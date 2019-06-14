/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : config.js
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */

function init(){
    jsonCandidatos();
    jsonPartidos();
}

function jsonCandidatos(){
    fetch("ServicioUsuarios").then(
            (resultados) => {
                return resultados.json();}
            ).then(
            (datosJSON) => {
                cargarCandidatos(datosJSON);
            }
            );
}

function jsonPartidos(){
    fetch("ServicioPartidos").then(
            (resultados) => {
                return resultados.json();}
            ).then(
            (datosJSON) => {
                cargarPartidos(datosJSON);
            }
            );
}

function cargarCandidatos(datos){
    var select = document.getElementById("selectCand");
    
    for(var i = 0; i < datos.candidatos.length; i++) {
        var opt = document.createElement('option');
        opt.value = datos.candidatos[i].cedula;
        opt.innerHTML = datos.candidatos[i].nombre;
        select.appendChild(opt);
    }
}

function cargarPartidos(datos){
    var select = document.getElementById("selectPart");
    
    for(var i = 0; i < datos.partidos.length; i++) {
        var opt = document.createElement('option');
        opt.value = datos.partidos[i].nombre;
        opt.innerHTML = datos.partidos[i].nombre;
        select.appendChild(opt);
    }
}

function agregar(){ //hacer para agregar a la tabla 
    var form = document.getElementById("config");
    var selectCand = document.getElementById("selectCand");
    var candidato = selectCand.options[selectCand.selectedIndex].text;
    var selectPart = document.getElementById("selectPart");
    var partido = selectPart.options[selectPart.selectedIndex].text;
    
    form.innerHTML+= '<p><strong>Partido: </strong>'+'<input type="text" name="Partido" value="'+partido+'">' +'</p>'+ 
                    '<p><strong>Candidato: </strong>'+'<input type="text" name="Candidato" value="'+candidato+'">' +'</p>';
    
}
