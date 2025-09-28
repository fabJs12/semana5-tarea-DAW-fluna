<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05.model.entities.Curso" %>
<%@ page import="com.tecsup.semana05.services.CursoService" %>
<%@ page import="com.tecsup.semana05.services.impl.CursoServiceImpl" %>
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
        CursoService servicio = new CursoServiceImpl();
        Curso curso = servicio.buscar(sid);

%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Curso Actualizar - <%=nombre %></title>
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-4 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">ACTUALIZAR CURSO</h3>
                </div>
                <div class="card-body">
                    <form action="cController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código:</label>
                            <input type="text" class="form-control" name="txtCodigo" id="nomcli" placeholder="Código" value="<%=curso.getCodigo()%>" readonly>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Nombre:</label>
                            <input type="text" class="form-control" name="txtNombre" id="apecli" placeholder="Nombres" value="<%=curso.getNombre()%>" autofocus required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Creditos:</label>
                            <input type="text" class="form-control" name="txtCreditos" id="nrodnicli" placeholder="Creditos" value="<%=curso.getCreditos()%>" required>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="actualizar"/><br/>
                            <input class="btn btn-success" type="submit" value="Actualizar">
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
