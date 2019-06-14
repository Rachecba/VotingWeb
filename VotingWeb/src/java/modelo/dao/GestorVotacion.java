/*
Programación 4 - Proyecto #2
15 Junio 2019

Document   : gestorVotacion.java
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Usuario;
import modelo.Votacion;
import modelo.VotacionPartido;

public class GestorVotacion implements Serializable{

    private static GestorVotacion instancia = null;
    
    // BASE DE DATOS 
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost/bd_votaciones?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String CMD_CREARVOTACION = "INSERT INTO bd_votaciones.votacion (id, fecha_inicio, fecha_apertura, fecha_cierre, fecha_final, estado) VALUES('%s', '%s', '%s', '%s', '%s', %d);";
    private static final String CMD_INSERTARPARTIDO = "INSERT INTO bd_votaciones.votacion_partido (votacion_id, partido_siglas, cedula_candidato, foto_candidato, tipo_imagen, votos_obtenidos) VALUES('%s', '%s', '%s', '%s', '%s', %d);";
    private static final String CMD_LISTARVOTACIONES = "SELECT id, fecha_inicio, fecha_apertura, fecha_cierre, fecha_final FROM bd_votaciones.votacion;";
    private static final String CMD_SETFECHAS = "UPDATE bd_votaciones.votacion SET fecha_apertura = '%s', fecha_final = '%s', fecha_cierre = '%s' WHERE id = '%s';";
    private static final String CMD_PARTIDOS = "SELECT votacion_id, partido_siglas, cedula_candidato, foto_candidato, votos_obtenidos FROM bd_votaciones.votacion_partido;";
    private static final String CMD_AGREGARVOTO = "UPDATE bd_votaciones.votacion_partido SET votos_obtenidos = %d WHERE partido_siglas = '%s';";
    
    
    public Connection conn;
    public int count = 0;
    
    public GestorVotacion(){
        try{
            Class.forName(DATABASE_DRIVER).newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static GestorVotacion obtenerInstancia(){
        if(instancia == null)
            instancia = new GestorVotacion();
        
        return instancia;
    }
    
    public List<Votacion> listarVotaciones(){
        List<Votacion> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTARVOTACIONES);)
        {
            while(rs.next()){
                int id = rs.getInt("id");
                String fecha_inicio = rs.getString("fecha_inicio");
                String fecha_apertura = rs.getString("fecha_apertura");
                String fecha_cierre = rs.getString("fecha_cierre");
                String fecha_final = rs.getString("fecha_final");
                int estado = rs.getInt("estado");
                
                lista.add(new Votacion(id, fecha_inicio, fecha_apertura, fecha_cierre, fecha_final, estado));
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public void crearVotacion(String inicio, String fin){
        
        List<Votacion> lista = listarVotaciones();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            
            for(Votacion v : lista){
                if(v.getFehca_apertura().equals(inicio) && v.getFecha_final().equals(fin)){
                    stm.executeUpdate(String.format(CMD_SETFECHAS, inicio, fin, fin));
                    break;
                }
            }
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format( new Date()   );
            
            stm.executeUpdate(String.format(CMD_CREARVOTACION, count++, dateString, inicio, fin, fin, 0));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public void insertarPartidoVotacion(String inicio, String fin, String partido, String candidato){
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            String siglas = GestorPartido.obtenerInstancia().getSiglas(partido);
            String ced = GestorUsuarios.obtenerInstancia().getCed(candidato);
            //Usuario foto = GestorUsuarios.obtenerInstancia().getUsuario(ced);
            stm.executeUpdate(String.format(CMD_INSERTARPARTIDO, count++, siglas, ced, null, "jpg", 0));
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
        
    public List<VotacionPartido> listarPartidos(){
        List<VotacionPartido> lista = new ArrayList<>();
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();
                ResultSet rs = stm.executeQuery(CMD_PARTIDOS);)
        {
            while(rs.next()){
                    int id = rs.getInt("votacion_id");
                    String partido_siglas = rs.getString("partido_siglas");
                    String cedula_candidato = rs.getString("cedula_candidato");
                    byte[] foto_candidato = rs.getBytes("foto_candidato");
                    int votos_obtenidos = rs.getInt("votos_obtenidos");
                
                lista.add(new VotacionPartido(id, partido_siglas, cedula_candidato, foto_candidato, votos_obtenidos));
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return lista;
    }
    
    public void setVotos(String siglas){
        
        List<VotacionPartido> lista = listarPartidos();
        
        
        try(Connection conexion = DriverManager.getConnection(CONEXION, USUARIO, CLAVE);
                Statement stm = conexion.createStatement();)
        {
            for(VotacionPartido v : lista){
                if(v.getSiglas().equals(siglas)){
                    int votos = v.getVotos() + 1;
                    stm.executeUpdate(String.format(CMD_AGREGARVOTO, votos, siglas));
                }
            }
        }catch(SQLException ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
}   
