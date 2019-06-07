/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : VotacionPartido.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

public class VotacionPartido {
    int id;
    String siglas;
    String cedula;
    byte[] fotoCandidato;
    int votos;

    public VotacionPartido(int id, String siglas, String cedula, byte[] fotoCandidato, int votos) {
        this.id = id;
        this.siglas = siglas;
        this.cedula = cedula;
        this.fotoCandidato = fotoCandidato;
        this.votos = votos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public byte[] getFotoCandidato() {
        return fotoCandidato;
    }

    public void setFotoCandidato(byte[] fotoCandidato) {
        this.fotoCandidato = fotoCandidato;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
}
