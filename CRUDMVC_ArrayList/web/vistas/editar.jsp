<%@page import="DAO.arrayList.AlumnoDAO"%>
<%@page import="modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Actualizar</title>
    </head>
    <body>
        <% 
            AlumnoDAO dao = new AlumnoDAO();
            int id = Integer.parseInt((String) request.getAttribute("id_alumno"));
            Alumno a = (Alumno) dao.buscar(id);
        %>
        <h1>Actualizar Alumno</h1>
        <form action="Controlador">
            Nombre Alumno:<br>
            <input type="text" name="txtNombre" value="<%= a.getNombre()%>"><br>
            <input type="text" name="txtApellido" value="<%= a.getApellidos()%>"><br>
            <input type="hidden" name="txtId" value="<%= a.getId()%>">
            <input type="submit" name="accion" value="actualizar">
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
    </body>
</html>
