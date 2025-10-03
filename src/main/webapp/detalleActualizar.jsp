<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05.model.entities.DetalleMatricula" %>
<%@ page import="com.tecsup.semana05.services.DetalleMatriculaService" %>
<%@ page import="com.tecsup.semana05.services.impl.DetalleMatriculaServiceImpl" %>
<%@ page import="com.tecsup.semana05.services.CursoService" %>
<%@ page import="com.tecsup.semana05.services.impl.CursoServiceImpl" %>
<%@ page import="com.tecsup.semana05.model.entities.Curso" %>
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
        String sid = request.getParameter("id");
        DetalleMatriculaService servicio = new DetalleMatriculaServiceImpl();
        DetalleMatricula detalle = servicio.buscar(sid);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Actualizar Detalle Matrícula - <%=nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">ACTUALIZAR DETALLE DE MATRÍCULA</h3>
                </div>
                <div class="card-body">
                    <form action="dController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Detalle:</label>
                            <input type="text" class="form-control" name="txtCodigo" value="<%=detalle.getCodigo()%>" readonly>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Matrícula:</label>
                            <input type="text" class="form-control" name="txtCodigoMatricula" value="<%=detalle.getCodigoMatricula()%>" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Curso:</label>
                            <select class="form-control" name="txtCodigoCurso" required>
                                <option value="">Seleccione un curso...</option>
                                <%
                                    CursoService cursoService = new CursoServiceImpl();
                                    List<Curso> cursos = cursoService.listar();
                                    for (Curso c : cursos) {
                                        String selected = c.getCodigo().equals(detalle.getCodigoCurso()) ? "selected" : "";
                                %>
                                <option value="<%= c.getCodigo() %>" <%= selected %>><%= c.getNombre() %> (<%= c.getCreditos() %> créditos)</option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Estado:</label>
                            <select class="form-control" name="txtEstado" required>
                                <option value="M" <%= detalle.getEstado().equals("M") ? "selected" : "" %>>Matriculado</option>
                                <option value="R" <%= detalle.getEstado().equals("R") ? "selected" : "" %>>Retirado</option>
                            </select>
                        </div>
                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="actualizar"/><br/>
                            <input class="btn btn-success" type="submit" value="Actualizar">
                            <a href="detalleMan.jsp" class="btn btn-secondary">Cancelar</a>
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