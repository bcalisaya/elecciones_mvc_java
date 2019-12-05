/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidad.Persona;
import Models.modeloPersona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "editarPersonas", urlPatterns = {"/editarPersonas"})
public class editarPersonas extends HttpServlet {

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
        
        String buscado = request.getParameter("buscado");
        String accion = request.getParameter("accion");
        String variable = request.getParameter("variable");
        modeloPersona persona= new modeloPersona();
        List<Persona> data= new ArrayList<Persona>();
        System.out.println("estamos en servlet editar personas aqui salen personas"+accion+"--"+buscado);
            switch(accion){
                case "buscar":
                    System.out.println("llego al buscado !!!!!!!!!!!!");
                        switch(buscado){
                            case "nombre":
                                data=persona.listarPersonaNombre(variable);
                            break;
                            case "dni":
                                data=persona.listarPersonaDni(variable);
                            break;
                        } 
                        request.setAttribute("listaPersonas", data);
                        request.getRequestDispatcher("/editarPersona.jsp").forward(request, response);
                    break;
                case "editar":
                    String dnip = request.getParameter("id");
                    Persona person=persona.buscarPersona(dnip);
                    System.out.println("llego a editar persona "+person.getDni());
                    System.out.println("llego a editar persona "+person.getNombre());
                    request.setAttribute("personabuscada", person);
                    request.getRequestDispatcher("/editarPersona.jsp").forward(request, response);
                    break;
                case "agregar":
                    String dni = request.getParameter("param1").trim();
                    String nombre = request.getParameter("param2").trim();
                    String apellido = request.getParameter("param3").trim();
                    String ubigeo = request.getParameter("param4").trim();
                    String direcciones = request.getParameter("param5").trim();
                    String sexo = request.getParameter("param6").trim();
                    String estadocivil = request.getParameter("param7").trim();
                    String foto = request.getParameter("param8").trim();
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
                    al.actualizar(a);
                    request.getRequestDispatcher("/editarPersona.jsp").forward(request, response);
                    break;
                    
                case "delete":
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
