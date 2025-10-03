package com.tecsup.semana05.services;

import com.tecsup.semana05.model.entities.Matricula;
import com.tecsup.semana05.model.entities.PeriodoAcademico;

import java.util.List;

public interface MatriculaService {
    void registrar(Matricula matricula);
    void actualizar(Matricula matricula);
    void eliminar(String id);
    Matricula buscar(String id);
    List<Matricula> listar();
    List<Matricula> listarPorAlumno(String codigoAlumno);
    List<Matricula> listarPorPeriodo(String codigoPeriodo);
}
