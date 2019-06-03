/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Candidato.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

import java.io.Serializable;

public class Candidato implements Serializable{
    String partido;
    String siglas;
    byte[] bandera;
    String nombreCand;
    String apellidos;
    long cedula;
    byte[] postulante;
    String observaciones;

    public Candidato(String partido, String siglas, byte[] bandera, String nombreCand, String apellidos, long cedula, byte[] postulante, String observaciones) {
        this.partido = partido;
        this.siglas = siglas;
        this.bandera = bandera;
        this.nombreCand = nombreCand;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.postulante = postulante;
        this.observaciones = observaciones;
    }

    public Candidato() {
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public byte[] getBandera() {
        return bandera;
    }

    public void setBandera(byte[] bandera) {
        this.bandera = bandera;
    }

    public String getNombreCand() {
        return nombreCand;
    }

    public void setNombreCand(String nombreCand) {
        this.nombreCand = nombreCand;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public byte[] getPostulante() {
        return postulante;
    }

    public void setPostulante(byte[] postulante) {
        this.postulante = postulante;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
