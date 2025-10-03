package com.tecsup.semana05.services;

import com.tecsup.semana05.model.entities.PeriodoAcademico;

import java.util.List;

public interface PeriodoAcademicoService {
    void registrar(PeriodoAcademico periodoAcademico);
    void actualizar(PeriodoAcademico periodoAcademico);
    void eliminar(String id);
    PeriodoAcademico buscar(String id);
    List<PeriodoAcademico> listar();
    List<PeriodoAcademico> listarActivos();
}
