<%-- 
    Document   : registroCandidato
    Created on : 21/11/2019, 10:09:27 AM
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
        <h2 class="text-center header">Registro de Candidatos Politicos</h2>
                    <form>
                    <fieldset>
                        <legend class="text-center header">Ingrese los datos</legend>
                        <div class="form-group">
                    <div class="col-md-8">
                        <input id="candidatoDni" name="txtDni" type="text" placeholder="DNI del Candidato" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="candidatoTipoCandidato" name="txtTipoCandidato" type="text" placeholder="Tipo Candidato" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="candidatoFoto" name="txtFoto" type="text" placeholder="URL Foto del Candidato" class="form-control">
                    </div>
                 </div>
                <div class="form-group">
                    <div class="col-md-8">
                        <input id="candidatoNombrePartido" name="txtNombrePartido" type="text" placeholder="Nombre del Partido" class="form-control">
                    </div>
                 </div>
                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type='button' id="myButton3" class="btn btn-primary btn-lg" >Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
        <script src="jquery-3.4.1.min.js"></script>
        <script>
        
        $('#myButton3').click(function() { 
                $.ajax({
                        url : 'registroCandidatos',
                        data : {
                                param1 : $('#candidatoDni').val(),
                                param2 : $('#candidatoTipoCandidato').val(),
                                param3 : $('#candidatoFoto').val(),
                                param4 : $('#candidatoNombrePartido').val()
                        },
                        success : function(responseText) {
                                $('#ajaxUserServletResponse').text(responseText);
                        }
                });                
            });
        </script>
        
    </body>
</html>
