package com.tecsup.semana05.model.daos;

import com.tecsup.semana05.model.entities.PeriodoAcademico;

import java.util.List;

public interface PeriodoAcademicoDao extends EntidadDao<PeriodoAcademico, String> {
    List<PeriodoAcademico> findByEstado(String estado);
}
