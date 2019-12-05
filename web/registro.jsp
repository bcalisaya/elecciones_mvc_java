<%-- 
    Document   : Empleado
    Created on : 15/08/2019, 12:52:00 PM
    Author     : Bryan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
        <div class="card col-sm-4">
        <div class="card-body">
            <form action="Controlador?menu=Empleado&accion=Agregar" method="POST">
                <div class="form-group">
                    <label>Dni</label>
                    <input type="text" name="txtDni" class="form-control">
                </div>
                <div class="form-group">
                    <label>Nombres</label>
                    <input type="text" name="txtNombre" class="form-control">
                </div>
                <div class="form-group">
                    <label>Telefonos</label>
                    <input type="text" name="txtTelefono" class="form-control">
                </div>
                <div class="form-group">
                    <label>Estados</label>
                    <input type="text" name="txtEstado" class="form-control">
                </div>
                <div class="form-group">
                    <label>Usuarios</label>
                    <input type="text" name="txtUsuario" class="form-control">
                </div>
                <input type="submit" name="accion" value="Agregar" class="btn btn-info">    
            </form>
        </div>
        </div>
        
        
        </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>