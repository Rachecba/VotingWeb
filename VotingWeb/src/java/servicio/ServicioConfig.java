/*
    Programación 4 - Proyecto #2
    15 Junio 2019

    Document   : ServicioLogout.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/
package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.ListaUsuarios;
import modelo.beans.Archivo;
import modelo.dao.GestorVotacion;

@MultipartConfig
@WebServlet(name = "ServicioConfig", urlPatterns = {"/ServicioConfig"})
public class ServicioConfig extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
            //Info
            String inicio = request.getParameter("fecha_inicio");
            String fin = request.getParameter("fecha_final");
            
            if(!inicio.isEmpty() && !fin.isEmpty())
                GestorVotacion.obtenerInstancia().crearVotacion(inicio, fin); //creo una votacion en esas fechas
            
            //partidos y sus candidatos
            String[] partidos = request.getParameterValues("Partido");
            String[] candidatos = request.getParameterValues("Candidato");
            
            if(partidos != null && candidatos != null){
                for(int i = 0; i<partidos.length; i++){
                    for(int j = 0; j<candidatos.length; j++){
                        GestorVotacion.obtenerInstancia().insertarPartidoVotacion(inicio, fin, partidos[i], candidatos[i]); //inserto los partidos a la votacion de esa fecha
                    }
                }
            }
            
            //Archivo
            for(Part part: request.getParts()){
                String archivo = part.getSubmittedFileName();
                
                if(archivo == null || archivo.isEmpty()){
                    //enviar un mensaje de que no se selecciono archivo
                    break;
                }
                
                if(Archivo.validate(archivo)){
                    try {
                        ListaUsuarios usuarios = ListaUsuarios.obtenerListaUsuarios(part.getInputStream());
                        Archivo.obtenerInstancia().saveFile(usuarios);
                    } catch (Exception ex) {
                        //request.setAttribute("mensaje", String.format("Excepción: '%s'", ex.getMessage()));
                    }
                } else {
                    // request.setAttribute("mensaje", "El formato del archivo es incorrecto.");
                    break;
                }
            }
        } catch (IOException | ServletException ex) {
            // request.setAttribute("mensaje", String.format("Ocurrió una excepción: '%s'", ex.getMessage()));
        }
        
       response.sendRedirect("Configuracion.jsp");
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
