/*
Programación 4 - Proyecto #2
15 Junio 2019

Document   : gestorPartido.java
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
import modelo.Partido;


public class GestorPartido implements Serializable{
    private static GestorPartido instancia = null;
    
    // BASE DE DATOS 
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/bd_votaciones?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_LISTARPARTIDOS = "SELECT nombre, siglas, bandera, observaciones FROM bd_votaciones.partido";
    
    public Connection conn;
    
    public GestorPartido(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorPartido obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorPartido();
        
        return instancia;
    }
    
    public List<Partido> listarPartidos(){
        List<Partido> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARPARTIDOS);)
        {
            while(rs.next()){
                String siglas = rs.getString("siglas");
                String nombre = rs.getString("nombre");
                byte[] bandera = rs.getBytes("bandera");
                String observaciones = rs.getString("observaciones");
                
                lista.add(new Partido(siglas, nombre, bandera, observaciones));
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public String getSiglas(String partido){
        List<Partido> lista = listarPartidos();
        
        for(Partido p : lista){
            if(p.getNombre().equals(partido))
                return p.getSiglas();
        }
        
        return null;
    }
}
