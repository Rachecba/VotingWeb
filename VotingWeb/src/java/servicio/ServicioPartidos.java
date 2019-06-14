/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : ServicioPartidos.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Partido;
import modelo.dao.GestorPartido;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "ServicioPartidos", urlPatterns = {"/ServicioPartidos"})
public class ServicioPartidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            List<Partido> partidos = GestorPartido.obtenerInstancia().listarPartidos();
            System.out.println(partidos);
            
            JSONObject obj = new JSONObject();
            JSONArray array = new JSONArray();
            
            for(Partido u : partidos){
                JSONObject pobj = new JSONObject();
                pobj.put("nombre", u.getNombre());
                pobj.put("siglas", u.getSiglas());
                pobj.put("bandera", u.getBandera());
                array.put(pobj);
            }
            
            obj.put("partidos", array);
            System.out.println(obj);
            out.print(obj);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
