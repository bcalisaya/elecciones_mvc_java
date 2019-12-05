/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidad.Persona;
import Models.modeloMesa;
import Models.modeloPersona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bryan
 */
@WebServlet(name = "registroPersonas", urlPatterns = {"/registroPersonas"})
public class registroPersonas extends HttpServlet {

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
                String dni = request.getParameter("param1").trim();
                String nombre = request.getParameter("param2").trim();
                String apellido = request.getParameter("param3").trim();
                String ubigeo = request.getParameter("param4").trim();
                String direcciones = request.getParameter("param5").trim();
                String sexo = request.getParameter("param6").trim();
                String estadocivil = request.getParameter("param7").trim();
                String foto = request.getParameter("param8").trim();
                String tipo = request.getParameter("param9").trim();
                String mesa = request.getParameter("param10").trim();
                System.out.println("PASO POR AQUI!!"+nombre+"+"+dni+" "+apellido);
                Persona a = new Persona();
                a.setDni(dni);
                a.setNombre(nombre);
                a.setApellidos(apellido);
                a.setUbigeo(ubigeo);
                a.setDirecciones(direcciones);
                a.setSexo(sexo);
                a.setEstadocivil(estadocivil);
                a.setFoto(foto);
                modeloPersona al = new modeloPersona();
                modeloMesa a2 = new modeloMesa();
                int respuesta=al.insertarPersona(a);
                int salida=a2.insertarAsignacionMesa(tipo,mesa);
                if(respuesta==1){
                    response.sendRedirect("index.jsp");
                    System.out.println("queda no es repetido");
                    String greetings = "Usuario Ingresado";
                    response.setContentType("text/plain");
                    response.getWriter().write(greetings);
                }
                else if(respuesta==2){
                    System.out.println("repetido");
                    String greetings = "Dni ya ingresado ingrese otro DNI o editar uno existente";
                    response.setContentType("text/plain");
                    response.getWriter().write(greetings);
                }else if(salida==1){
                    response.sendRedirect("index.jsp");
                    System.out.println("queda no es repetido");
                    String greetings = "mesa persona Ingresado";
                    response.setContentType("text/plain");
                    response.getWriter().write(greetings);
                }
                else if(salida==2){
                    System.out.println("repetido");
                    String greetings = "Ese codigo de Mesa no exite Busque e intente con otro";
                    response.setContentType("text/plain");
                    response.getWriter().write(greetings);
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
