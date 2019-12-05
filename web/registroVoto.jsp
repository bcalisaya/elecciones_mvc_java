<%-- 
    Document   : listarPartido
    Created on : 27/11/2019, 10:20:41 AM
    Author     : Bryan
--%>

<%@page import="Entidad.cedulaCandidato"%>
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
        
        <h1 class="grilla_titulo col-md-12 text-center">Lista de Candidatos de </h1>
        

            
        <table class="table table-hover">
	<thead>
	  <tr class="grilla_cabecera">
	  		<th>Nombre Candidato</th><th>Apellido Candidato</th><th>Partido</th><th>Tipo</th><th>Logo</th>
	  </tr>
         </thead>
         <tbody>
        <%
          
              List<cedulaCandidato> a =(List<cedulaCandidato>)request.getAttribute("listaCandidatosVoto");   
              if(a != null){
                      int contador = 0;
                      for(cedulaCandidato aux :a){
        %>        
                      <tr class="grilla_campo">
                            
                            <td><%= aux.getNombres() %></td>
                            <td><%= aux.getApellidos()%></td>
                            <td><%= aux.getNombre_partido()%></td>
                            <td><%= aux.getTipo_candidato()%></td>
                            <td><input id="para1<%= contador%>" type="hidden" value="${personadni}" >
                                <input id="para2<%= contador%>" type="hidden" value="<%= aux.getDniCandidato()%>" >
                                <input id="accion<%= contador%>" type="hidden" value="registrar">
                                <input id="para4<%= contador%>" type="hidden" value="<%= aux.getNombre_partido()%>">
                                <input id="para5<%= contador%>" type="hidden" value="<%= aux.getTipo_candidato()%>">
                                <button type='button' onClick="haVotado(<%= "'"+contador+"'"%>)" id="myButton1" href=""><img  style="width:90px;" src="<%= aux.getFoto()%>"></button>
                            </td>
                       </tr>
                       
                                
                <% 
                      contador++;}  
                    } %>
                
          </tbody>
        </table>
               
    <script src="jquery-3.4.1.min.js"></script>
        
            <script>
            function haVotado(num) {
                
                $.ajax({
                        url : 'listaRegistroCandidatos',
                        data : {
                                txtdnivotante : $('#para1'+num).val(),
                                txtdnicandidato : $('#para2'+num).val(),
                                accion : $('#accion'+num).val(),
                                param4 : $('#para4'+num).val(),
                                tipocandidato : $('#para5'+num).val()
                        },
                        success : function(responseText) {
                                alert(responseText);
                        }   
                });
            }
            
            </script>            

    </body>
</html>
