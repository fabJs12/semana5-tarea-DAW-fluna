package com.tecsup.semana05.services;

import com.tecsup.semana05.model.entities.DetalleMatricula;

import java.util.List;

public interface DetalleMatriculaService {
    void registrar(DetalleMatricula detalleMatricula);
    void actualizar(DetalleMatricula detalleMatricula);
    void eliminar(String id);
    DetalleMatricula buscar(String id);
    List<DetalleMatricula> listar();
    List<DetalleMatricula> listarPorCurso(String codigoCurso);
    List<DetalleMatricula> listarPorMatricula(String codigoMatricula);
}
