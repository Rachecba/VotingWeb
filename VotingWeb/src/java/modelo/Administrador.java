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
    String cedula;
    String nombre;
    String apellido1;
    String apellido2;
    String usuario;
    String pass;

    public Administrador( String cedula, String nombre, String apellido1, String apellido2, String usuario, String pass) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.usuario = usuario;
        this.pass = pass;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
     public String getApellido1() {
        return apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
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
}
