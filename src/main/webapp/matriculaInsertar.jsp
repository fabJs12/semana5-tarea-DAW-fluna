<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05.services.PeriodoAcademicoService" %>
<%@ page import="com.tecsup.semana05.services.impl.PeriodoAcademicoServiceImpl" %>
<%@ page import="com.tecsup.semana05.model.entities.PeriodoAcademico" %>
<%@ page import="java.util.List" %>
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
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Matrícula Nueva - <%=nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">NUEVA MATRÍCULA</h3>
                </div>
                <div class="card-body">
                    <form action="matriculaController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Matrícula:</label>
                            <input type="text" class="form-control" name="txtCodigo" placeholder="Ej: M0001" autofocus required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Alumno:</label>
                            <input type="text" class="form-control" name="txtCodigoAlumno" placeholder="Ej: 960018K" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Período:</label>
                            <select class="form-control" name="txtCodigoPeriodo" required>
                                <option value="">Seleccione un período...</option>
                                <%
                                    PeriodoAcademicoService periodoService = new PeriodoAcademicoServiceImpl();
                                    List<PeriodoAcademico> periodos = periodoService.listarActivos();
                                    for (PeriodoAcademico p : periodos) {
                                %>
                                <option value="<%= p.getCodigo() %>"><%= p.getNombre() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Fecha Matrícula:</label>
                            <input type="date" class="form-control" name="txtFecha" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Estado:</label>
                            <select class="form-control" name="txtEstado" required>
                                <option value="A" selected>Activo</option>
                                <option value="R">Retirado</option>
                            </select>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="insertar"/><br/>
                            <input class="btn btn-primary" type="submit" value="Registrar">
                            <a href="matriculaMan.jsp" class="btn btn-secondary">Cancelar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    document.querySelector('input[name="txtFecha"]').valueAsDate = new Date();
</script>
</body>
<% } %>
</html>