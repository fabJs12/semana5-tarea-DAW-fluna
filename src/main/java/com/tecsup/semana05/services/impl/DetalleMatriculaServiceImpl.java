package com.tecsup.semana05.services.impl;

import com.tecsup.semana05.model.daos.DetalleMatriculaDao;
import com.tecsup.semana05.model.daos.impl.DaoFactory;
import com.tecsup.semana05.model.entities.DetalleMatricula;
import com.tecsup.semana05.services.DetalleMatriculaService;
import com.tecsup.semana05.util.Util;

import java.util.List;

public class DetalleMatriculaServiceImpl implements DetalleMatriculaService {

    private DetalleMatriculaDao dao;

    public DetalleMatriculaServiceImpl() {
        dao = DaoFactory.getDetalleMatriculaDao(Util.opc);
    }

    @Override
    public void registrar(DetalleMatricula detalleMatricula) {
        dao.create(detalleMatricula);
    }

    @Override
    public void actualizar(DetalleMatricula detalleMatricula) {
        dao.update(detalleMatricula);
    }

    @Override
    public void eliminar(String id) {
        dao.delete(id);
    }

    @Override
    public DetalleMatricula buscar(String id) {
        return dao.find(id);
    }

    @Override
    public List<DetalleMatricula> listar() {
        return dao.findAll();
    }

    @Override
    public List<DetalleMatricula> listarPorCurso(String codigoCurso) {
        return dao.findByCurso(codigoCurso);
    }

    @Override
    public List<DetalleMatricula> listarPorMatricula(String codigoMatricula) {
        return List.of();
    }
}
