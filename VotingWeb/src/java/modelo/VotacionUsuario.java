/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : votacionUsuario.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

public class VotacionUsuario {
    int id;
    String cedula;
    int completo;

    public VotacionUsuario(int id, String cedula, int completo) {
        this.id = id;
        this.cedula = cedula;
        this.completo = completo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCompleto() {
        return completo;
    }

    public void setCompleto(int completo) {
        this.completo = completo;
    }
    
    
}
