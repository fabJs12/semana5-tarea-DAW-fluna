<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
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
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Detalle Nuevo - <%=nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">NUEVO DETALLE DE MATRÍCULA</h3>
                </div>
                <div class="card-body">
                    <form action="detalleController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Detalle:</label>
                            <input type="text" class="form-control" name="txtCodigo" placeholder="Ej: D0001" autofocus required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Matrícula:</label>
                            <input type="text" class="form-control" name="txtCodigoMatricula" placeholder="Ej: M0001" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Curso:</label>
                            <select class="form-control" name="txtCodigoCurso" required>
                                <option value="">Seleccione un curso...</option>
                                <%
                                    CursoService cursoService = new CursoServiceImpl();
                                    List<Curso> cursos = cursoService.listar();
                                    for (Curso c : cursos) {
                                %>
                                <option value="<%= c.getCodigo() %>"><%= c.getNombre() %> (<%= c.getCreditos() %> créditos)</option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Estado:</label>
                            <select class="form-control" name="txtEstado" required>
                                <option value="M" selected>Matriculado</option>
                                <option value="R">Retirado</option>
                            </select>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="insertar"/><br/>
                            <input class="btn btn-primary" type="submit" value="Registrar">
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