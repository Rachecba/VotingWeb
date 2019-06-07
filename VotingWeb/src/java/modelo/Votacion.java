/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : Votacion.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo;

import java.util.Date;

public class Votacion {
    int id;
    Date fecha_inicio;
    Date fehca_apertura;
    Date fecha_cierre;
    Date fecha_final;
    int estado;

    public Votacion(int id, Date fecha_inicio, Date fehca_apertura, Date fecha_cierre, Date fecha_final, int estado) {
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFehca_apertura() {
        return fehca_apertura;
    }

    public void setFehca_apertura(Date fehca_apertura) {
        this.fehca_apertura = fehca_apertura;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
