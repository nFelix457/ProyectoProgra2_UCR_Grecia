<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar un nuevo Alumno</h1>
        <form action="Controlador">
            Nombre:<br>
            <input type="text" name="txtNombre"><br>
            Apellidos: <br>
            <input type="text" name="txtApellidos"><br>
            <input type="submit" name="accion" value="insertar">
            <a href="Controlador?accion=listar">Regresar a la Lista de Alunmos</a>
        </form>       
    </body>
</html>
