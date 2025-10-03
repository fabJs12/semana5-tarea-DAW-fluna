<%@ page import="com.tecsup.semana05.model.entities.DetalleMatricula" %>
<%@ page import="com.tecsup.semana05.services.DetalleMatriculaService" %>
<%@ page import="com.tecsup.semana05.services.impl.DetalleMatriculaServiceImpl" %>
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
        DetalleMatriculaService servicio = new DetalleMatriculaServiceImpl();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Detalles de Matrícula</title></head>
<body>
<jsp:include page="master.jsp" />
<div class="container mt-5">
    <h1>Mantenimiento de Detalles de Matrícula</h1>
    <div style="padding: 10px;">
        <a class="btn btn-success" href="detalleInsertar.jsp">Nuevo Detalle</a>
    </div>

    <table class="table table-dark table-hover text-center">
        <tr>
            <th>CODIGO</th>
            <th>CODIGO MATRÍCULA</th>
            <th>ALUMNO</th>
            <th>CODIGO CURSO</th>
            <th>NOMBRE CURSO</th>
            <th>ESTADO</th>
            <th>ACCIONES</th>
        </tr>
        <% for (DetalleMatricula d : servicio.listar()) { %>
        <tr>
            <td><%=d.getCodigo()%></td>
            <td><%=d.getCodigoMatricula()%></td>
            <td><%=d.getNombreAlumno() + " " + d.getApellidoAlumno()%></td>
            <td><%=d.getCodigoCurso()%></td>
            <td><%=d.getNombreCurso()%></td>
            <td><%=d.getEstado()%></td>
            <td>
                <a class="btn btn-danger" href="dController?accion=eliminar&txtCodigo=<%=d.getCodigo()%>">Eliminar</a>
                <a class="btn btn-warning" href="detalleActualizar.jsp?id=<%=d.getCodigo()%>">Actualizar</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>
<% } %>
</body>
</html>

