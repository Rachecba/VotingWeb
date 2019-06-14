/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Usuario.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

public class Usuario implements Serializable{
    String cedula;
    String nombre;
    String apellido1;
    String apellido2;
    String clave;
    int activo;
    
    public Usuario(){
       this.clave = "";
    }

    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String clave, int activo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.clave = clave;
        this.activo = activo;
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getApellido1() {
        return apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getClave() {
        return clave;
    }

    public void setPass(String clave) {
        this.clave = clave;
    }
    
    
}
