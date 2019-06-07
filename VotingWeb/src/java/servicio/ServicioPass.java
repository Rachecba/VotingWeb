/*
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : ServicioPass.java
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
import modelo.Logged;
import modelo.Usuario;
import modelo.dao.GestorAdmins;
import modelo.dao.GestorLogin;
import modelo.dao.GestorUsuarios;


@WebServlet(name = "ServicioPass", urlPatterns = {"/ServicioPass"})
public class ServicioPass extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String cedula = request.getParameter("username");
        String nueva = request.getParameter("password");
        
       if(GestorLogin.obtenerInstancia().getLogged().getTipo().equals("usuario")) //si el tipo del logged es usuario
           GestorUsuarios.obtenerInstancia().cambiarPass(nueva); //cambia la contraseña de ese usuario
       else
           GestorAdmins.obtenerInstancia().cambiarPass(nueva); // si el tipo es adnmin, entonces cambia la contraseña del admin
        
        response.sendRedirect("Inicio.jsp");
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
