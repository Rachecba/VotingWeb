/*
Programación 4 - Proyecto #2
15 Junio 2019

Document   : gestorUsuarios.java
Author     : Rachel Basulto 801030879
             Danny Gómez    116440310
*/
package modelo.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Logged;
import modelo.Usuario;

public class GestorUsuarios implements Serializable{
    private static GestorUsuarios instancia = null;
    
    // BASE DE DATOS 
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/bd_votaciones?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARUSUARIOS = "SELECT cedula, apellido1, apellido2, nombre, clave, activo FROM bd_votaciones.usuario";
    private static final String CMD_PASSWORD = "UPDATE bd_votaciones.usuario SET clave = '%s' WHERE cedula = '%s';";
    private static final String CMD_ACTIVO = "UPDATE bd_votaciones.usuario SET activo = '%d' WHERE cedula = '%s';";
    
    public Connection conn;
    
    public GestorUsuarios(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorUsuarios obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorUsuarios();
        
        return instancia;
    }
    
    public List<Usuario> listarUsuarios(){
        List<Usuario> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARUSUARIOS);)
        {
            while(rs.next()){
                String id = rs.getString("cedula");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String nombre = rs.getString("nombre");
                String clave = rs.getString("clave");
                int activo = rs.getInt("activo");
                
                lista.add(new Usuario(id, nombre, apellido1, apellido2, clave, activo));
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public void cambiarPass(String nueva){
        Logged logged = GestorLogin.obtenerInstancia().getLogged();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            stm.executeUpdate(String.format(CMD_PASSWORD, nueva, logged.getUser().getCedula()));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public void cambiarActivo(String ced){
        Logged logged = GestorLogin.obtenerInstancia().getLogged();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            try {
                stm.executeUpdate(String.format(CMD_ACTIVO, 1, ced));
            } catch (SecurityException ex) {
                Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public boolean buscarUsuario(String ced){
        List<Usuario> lista = listarUsuarios();
        
        for(Usuario u : lista){
            if(u.getCedula().equals(ced))
                return true;
        }
        return false;
    }
    
    public Usuario getUsuario(String ced){
        List<Usuario> lista = listarUsuarios();
        
        for(Usuario u : lista){
            if(u.getCedula().equals(ced))
                return u;
        }
        return null;
    }
}
