/*
Programación 4 - Proyecto #2
15 Junio 2019

Document   : gestorUsuarios.java
Author     : Rachel Basulto 801030879
             Danny Gómez    116440310
*/
package modelo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Administrador;
import modelo.Logged;

public class GestorAdmins implements Serializable{
    private static GestorAdmins instancia = null;
    
    // BASE DE DATOS 
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/bd_votaciones?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARADMINS = "SELECT cedula, apellido1, apellido2, nombre, usuario, clave FROM bd_votaciones.administrador";
    private static final String CMD_PASSWORD = "UPDATE bd_votaciones.administrador SET clave = '%s' WHERE usuario = '%s';";
    
    public Connection conn;
    
    public GestorAdmins(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorAdmins obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorAdmins();
        
        return instancia;
    }
    
    public List<Administrador> listarAdmins(){
        List<Administrador> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARADMINS);)
        {
            while(rs.next()){
                String id = rs.getString("cedula");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String nombre = rs.getString("nombre");
                String clave = rs.getString("clave");
                String usuario = rs.getString("usuario");
                
                lista.add(new Administrador(id, nombre, apellido1, apellido2, usuario, clave));
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
            stm.executeUpdate(String.format(CMD_PASSWORD, nueva, logged.getAdmin().getUsuario()));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
}
