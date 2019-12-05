/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidad.cedulaCandidato;
import Models.modeloCandidato;
import Models.modeloVoto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bryan
 */
@WebServlet(name = "listaRegistroCandidatos", urlPatterns = {"/listaRegistroCandidatos"})
public class listaRegistroCandidatos extends HttpServlet {
    modeloCandidato candidatos = new modeloCandidato();
    modeloVoto voto = new modeloVoto();
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
        String accion = request.getParameter("accion");
        System.out.println( "!!!!!!!!!1"+request.getParameter("txtdnivotante"));
        System.out.println("operacion"+accion);
        switch(accion){
            case "listarPersonas":
                    List<cedulaCandidato> data=null;
                    data=candidatos.listarCedula();
                    request.setAttribute("personadni", request.getParameter("id"));
                    request.setAttribute("listaCandidatosVoto", data);
                    request.getRequestDispatcher("/registroVoto.jsp").forward(request, response);
                break;
            case "registrar":
                String dniElector = request.getParameter("txtdnivotante");
                String dniCandidato = request.getParameter("txtdnicandidato");
                String tipoCandidato = request.getParameter("tipocandidato");
                System.out.println("dni del elctor="+dniElector+"- dni del candidato"+dniCandidato+"--"+tipoCandidato);
                cedulaCandidato obj =new cedulaCandidato();
                obj.setDniVotante(dniElector);
                obj.setDniCandidato(dniCandidato);
                obj.setTipo_candidato(tipoCandidato);
                int respuesta = voto.insertarVoto(obj);
                if(respuesta==1){
                    //response.sendRedirect("index.jsp");
                    String greetings = "Usuario Ingresado";
                    response.setContentType("text/plain");
                    response.getWriter().write(greetings);
                }
                else if(respuesta==2){
                    String greetings = "Dni ya ingresado ingrese otro DNI o editar uno existente";
                    response.setContentType("text/plain");
                    response.getWriter().write(greetings);
                }
                
                break;
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
