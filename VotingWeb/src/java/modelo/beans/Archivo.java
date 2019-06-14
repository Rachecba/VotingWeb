/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Archivo.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/
package modelo.beans;

import cr.ac.database.managers.DBManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import modelo.InfoVotaciones;
import modelo.ListaUsuarios;
import modelo.Usuario;

public class Archivo implements Serializable{
    
    private static Archivo instancia = null;
    
    private static final String FILE_PATTERN = "([^\\s]+(\\.(?i)(xml|csv|txt))$)";
    
    private static final Pattern PATTERN = Pattern.compile(FILE_PATTERN);
    
    //BASE DE DATOS
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/bd_votaciones?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_INSERT_USERS = "INSERT INTO usuario(cedula, apellido1, apellido2, nombre, clave, activo) VALUES(?, ?, ?, ?, ?, ?); ";
    
    public Connection conn;
        
    
    public Archivo(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static Archivo obtenerInstancia(){
        if(instancia == null)
            instancia = new Archivo();
        
        return instancia;
    }
    
    public static boolean validate(final String fileName) {
        Matcher matcher = PATTERN.matcher(fileName);
        return matcher.matches();
    }
    
    public void saveFile(ListaUsuarios lista) throws SQLException, Exception{
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                PreparedStatement stm = conexion.prepareStatement(CMD_INSERT_USERS);)
        {
            for(Usuario user : lista.getListUsuarios()){
                stm.setString(1, user.getCedula());
                stm.setString(2, user.getApellido1());
                stm.setString(3, user.getApellido2());
                stm.setString(4, user.getNombre());
                stm.setString(5, user.getCedula());
                stm.setInt(6, user.getActivo());
                
                int r = stm.executeUpdate();
                
                if (r == 1) {
                    System.out.printf("Se agregraron con exito los usuarios:");
                } else {
                    throw new Exception("No se pudieron insertar los usarios a la base.");
                }
            }
        }
        catch(Exception e){
            System.err.printf("Excepción: '%s'%n", e.getMessage());
            throw e;}
    }
    
    public void crearXML(InfoVotaciones datos){
//    JAXBContext ctx = JAXBContext.newInstance(InfoVotacion.class); //hacer una clase con eiquetas xml, con lista de usuarios, para poder meter los uduarios
//                    
//                    Marshaller mrs = ctx.createMarshaller();
//                    ListaUsuarios usuarios = (ListaUsuarios) mrs.unmarshal(part.getInputStream());
    }
    
//    private Connection getConnection() throws SQLException {
//        return db.getConnection(
//                properties.getProperty("database_name", "bd_votaciones"),
//                properties.getProperty("username"),
//                properties.getProperty("password")
//        );
//    }
//    
//     private Connection getConexion() throws SQLException {
//        return db.getConnection(
//                properties.getProperty("conexion")
//        );
//    }
    
}
