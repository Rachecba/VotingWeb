/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Partido.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

public class Partido {
    String siglas;
    String nombre;
    byte[] bandera;
    String observaciones;

    public Partido(String siglas, String nombre, byte[] bandera, String observaciones) {
        this.siglas = siglas;
        this.nombre = nombre;
        this.bandera = bandera;
        this.observaciones = observaciones;
    }
    
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getBandera() {
        return bandera;
    }

    public void setBandera(byte[] bandera) {
        this.bandera = bandera;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
}
