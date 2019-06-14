/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : InfoVotaciones.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/
package modelo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Datos")
public class InfoVotaciones {
    int totalVotantes;
    int votosEfectivos;
    int abstinencia;
    int totalVotos;
    Partido ganador;

    public InfoVotaciones(int totalVotantes, int votosEfectivos, int abstinencia, int totalVotos, Partido ganador) {
        this.totalVotantes = totalVotantes;
        this.votosEfectivos = votosEfectivos;
        this.abstinencia = abstinencia;
        this.totalVotos = totalVotos;
        this.ganador = ganador;
    }

    @XmlAttribute(name="totalVotantes")
    public int getTotalVotantes() {
        return totalVotantes;
    }

    public void setTotalVotantes(int totalVotantes) {
        this.totalVotantes = totalVotantes;
    }

    @XmlAttribute(name="votosEfectivos")
    public int getVotosEfectivos() {
        return votosEfectivos;
    }

    public void setVotosEfectivos(int votosEfectivos) {
        this.votosEfectivos = votosEfectivos;
    }

    @XmlAttribute(name="abstinencia")
    public int getAbstinencia() {
        return abstinencia;
    }

    public void setAbstinencia(int abstinencia) {
        this.abstinencia = abstinencia;
    }

    @XmlAttribute(name="totalVotos")
    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    @XmlAttribute(name="ganador")
    public Partido getGanador() {
        return ganador;
    }

    public void setGanador(Partido ganador) {
        this.ganador = ganador;
    }
    
    
}
