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
public class Editar2 extends HttpServlet {

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
            String nom, ape, tel, ema, lug;
            
            
            id = Integer.parseInt(request.getParameter("id2"));
            
            nom = request.getParameter("nombre2");
            ape = request.getParameter("apellido2");
            tel = request.getParameter("telefono2");
            ema = request.getParameter("email2");
            lug = request.getParameter("lugar2");
            
            
            //Instancia e objeto
            
            Cliente a = new Cliente();
            
            //envia parametros
            
            a.setId(id);
            a.setNombre(nom);
            a.setApellido(ape);
            a.setTelefono(tel);
            a.setEmail(ema);
            a.setLugar(lug);
            
            int estatus = Acciones_cliente.Actualizar(a);
            
            if(estatus > 0){
                response.sendRedirect("Consultar_clientes");
            }else{
                out.println("<h1>Hubo un error al editar informacion</h1>"
                + "<a href='index.html'>Regresar almenu principal</a>");
            }
            
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
