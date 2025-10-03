package com.tecsup.semana05.model.daos;

import com.tecsup.semana05.model.entities.DetalleMatricula;
import java.util.List;

public interface DetalleMatriculaDao extends EntidadDao<DetalleMatricula, String> {
    List<DetalleMatricula> findByCurso(String codigoCurso);
    List<DetalleMatricula> findByMatricula(String codigoMatricula);
}
