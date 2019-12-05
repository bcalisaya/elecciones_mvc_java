<%-- 
    Document   : registroPersona
    Created on : 21/11/2019, 10:05:07 AM
    Author     : Bryan
--%>

<%@page import="Entidad.Ubicacion"%>
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
        
        <h1 class="text-center header">registro personas</h1>
        <form><!--class="form-horizontal" method="post" action="Controlador?menu=Empleado&accion=Agregar"-->
                    <fieldset>
                        <legend class="text-center header">Ingrese los datos</legend>

                        <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaDni" name="txtDni" type="text" placeholder="DNI" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaNombre" name="txtNombre" type="text" placeholder="Nombres" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaApellidos" name="txtApellidos" type="text" placeholder="Apellidos" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    
                    
                    <div class="col-md-8">
                    <select id="iddepartamentos">
                        <%
                        List<Ubicacion> a =(List<Ubicacion>)request.getAttribute("departamentos");   
                        if(a != null){
                                for(Ubicacion aux :a){
                        %>
                            <option value="<%= aux.getIdDepartamento() %>"><%= aux.getDepartamento() %></option>
                        <% }} %>
                    </select>
                    <div class="col-md-8">
                        
                    <select>
                        <option  id="respuesta"></option>
                    </select>
                    
                    
                        <input id="personaUbigeo" name="txtUbigeo" type="text" placeholder="Ubigeo" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaDireccion" name="txtDireccion" type="text" placeholder="Direccion" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaSexo" name="txtSexo" type="text" placeholder="Sexo" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaEstadoCivil" name="txtEstadoCivil" type="text" placeholder="Estado Civil" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaFoto" name="txtFoto" type="text" placeholder="Foto" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaTipo" name="txttipo" type="text" placeholder="tipo de usuario" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="personaMesa" name="txtmesa" type="text" placeholder="id_mesa" class="form-control">
                    </div>
                 </div>
                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type='button' id="myButton1" class="btn btn-primary btn-lg" >Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
        
        <script src="jquery-3.4.1.min.js"></script>
        
            <script>
            $('#myButton1').click(function() {
                
                $.ajax({
                        url : 'registroPersonas',
                        data : {
                                param1 : $('#personaDni').val(),
                                param2 : $('#personaNombre').val(),
                                param3 : $('#personaApellidos').val(),
                                param4 : $('#personaUbigeo').val(),
                                param5 : $('#personaDireccion').val(),
                                param6 : $('#personaSexo').val(),
                                param7 : $('#personaEstadoCivil').val(),
                                param8 : $('#personaFoto').val(),
                                param9 : $('#personaTipo').val(),
                                param10 : $('#personaMesa').val()
                        },
                        success : function(responseText) {
                                alert(responseText);
                        }
                
                        });
            });
            </script>
            <script>
                $(document).ready(function() {
                    var myElement = $("#iddepartamentos");
                    var myText = myElement.text();
                    $("#respuesta").text(myText); 
                });
            </script>
            
            
        
    </body>
</html>
