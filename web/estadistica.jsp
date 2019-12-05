<%-- 
    Document   : estadistica.jsp
    Created on : 29/11/2019, 12:17:23 PM
    Author     : Bryan
--%>

<%@page import="Entidad.Resultado"%>
<%@page import="java.util.List"%>
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
            
<div class="container">
        <h2 class="grilla_titulo col-md-12 text-center">Lista de Resultados</h2>
        <div class=""col-md-12>
        <table class="table">
	<thead>
	  <tr class="grilla_cabecera">
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Logo</th>
                        <th scope="col">Cantidad de Votos</th>
	  </tr>
         </thead>
	  <!-- 
	  		Scriplet: son inserciones de codigo java dentro un JSP    < % %>
	  		Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>  
                -->
        <tbody>
        <%
              List<Resultado> a =(List<Resultado>)request.getAttribute("listaResultados");   
              if(a != null){
                      for(Resultado aux :a){
        %>
                      <tr class="grilla_campo"> 
                             <td><%= aux.getNombre()  %></td>
                             <td><%= aux.getApellido()%></td>
                            <td><img  style="width:90px;" src="<%= aux.getLogo()%>"></td>
                            <td><%= aux.getCantidad()%></td>
                          
                       </tr>

                <% }} %>
          </tbody>
          </table>
        </div>
  </div>


    </body>
</html>
