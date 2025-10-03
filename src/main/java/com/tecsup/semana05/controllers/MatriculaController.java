package com.tecsup.semana05.controllers;

import com.tecsup.semana05.model.entities.Matricula;
import com.tecsup.semana05.services.MatriculaService;
import com.tecsup.semana05.services.impl.MatriculaServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "MatriculaController", urlPatterns = {"/mController", "/sMatricula", "/matriculaController"})
public class MatriculaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Matricula matricula = new Matricula();
            matricula.setCodigo(request.getParameter("txtCodigo"));
            matricula.setCodigoAlumno(request.getParameter("txtCodigoAlumno"));
            matricula.setCodigoPeriodo(request.getParameter("txtCodigoPeriodo"));

            String fechaStr = request.getParameter("txtFecha");
            if (fechaStr != null && !fechaStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(fechaStr);
                matricula.setFecha(fecha);
            }

            matricula.setEstado(request.getParameter("txtEstado"));

            System.out.println(matricula);
            MatriculaService servicio = new MatriculaServiceImpl();

            String accion = request.getParameter("accion");
            switch (accion) {
                case "insertar": servicio.registrar(matricula); break;
                case "actualizar": servicio.actualizar(matricula); break;
                case "eliminar": servicio.eliminar(matricula.getCodigo()); break;
            }
            response.sendRedirect("matriculaMan.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("matriculaMan.jsp");
        }
    }
}
