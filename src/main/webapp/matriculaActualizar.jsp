<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05.model.entities.Matricula" %>
<%@ page import="com.tecsup.semana05.services.MatriculaService" %>
<%@ page import="com.tecsup.semana05.services.impl.MatriculaServiceImpl" %>
<%@ page import="com.tecsup.semana05.services.PeriodoAcademicoService" %>
<%@ page import="com.tecsup.semana05.services.impl.PeriodoAcademicoServiceImpl" %>
<%@ page import="com.tecsup.semana05.model.entities.PeriodoAcademico" %>
<%@ page import="java.util.List" %>
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
        MatriculaService servicio = new MatriculaServiceImpl();
        Matricula matricula = servicio.buscar(sid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Matrícula Actualizar - <%=nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">ACTUALIZAR MATRÍCULA</h3>
                </div>
                <div class="card-body">
                    <form action="matriculaController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Matrícula:</label>
                            <input type="text" class="form-control" name="txtCodigo" value="<%=matricula.getCodigo()%>" readonly>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Alumno:</label>
                            <input type="text" class="form-control" name="txtCodigoAlumno" value="<%=matricula.getCodigoAlumno()%>" autofocus required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Período:</label>
                            <select class="form-control" name="txtCodigoPeriodo" required>
                                <%
                                    PeriodoAcademicoService periodoService = new PeriodoAcademicoServiceImpl();
                                    List<PeriodoAcademico> periodos = periodoService.listar();
                                    for (PeriodoAcademico p : periodos) {
                                        String selected = p.getCodigo().equals(matricula.getCodigoPeriodo()) ? "selected" : "";
                                %>
                                <option value="<%= p.getCodigo() %>" <%= selected %>><%= p.getNombre() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Fecha Matrícula:</label>
                            <input type="date" class="form-control" name="txtFecha" value="<%=sdf.format(matricula.getFecha())%>" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Estado:</label>
                            <select class="form-control" name="txtEstado" required>
                                <option value="A" <%= matricula.getEstado().equals("A") ? "selected" : "" %>>Activo</option>
                                <option value="R" <%= matricula.getEstado().equals("R") ? "selected" : "" %>>Retirado</option>
                            </select>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="actualizar"/><br/>
                            <input class="btn btn-success" type="submit" value="Actualizar">
                            <a href="matriculaMan.jsp" class="btn btn-secondary">Cancelar</a>
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