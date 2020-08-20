/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucha
 */
public class Consultar_clientes extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consultar_clientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de clientes registrados</h1>"
                    + "<a href='index.html' >Regresar al menu</a>");
            
            //Lista de Clientes Registrados
            List<Cliente> lista = Acciones_cliente.getAllClientes();
            
            out.println("<table border = '1'>"
                    + "<tr>"
                    + "<th>ID</th>"
                    + "<th>Nombre</th>"
                    + "<th>Apellido</th>"
                    + "<th>Telefono</th>"
                    + "<th>Email</th>"
                    + "<th>Lugar</th>"
                    + "</tr>");
            //necesito obtener la consulta y rellenar la tabla
            for(Cliente a : lista){
                
                 out.println("<tr>"
                        
                        + "<td>"+a.getId()+"</td>"
                        + "<td>"+a.getNombre()+"</td>"
                        + "<td>"+a.getApellido()+"</td>"
                        + "<td>"+a.getTelefono()+"</td>"
                                + "<td>"+a.getEmail()+"</td>"
                        + "<td>"+a.getLugar()+"</td>"
                        
                        + "<td><a href='Editar_cliente?id="+a.getId()+"'>Editar Datos</a></td>"
                        + "<td><a href='Eliminar_cliente?id="+a.getId()+"'>Eliminar</a></td>"
                        + "</tr>");
                
                
                
            }
                out.println("</table>");
            
            
            
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
