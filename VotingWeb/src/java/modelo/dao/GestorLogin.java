/*
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : GestorLogin.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo.dao;

import java.io.Serializable;
import java.util.List;
import modelo.Administrador;
import modelo.Logged;
import modelo.Usuario;

public class GestorLogin implements Serializable{
    private static GestorLogin instancia = null;
    public Logged logged = null;
    boolean validado = false;
    boolean entro = false;
    
     public GestorLogin(){
      
    }
    
    public static GestorLogin obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorLogin();
        
        return instancia;
    }
    
    public boolean validateLogin(String username, String pass){
        List<Usuario> usuarios = GestorUsuarios.obtenerInstancia().listarUsuarios();
        
        List<Administrador> admins = GestorAdmins.obtenerInstancia().listarAdmins();
               
        for(Usuario u : usuarios){
            if(u.getCedula().equals(username) && u.getPass().equals(pass)){
                validado = true;
                Usuario user = new Usuario(username, u.getNombre(), u.getApellido1(), u.getApellido2(), pass, 1);
                logged = new Logged(user, null, "usuario");
                GestorUsuarios.obtenerInstancia().cambiarActivo(username);
                return validado;
            }
        }
        
        for(Administrador a: admins){
            if(a.getUsuario().equals(username) && a.getPass().equals(pass)){
                validado = true;
                Administrador admin = new Administrador(a.getCedula(), a.getNombre(), a.getApellido1(), a.getApellido2(), username, pass);
                logged = new Logged(null, admin, "admin");
                return validado;
            }
        }
        return validado;
    }
    
    public Logged getLogged() {
        return logged;
    }

    public void setLogged(Logged logged) {
        this.logged = logged;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public boolean isEntro() {
        return entro;
    }

    public void setEntro(boolean entro) {
        this.entro = entro;
    }
    
}
