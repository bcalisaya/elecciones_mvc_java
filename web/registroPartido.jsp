<%-- 
    Document   : registroPartido
    Created on : 21/11/2019, 10:10:28 AM
    Author     : Bryan
--%>

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
        <h2 class="text-center header">Registro de Partidos Politicos</h2>
                <form> <!-- class="form-horizontal" method="POST" action="registroPartidos" enctype="multipart/form-data">-->
                    <fieldset>
                        <legend class="text-center header">Ingrese los datos</legend>

                        <div class="form-group">
                    <div class="col-md-8">
                        <input id="nombrePartido" name="param1" type="text" placeholder="Nombre del Partido" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="fotoPartido" name="param2" type="text" placeholder="URL del Logo" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="descripcionPartido" name="param3" type="text" placeholder="Descripcion del Partido" class="form-control">
                    </div>
                 </div>
                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button id="myButton2" type="button" class="btn btn-primary btn-lg" >Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
        <script src="jquery-3.4.1.min.js"></script>
        <script>
            $('#myButton2').click(function() { 
                $.ajax({
                        url : 'registroPartidos',
                        data : {
                                param1 : $('#nombrePartido').val(),
                                param2 : $('#fotoPartido').val(),
                                param3 : $('#descripcionPartido').val(),
                        },
                        success : function(responseText) {
                                $('#ajaxUserServletResponse').text(responseText);
                        }
                });
        });
        
        </script>
        
    </body>
</html>
