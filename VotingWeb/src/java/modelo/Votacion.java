/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Votacion.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;


public class Votacion {
    int id;
    String fecha_inicio;
    String fehca_apertura;
    String fecha_cierre;
    String fecha_final;
    int estado;

    public Votacion(int id, String fecha_inicio, String fehca_apertura, String fecha_cierre, String fecha_final, int estado) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fehca_apertura = fehca_apertura;
        this.fecha_cierre = fecha_cierre;
        this.fecha_final = fecha_final;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFehca_apertura() {
        return fehca_apertura;
    }

    public void setFehca_apertura(String fehca_apertura) {
        this.fehca_apertura = fehca_apertura;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
