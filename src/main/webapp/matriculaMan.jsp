<%@ page import="com.tecsup.semana05.model.entities.Matricula" %>
<%@ page import="com.tecsup.semana05.services.MatriculaService" %>
<%@ page import="com.tecsup.semana05.services.impl.MatriculaServiceImpl" %>
<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if(misesion.getAttribute("eladministrador")==null){
        response.sendRedirect("error.jsp");
    }else{
        Administrador adm = (Administrador)misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
        MatriculaService servicio = new MatriculaServiceImpl();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Matrículas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container mt-5">
    <h1>Mantenimiento de Matrículas</h1>
    <div style="padding: 10px;">
        <a class="btn btn-success" href="matriculaInsertar.jsp">Nueva Matrícula</a>
    </div>

    <table class="table table-dark table-hover text-center">
        <tr>
            <th>CODIGO</th>
            <th>CODIGO ALUMNO</th>
            <th>NOMBRE</th>
            <th>CODIGO PERIODO</th>
            <th>NOMBRE PERIODO</th>
            <th>FECHA</th>
            <th>ESTADO</th>
            <th>ACCIONES</th>
        </tr>
        <% for (Matricula m : servicio.listar()) { %>
        <tr>
            <td><%=m.getCodigo()%></td>
            <td><%=m.getCodigoAlumno()%></td>
            <td><%= m.getNombreAlumno() + " " + m.getApellidoAlumno() %></td>
            <td><%=m.getCodigoPeriodo()%></td>
            <td><%=m.getNombrePeriodo()%></td>
            <td><%=m.getFecha()%></td>
            <td><%=m.getEstado()%></td>
            <td>
                <a class="btn btn-danger" href="mController?accion=eliminar&txtCodigo=<%=m.getCodigo()%>">Eliminar</a>
                <a class="btn btn-warning" href="matriculaActualizar.jsp?id=<%=m.getCodigo()%>">Actualizar</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>
<% } %>
</body>
</html>
