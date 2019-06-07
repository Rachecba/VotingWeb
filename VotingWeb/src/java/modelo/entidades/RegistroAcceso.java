/*  
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : RegistroAcceso.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RegistroAcceso implements Serializable {

    private RegistroAcceso() {
        accesos = new ArrayList<>();
    }

    public static RegistroAcceso obtenerInstancia() {
        if (instancia == null) {
            instancia = new RegistroAcceso();
        }
        return instancia;
    }

    public int numAccesos() {
        return accesos.size();
    }

    public void agregar(Acceso nuevoAcceso) {
        accesos.add(nuevoAcceso);
    }

    public void reiniciar() {
        accesos.clear();
    }
    
    public List<Acceso> getAccesos(){
        return accesos;
    }
    

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("[");
        ListIterator<Acceso> i = accesos.listIterator();
        while (i.hasNext()) {
            r.append(String.format("\n\t%s", i.next()));
            if (i.hasNext()) {
                r.append(", ");
            }
        }
        r.append("\n]");
        return r.toString();
    }

//    public String toStringHTML(int max) {
//        StringBuilder r = new StringBuilder();
//        ListIterator<Acceso> i = accesos.listIterator();
//        int k = 0;
//        while (i.hasNext() && ((max < 0) || (k < max))) {
//            r.append(String.format(
//                    "\n\t\t<tr><td>%d</td>%s</tr>",
//                    k + 1, i.next().toStringHTML()));
//            k++;
//        }
//        return r.toString();
//    }

//    public String toStringHTML() {
//        return toStringHTML(MAX_ACCESOS);
//    }
    

    private static final int MAX_ACCESOS = 12;
    private static RegistroAcceso instancia = null;
    private final List<Acceso> accesos;
}
