<%-- 
    Document   : editarPersona
    Created on : 25/11/2019, 07:05:28 PM
    Author     : Bryan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Persona"%>
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
        <form>
            <div class="card">
            <div class="card-body">
                
                <div class="form-group">
                    <label>DNI</label>
                    <input id="personaDni" type="text" name="txtdni" class="form-control" value="${personabuscada.getDni()}">
                </div>
                <div class="form-group">
                    <label>Nombres</label>
                    <input id="personaNombre" type="text" name="txtnombre" class="form-control" value="${personabuscada.getNombre()}">
                </div>
                <div class="form-group">
                    <label>Apellidos</label>
                    <input id="personaApellidos" type="text" name="txtapellido" class="form-control" value="${personabuscada.getApellidos()}">
                </div>
                <div class="form-group">
                    <label>Ubigeo</label>
                    <input id="personaUbigeo" type="text" name="txtubigeo" class="form-control" value="${personabuscada.getUbigeo()}">
                </div>
                <div class="form-group">
                    <label>Direccion</label>
                    <input id="personaDireccion" type="text" name="txtdireccion" class="form-control" value="${personabuscada.getDirecciones()}">
                </div>
                <div class="form-group">
                    <label>Sexo</label>
                    <input id="personaSexo" type="text" name="txtsexo" class="form-control" value="${personabuscada.getSexo()}">
                </div>
                <div class="form-group">
                    <label>Estado Civil</label>
                    <input id="personaEstadoCivil" type="text" name="txtestadocivil" class="form-control" value="${personabuscada.getEstadocivil()}">
                </div>
                <div class="form-group">
                    <label>Foto</label>
                    <input id="personaFoto" type="text" name="txtfoto" class="form-control" value="${personabuscada.getFoto()}">
                </div>
                <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type='button' id="myButton1" class="btn btn-primary btn-lg" >Submit</button>
                            </div>
               </div>
            </div>
        </div>
            
            
            
        </form>
        <div>
            <div class="container">
        <h2 class="grilla_titulo col-md-12 text-center"> Listado de Cursos</h2>
         <a href="index.html" class="nav-link TextoIzquierda">Inicio</a>   
        <div class="row">
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                    <form action="editarPersonas?buscado=nombre&accion=buscar" name="frmSesion" method="post">
                        <label class="loginLabel" name="donde" value="nombre">Buscar Persona por Nombre</label>
                        <br>
                        <input type="text" name="variable" class="form-control " style="width:70%" id="search" placeholder="Buscar">
                        <br>
                        <input class="btn btn-info" type="submit" value="buscar">
                    </form>
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                    <form action="editarPersonas?buscado=dni&accion=buscar" name="frmSesion" method="post">
                        <label class="loginLabel">Buscar Persona por Dni</label>
                        <br>
                        <input type="text" name="variable" class="form-control " style="width:70%" id="search" placeholder="Buscar">
                        <br>
                        <input class="btn btn-info" type="submit" value="buscar">
                    </form>
                </div>
              </div>
            </div>
        </div>
        <div class=""col-md-12>
         <table class="table table-bordered text-center" id="mytable">
	<thead>
	  <tr class="grilla_cabecera">
	  		<th>DNI</th><th>Nombre</th><th>Apellido</th><th>Ubigeo</th><th>Direccion</th><th>Sexo</th><th>Estado Civil</th><th>Editar</th><th>Eliminar</th>
	  </tr>
         </thead>
	  <!-- 
	  		Scriplet: son inserciones de codigo java dentro un JSP    < % %>
	  		Expression: son resultados de codigo java que se va visualizar en el JSP < %=   %>  
                -->
        <tbody>
        <%
              List<Persona> a =(ArrayList<Persona>)request.getAttribute("listaPersonas");   
              if(a != null){
                      for(Persona aux :a){
        %>
                      <tr class="grilla_campo"> 
                             <td><%= aux.getDni() %></td>
                             <td><%= aux.getNombre()  %></td>
                             <td><%= aux.getApellidos()%></td>
                            <td><%= aux.getUbigeo()%></td>
                            <td><%= aux.getDirecciones()%></td>
                            <td><%= aux.getSexo()%></td>
                            <td><%= aux.getEstadocivil()%></td>
                            
                       
                            <td><a href="editarPersonas?accion=editar&id=<%=aux.getDni()%>">Editar<span class="glyphicon glyphicon-pencil"></span></a></td>
                            <td><a href="CursoServlet?metodo=borrar&id=<%=aux.getDni()%>">Eliminar<span class="glyphicon glyphicon-remove-sign"></span></a></td>
                       
                       </tr>

                <% }} %>
          </tbody>
          </table>
        </div>
  </div>
        </div>
          
          <script src="jquery-3.4.1.min.js"></script>
            <script>
            $('#myButton1').click(function() { 
                $.ajax({
                        url : 'editarPersonas?accion=agregar',
                        data : {
                                param1 : $('#personaDni').val(),
                                param2 : $('#personaNombre').val(),
                                param3 : $('#personaApellidos').val(),
                                param4 : $('#personaUbigeo').val(),
                                param5 : $('#personaDireccion').val(),
                                param6 : $('#personaSexo').val(),
                                param7 : $('#personaEstadoCivil').val(),
                                param8 : $('#personaFoto').val()
                        },
                        success : function(responseText) {
                                $('#ajaxUserServletResponse').text(responseText);
                                
                        }
                });
            });
            </script>
    </body>
</html>
