<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05.model.entities.PeriodoAcademico" %>
<%@ page import="com.tecsup.semana05.services.PeriodoAcademicoService" %>
<%@ page import="com.tecsup.semana05.services.impl.PeriodoAcademicoServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador")==null) {
        response.sendRedirect("error.jsp");
    } else {
        Administrador adm = (Administrador)misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
        String sid = request.getParameter("id");
        PeriodoAcademicoService servicio = new PeriodoAcademicoServiceImpl();
        PeriodoAcademico periodo = servicio.buscar(sid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Periodo Actualizar - <%=nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">ACTUALIZAR PERÍODO ACADÉMICO</h3>
                </div>
                <div class="card-body">
                    <form action="pController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código:</label>
                            <input type="text" class="form-control" name="txtCodigo" placeholder="Código" value="<%=periodo.getCodigo()%>" readonly>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Nombre:</label>
                            <input type="text" class="form-control" name="txtNombre" placeholder="Nombre del Período" value="<%=periodo.getNombre()%>" autofocus required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Fecha Inicio:</label>
                            <input type="date" class="form-control" name="txtFechaInicio" value="<%=sdf.format(periodo.getFechaInicio())%>" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Fecha Fin:</label>
                            <input type="date" class="form-control" name="txtFechaFin" value="<%=sdf.format(periodo.getFechaFin())%>" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Estado:</label>
                            <select class="form-control" name="txtEstado" required>
                                <option value="A" <%= periodo.getEstado().equals("A") ? "selected" : "" %>>Activo</option>
                                <option value="I" <%= periodo.getEstado().equals("I") ? "selected" : "" %>>Inactivo</option>
                            </select>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="actualizar"/><br/>
                            <input class="btn btn-success" type="submit" value="Actualizar">
                            <a href="periodoMan.jsp" class="btn btn-secondary">Cancelar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<% } %>
</html>
