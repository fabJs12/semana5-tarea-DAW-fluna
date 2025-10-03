<%@ page import="com.tecsup.semana05.model.entities.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador")==null){
        response.sendRedirect("error.jsp");
    } else {
        Administrador adm = (Administrador)misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Nuevo Periodo</title>
</head>
<body>
<jsp:include page="master.jsp" />
<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-4 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">CREAR PERIODO</h3>
                </div>
                <div class="card-body">
                    <form action="pController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código:</label>
                            <input type="text" class="form-control" name="txtCodigo" id="nomcli" placeholder="Código" autofocus required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Nombre:</label>
                            <input type="text" class="form-control" name="txtNombre" id="apecli" placeholder="Nombres" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Fecha Inicio:</label>
                            <input type="date" class="form-control" name="txtFechaInicio" id="nrodnicli" placeholder="Creditos" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text">Fecha Fin:</label>
                            <input type="date" class="form-control" name="txtFechaFin" id="nrodnicli" placeholder="Creditos" required>
                        </div>
                        <div class="input-group mt-2">
                            <label class="input-group-text estado-label">Estado:</label>
                            <div class="form-control radio-group">
                                <div class="radio-option">
                                    <input type="radio" id="estadoActivo" name="txtEstado" value="A" checked>
                                    <label for="estadoActivo">Activo</label>
                                </div>
                                <div class="radio-option">
                                    <input type="radio" id="estadoInactivo" name="txtEstado" value="I">
                                    <label for="estadoInactivo">Inactivo</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="insertar"/><br/>
                            <input class="btn btn-success" type="submit" value="Insertar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<% } %>
</body>
</html>

