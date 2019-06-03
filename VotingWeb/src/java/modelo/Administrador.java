/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Administrador.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

import java.io.Serializable;

public class Administrador implements Serializable {
    long cedula;
    String nombre;
    String apellidos;
    String usuario;
    String pass;
    String observaciones;

    public Administrador(long cedula, String nombre, String apellidos, String usuario, String pass, String observaciones) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.pass = pass;
        this.observaciones = observaciones;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
