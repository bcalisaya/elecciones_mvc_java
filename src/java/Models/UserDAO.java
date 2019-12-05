/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entidad.Persona;
import java.text.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Bryan
 */
public class UserDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;  


    public static Persona login(Persona persona) {

        //preparing some objects for connection 
        Statement stmt = null;    

        String nombre = persona.getNombre();    
        String dni = persona.getDni();    
        Persona personita =new Persona();
        
        //SELECT U.firstname, U.lastname, D.direccion FROM `use` U
        //INNER JOIN `DIRECCION`D  on U.id = D.id_user
        String searchQuery =
            "SELECT U.nombres, U.apellidos, U.dni FROM `persona` U "
                + " where dni='"
                    + dni
                    + "' and nombres='"
                    + nombre
                    + "'";
    //SELECT nombres,apellidos, dni FROM persona INNER JOIN administrador ON persona.id_persona = administrador.id_persona WHERE dni='72169324'
    //SELECT U.nombres, U.apellidos FROM `persona` U where dni= '72169324' AND nombres = 'bryan' 
    // "System.out.println" prints in the console; Normally used to trace the process
    //System.out.println("Your user name is " + username);          
    //System.out.println("Your password is " + password);
    System.out.println("Your user name is: "+nombre);
    System.out.println("Your password is: "+dni);
    System.out.println("Query: "+searchQuery);
    try 
    {
        //connect to DB 
        currentCon = ConnectionManager.getConnection();
        stmt=currentCon.createStatement();
        rs = stmt.executeQuery(searchQuery);
        System.out.println("---------------------------------------");
        boolean more =rs.next();
        if(!more){
            System.out.println("Sorry usted no esta registrado user! Please sign up first ;-;");
            personita.setValid(false);
        }
        else 
        {   
            String firstName =rs.getString("nombres");
            String lastName =rs.getString("apellidos");
            String Dni =rs.getString("dni");
            
            
            personita.setNombre(firstName);
            
            personita.setApellidos(lastName);
            personita.setDni(Dni);
            personita.setValid(true);
            System.out.println("Welcome "+ firstName+"----"+lastName+"---"+Dni);
        }
    } 
    catch (Exception ex) 
    {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
    } 
    //some exception handling
    finally 
    {
        if (rs != null)	{
        try {
            rs.close();
        } catch (Exception e) {}
            rs = null;
        }
        if (stmt != null) {
        try {
            stmt.close();
        } catch (Exception e) {}
            stmt = null;
        }
        if (currentCon != null) {
        try {
            currentCon.close();
        } catch (Exception e) {
        }
        currentCon = null;
        }
    }
    return personita;
    }
    
    
}