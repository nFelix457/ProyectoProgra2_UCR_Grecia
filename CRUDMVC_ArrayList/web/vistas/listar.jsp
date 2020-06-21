<%@page import="DAO.arrayList.AlumnoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
    </head>
    <body>
        <h1>Alumnos</h1>
        <a href="Controlador?accion=agregar">Agregar un Nuevo Alumno</a>
        <br>
        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                </tr>
            </thead>
            <%
               AlumnoDAO dao = new AlumnoDAO();
               List <Alumno> list = dao.listar();
               Iterator<Alumno> i = list.iterator();
               Alumno a = null;
               while (i.hasNext()){
                   a = i.next();
            %>
            <tbody>
                <tr>
                    <td><%=a.getId() %></td>
                    <td><%=a.getNombre() %></td>
                    <td><%=a.getApellidos() %></td>
                    <td>
                        <a href="Controlador?accion=editar&id=<%= a.getId()%>">Editar</a>
                        <a href="Controlador?accion=eliminar&id=<%= a.getId()%>">Eliminar</a>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
