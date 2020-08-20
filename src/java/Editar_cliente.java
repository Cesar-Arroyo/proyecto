/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucha
 */
public class Editar_cliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
             
            int id;
            
            id = Integer.parseInt(request.getParameter("id"));
            
            Cliente a = Acciones_cliente.getClienteById(id);
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Editar Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabla para actualizar datos del Cliente</h1>");
            
            out.println("from method='post' action='Editar2' name='editar' >"
                    + "<table>");
            
            out.println("<tr"
                    + "<td></td>"
                    + "<td> <input type='hidden' name='id2' value='"+a.getId()+"' > </td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Nombre: </td><td> <input type='text' name='nombre2' value='"+a.getNombre()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Apellido: </td><td> <input type='text' name='apellido2' value='"+a.getApellido()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Telefono: </td><td> <input type='text' name='telefono2' value='"+a.getTelefono()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Email: </td><td> <input type='email' name='email2' value='"+a.getEmail()+"'></td>"
                    + "</tr>"
                    + "<tr><td>Lugar</td><td><select name='lugar2'>"
                            +"<option>CDMX</option>"
                            +"<option>EDOMEX</option>"
                            +"<option>CENTRO</option>"
                            +"<option>OTRO</option>"
                            +"</select></td>"
                    + "</tr>"
                    + "<tr><td colspan='2' > <input type='submit' value='Guardar cambios'></td></tr>");
            
            
             out.println("</table>"
                    + "</form");
            
            
            
            
            out.println("</body>");
            out.println("</html>");
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
