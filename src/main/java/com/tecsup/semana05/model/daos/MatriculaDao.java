package com.tecsup.semana05.model.daos;

import com.tecsup.semana05.model.entities.Alumno;
import com.tecsup.semana05.model.entities.Matricula;

import java.util.List;

public interface MatriculaDao extends EntidadDao<Matricula, String> {
    List<Matricula> findByAlumno(String codigoAlumno);
    List<Matricula> findByPeriodo(String codigoPeriodo);
}
