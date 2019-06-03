/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Usuario.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
    long cedula;
    String nombre;
    String apellidos;
    String pass;
    
    public Usuario(){
        this.cedula = 0;
        this.nombre = "";
        this.apellidos = "";
        this.pass = "";
    }

    public Usuario(long cedula, String nombre, String apellidos, String pass) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pass = pass;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
