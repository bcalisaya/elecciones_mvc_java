<%-- 
    Document   : listarMesa
    Created on : 28/11/2019, 01:41:29 AM
    Author     : Bryan
--%>

<%@page import="java.util.List"%>
<%@page import="Entidad.Mesa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/js/bootstrap.min.js" integrity="sha384-3qaqj0lc6sV/qpzrc1N5DC6i1VRn/HyX4qdPaiEFbn54VjQBEU341pvjz7Dv3n6P" crossorigin="anonymous"></script>
    </head>
    <body>
        <table class="table">
	<thead>
	  <tr class="grilla_cabecera">
	  		<th scope="col">Id Mesa</th>
	  		<th scope="col">Colegio</th>
                        <th scope="col">Numero Mesa</th>
                        <th scope="col">Numero Salon</th>
	  </tr>
         </thead>
	  <!-- 
	  		Scriplet: son inserciones de codigo java dentro un JSP    < % %>
	  		Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>  
                -->
        <tbody>
        <%
              List<Mesa> a =(List<Mesa>)request.getAttribute("listaMesas");   
              if(a != null){
                      for(Mesa aux :a){
        %>
       
                      <tr class="grilla_campo"> 
                             <td ><%= aux.getId_mesa() %></td>
                             <td><%= aux.getColegio()  %></td>
                             <td><%= aux.getNumero_salon()%></td>
                            <td><%= aux.getNumero_mesa()%></td>
                       </tr>

                <% }} %>
          </tbody>
          </table>

    </body>
</html>
