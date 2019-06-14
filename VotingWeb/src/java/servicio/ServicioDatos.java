/*
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : ServicioDatos.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/
package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import modelo.InfoVotaciones;
import modelo.ListaUsuarios;
import modelo.beans.Archivo;

@WebServlet(name = "ServicioDatos", urlPatterns = {"/ServicioDatos"})
public class ServicioDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String titulo = request.getParameter("titulo");
            String totalVotantes = request.getParameter("totalVotantes");
            int votantes = Integer.parseInt(request.getParameter("votantes"));
            String votosEfectivos = request.getParameter("votosEfectivos");
            int efectivos = Integer.parseInt(request.getParameter("efectivos"));
            String abstinencia = request.getParameter("abstinencia");
            int abs = Integer.parseInt(request.getParameter("abs"));
            String totalVotos = request.getParameter("totalVotos");
            int votos = Integer.parseInt(request.getParameter("votos"));
            String ganador = request.getParameter("ganador");
            String gano = request.getParameter("gano");
            
//            Archivo a1 = null;
//                    try {
//                        a1 = new Archivo();
//                    } catch (ClassNotFoundException ex) {
//                        Logger.getLogger(ServicioConfig.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (IllegalAccessException ex) {
//                        Logger.getLogger(ServicioConfig.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (InstantiationException ex) {
//                        Logger.getLogger(ServicioConfig.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    
                   // InfoVotaciones info = new InfoVotaciones(votantes, efectivos, abs, votos, ganador);
                    
                  //  a1.crearXML();  
                    
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
