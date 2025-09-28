package com.tecsup.semana05.model.daos;

import com.tecsup.semana05.model.entities.Curso;

import java.util.List;

public interface CursoDao extends EntidadDao<Curso, String> {
    public List<Curso> findByCreditos(int min, int max);
    public List<Curso> findByNombre(String nombre);
}
