/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Acceso.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo.entidades;

import java.io.Serializable;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modelo.Usuario;

public class Acceso implements Serializable {

    public Acceso(Usuario usuario, Date fecha) throws UnknownHostException {
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Acceso(Usuario usuario) throws UnknownHostException {
        this(usuario, Calendar.getInstance().getTime());
    }

    public Acceso() throws UnknownHostException {
//        if(GestorLogin.obtenerInstancia().getLogged().getTipo().equals("usuario")){
//            this(GestorUsuarios.obtenerInstancia().getUsuario(GestorLogin.obtenerInstancia().getLogged().getUser().getCedula()), Calendar.getInstance().getTime());
//        
        this(null, Calendar.getInstance().getTime());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new Acceso());
        } catch (UnknownHostException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }

    private static final int MAX_INACTIVIDAD = 5;
    private static final DateFormat FMT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    private final Usuario usuario;
    private final Date fecha;
}
