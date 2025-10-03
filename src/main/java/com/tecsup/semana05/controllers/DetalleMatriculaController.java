package com.tecsup.semana05.controllers;

import com.tecsup.semana05.model.entities.DetalleMatricula;
import com.tecsup.semana05.services.DetalleMatriculaService;
import com.tecsup.semana05.services.impl.DetalleMatriculaServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DetalleMatriculaController", urlPatterns = {"/dController", "/sDetalle", "/detalleController"})
public class DetalleMatriculaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DetalleMatricula detalle = new DetalleMatricula();
        detalle.setCodigo(request.getParameter("txtCodigo"));
        detalle.setCodigoMatricula(request.getParameter("txtCodigoMatricula"));
        detalle.setCodigoCurso(request.getParameter("txtCodigoCurso"));
        detalle.setEstado(request.getParameter("txtEstado"));

        System.out.println(detalle);
        DetalleMatriculaService servicio = new DetalleMatriculaServiceImpl();

        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar": servicio.registrar(detalle); break;
            case "actualizar": servicio.actualizar(detalle); break;
            case "eliminar": servicio.eliminar(detalle.getCodigo()); break;
        }
        response.sendRedirect("detalleMan.jsp");
    }
}
