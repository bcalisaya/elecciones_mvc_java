<%@page import="Entidad.Persona"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Personas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/js/bootstrap.min.js" integrity="sha384-3qaqj0lc6sV/qpzrc1N5DC6i1VRn/HyX4qdPaiEFbn54VjQBEU341pvjz7Dv3n6P" crossorigin="anonymous"></script>
</head>
<body>
    
<div class="container">
        <h2 class="grilla_titulo col-md-12 text-center"> Listado de Personas</h2>
         <a href="index.jsp" class="nav-link TextoIzquierda">Inicio</a>   
        
        <div class=""col-md-12>
        <table class="table">
	<thead>
	  <tr class="grilla_cabecera">
	  		<th scope="col">DNI</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Ubigeo</th>
                        <th scope="col">Direccion</th>
                        <th scope="col">Sexo</th>
                        <th scope="col">Estado Civil</th>
	  </tr>
         </thead>
	  <!-- 
	  		Scriplet: son inserciones de codigo java dentro un JSP    < % %>
	  		Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>  
                -->
        <tbody>
        <%
              List<Persona> a =(List<Persona>)request.getAttribute("listaPersonas");   
              if(a != null){
                      for(Persona aux :a){
        %>
                      <tr class="grilla_campo"> 
                             <td ><%= aux.getDni() %></td>
                             <td><%= aux.getNombre()  %></td>
                             <td><%= aux.getApellidos()%></td>
                            <td><%= aux.getUbigeo()%></td>
                            <td><%= aux.getDirecciones()%></td>
                            <td><%= aux.getSexo()%></td>
                            <td><%= aux.getEstadocivil()%></td>
                            
                       <!--
                            <td><a href="editarCurso?metodo=modificar&id=<%=aux.getDni()%>"><span class="glyphicon glyphicon-pencil"></span></a></td>
                            <td><a href="CursoServlet?metodo=borrar&id=<%=aux.getDni()%>"><span class="glyphicon glyphicon-remove-sign"></span></a></td>
                       -->
                       </tr>

                <% }} %>
          </tbody>
          </table>
        </div>
  </div>

</body>
</html> 