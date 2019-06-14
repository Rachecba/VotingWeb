/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : ServicioVotacion.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */
package servicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.GestorUsuarios;
import modelo.dao.GestorVotacion;

@WebServlet(name = "ServicioVotacion", urlPatterns = {"/ServicioVotacion"})
public class ServicioVotacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String siglas = request.getParameter("voto");
            
            if(GestorUsuarios.obtenerInstancia().validarVotacion())
                GestorVotacion.obtenerInstancia().setVotos(siglas);
            else{}
                //eviar mensaje de que no puede votar
        }
        
        //hacer logout
        HttpSession sesion = request.getSession(true);
        sesion.invalidate();
        response.sendRedirect("index.jsp");
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
