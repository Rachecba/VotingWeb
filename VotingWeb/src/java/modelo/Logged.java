/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Logged.java
    Author     : Rachel Basulto 801030879
*/      
package modelo;

import java.io.Serializable;

public class Logged implements Serializable{
    Usuario user;
    Administrador admin;
    String tipo;

    public Logged(Usuario user, Administrador admin, String tipo) {
        this.user = user;
        this.admin = admin;
        this.tipo = tipo;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
