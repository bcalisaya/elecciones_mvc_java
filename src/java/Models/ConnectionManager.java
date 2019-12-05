/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Bryan
 */

import java.sql.*;
import java.util.*;

public class ConnectionManager {
    
    
    private static String url="jdbc:mysql://localhost/elecciones";
    private static String user="root";
    private static String password="";
    private static Connection conn;
    
    public static  Connection getConnection(){
            conn=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn= DriverManager.getConnection(url,user,password);
                System.out.println("Connected to the Mysql server successfully.");
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return conn;
    
    }
    /*
    public static void main(String[] args){
        
        getConnection();
    
    }*/
    
}

