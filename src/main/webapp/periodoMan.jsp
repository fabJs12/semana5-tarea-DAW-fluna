<%@ page import="com.tecsup.semana05.model.entities.PeriodoAcademico" %>
<%@ page import="com.tecsup.semana05.services.PeriodoAcademicoService" %>
<%@ page import="com.tecsup.semana05.services.impl.PeriodoAcademicoServiceImpl" %>
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
        PeriodoAcademicoService servicio = new PeriodoAcademicoServiceImpl();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Periodos Académicos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container mt-5">

    <h1>Mantenimiento de Periodos Académicos</h1>
    <div style="padding: 10px;">
        <a class="btn btn-success" href="periodoInsertar.jsp">Nuevo Periodo</a>
    </div>

    <table class="table table-dark table-hover text-center">
        <tr>
            <th>CODIGO</th>
            <th>NOMBRE</th>
            <th>FECHA INICIO</th>
            <th>FECHA FIN</th>
            <th>ESTADO</th>
            <th>ACCIONES</th>
        </tr>
        <% for (PeriodoAcademico p : servicio.listar()) { %>
        <tr>
            <td><%=p.getCodigo()%></td>
            <td><%=p.getNombre()%></td>
            <td><%=p.getFechaInicio()%></td>
            <td><%=p.getFechaFin()%></td>
            <td><%=p.getEstado()%></td>
            <td>
                <a class="btn btn-danger" href="pController?accion=eliminar&txtCodigo=<%=p.getCodigo()%>">Eliminar</a>
                <a class="btn btn-warning" href="periodoActualizar.jsp?id=<%=p.getCodigo()%>">Actualizar</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>
<% } %>
</body>
</html>