package com.tecsup.semana05.controllers;

import com.tecsup.semana05.model.entities.PeriodoAcademico;
import com.tecsup.semana05.services.PeriodoAcademicoService;
import com.tecsup.semana05.services.impl.PeriodoAcademicoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PeriodoAcademicoController", urlPatterns = {"/pController", "/sPeriodo", "/periodoController"})
public class PeriodoAcademicoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PeriodoAcademico periodo = new PeriodoAcademico();
            periodo.setCodigo(request.getParameter("txtCodigo"));
            periodo.setNombre(request.getParameter("txtNombre"));

            String fechaInicioStr = request.getParameter("txtFechaInicio");
            String fechaFinStr = request.getParameter("txtFechaFin");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaInicioStr != null && !fechaInicioStr.isEmpty()) {
                Date fechaInicio = sdf.parse(fechaInicioStr);
                periodo.setFechaInicio(fechaInicio);
            }
            if (fechaFinStr != null && !fechaFinStr.isEmpty()) {
                Date fechaFin = sdf.parse(fechaFinStr);
                periodo.setFechaFin(fechaFin);
            }

            periodo.setEstado(request.getParameter("txtEstado"));

            System.out.println(periodo);
            PeriodoAcademicoService servicio = new PeriodoAcademicoServiceImpl();

            String accion = request.getParameter("accion");
            switch (accion) {
                case "insertar": servicio.registrar(periodo); break;
                case "actualizar": servicio.actualizar(periodo); break;
                case "eliminar": servicio.eliminar(periodo.getCodigo()); break;
            }
            response.sendRedirect("periodoMan.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("periodoMan.jsp");
        }
    }
}
