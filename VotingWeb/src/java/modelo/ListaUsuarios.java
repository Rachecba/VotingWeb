/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : ListaUsuarios.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/

package modelo;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="lista-usuarios")
public class ListaUsuarios implements Serializable{
    private List<Usuario> lista;

    public ListaUsuarios(List<Usuario> lista) {
        this.lista = lista;
    }

    public ListaUsuarios() {
        this(new ArrayList<Usuario>());
    }
    
    @XmlElement(name="usuario") 
    public List<Usuario> getListUsuarios(){
        return lista;
    }
     public static ListaUsuarios obtenerListaUsuarios(InputStream entrada) throws JAXBException {
        ListaUsuarios r = null;
        try {
            JAXBContext ctx = JAXBContext.newInstance(ListaUsuarios.class);
            Unmarshaller mrs = ctx.createUnmarshaller();
            r = (ListaUsuarios) mrs.unmarshal(entrada);
        } catch (JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw ex;
        }
        return r;
    }
}
