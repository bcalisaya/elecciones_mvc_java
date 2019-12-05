/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidad.Ubicacion;
import Models.modeloUbicacion;
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
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

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
            String menu=request.getParameter("menu");
            switch (menu){
                case "Principal":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                case "Registropersona":
                    modeloUbicacion mod = new modeloUbicacion();
                    List<Ubicacion> data=null;
                    data=mod.listarDepartamento();
                    request.setAttribute("departamentos", data);
                request.getRequestDispatcher("registroPersona.jsp").forward(request, response);
                break;
                case "Registropartido":
                request.getRequestDispatcher("registroPartido.jsp").forward(request, response);
                break;
                case "Registrocandidato":
                request.getRequestDispatcher("registroCandidato.jsp").forward(request, response);
                break;
                case "Registroloca":
                request.getRequestDispatcher("registroLocal.jsp").forward(request, response);
                break;
                case "Registromesa":
                request.getRequestDispatcher("registroMesa.jsp").forward(request, response);
                break;
                case "Listaregistrocandidatos":
                request.getRequestDispatcher("listaRegistroCandidatos").forward(request, response);
                break;
                case "Listarpersona":
                request.getRequestDispatcher("listarPersonas").forward(request, response);
                break;
                case "Listarmesa":
                request.getRequestDispatcher("listarMesas").forward(request, response);
                break;
                case "Listarpartido":
                request.getRequestDispatcher("listarPartidos").forward(request, response);
                break;
                case "Listarresultados":
                request.getRequestDispatcher("resultadoElecciones").forward(request, response);
                break;
                default:
                request.getRequestDispatcher("404.html").forward(request, response);

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
