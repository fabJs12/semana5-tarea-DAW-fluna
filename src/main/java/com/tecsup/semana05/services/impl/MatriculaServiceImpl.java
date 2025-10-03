package com.tecsup.semana05.services.impl;

import com.tecsup.semana05.model.daos.MatriculaDao;
import com.tecsup.semana05.model.daos.impl.DaoFactory;
import com.tecsup.semana05.model.entities.Matricula;
import com.tecsup.semana05.services.MatriculaService;
import com.tecsup.semana05.util.Util;

import java.util.List;

public class MatriculaServiceImpl implements MatriculaService {
    private MatriculaDao dao;

    public MatriculaServiceImpl () {
        dao = DaoFactory.getMatriculaDao(Util.opc);
    }

    @Override
    public void registrar(Matricula matricula) {
        dao.create(matricula);
    }

    @Override
    public void actualizar(Matricula matricula) {
        dao.update(matricula);
    }

    @Override
    public void eliminar(String id) {
        dao.delete(id);
    }

    @Override
    public Matricula buscar(String id) {
        return dao.find(id);
    }

    @Override
    public List<Matricula> listar() {
        return dao.findAll();
    }

    @Override
    public List<Matricula> listarPorAlumno(String codigoAlumno) {
        return dao.findByAlumno(codigoAlumno);
    }

    @Override
    public List<Matricula> listarPorPeriodo(String codigoPeriodo) {
        return List.of();
    }
}
