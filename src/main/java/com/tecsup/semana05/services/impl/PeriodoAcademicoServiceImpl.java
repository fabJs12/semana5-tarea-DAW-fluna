package com.tecsup.semana05.services.impl;

import com.tecsup.semana05.model.daos.PeriodoAcademicoDao;
import com.tecsup.semana05.model.daos.impl.DaoFactory;
import com.tecsup.semana05.model.entities.PeriodoAcademico;
import com.tecsup.semana05.services.PeriodoAcademicoService;
import com.tecsup.semana05.util.Util;

import java.util.List;

public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
    private PeriodoAcademicoDao dao;
    public PeriodoAcademicoServiceImpl() {
        dao = DaoFactory.getPeriodoAcademicoDao(Util.opc);
    }

    @Override
    public void registrar(PeriodoAcademico periodoAcademico) {
        dao.create(periodoAcademico);
    }

    @Override
    public void actualizar(PeriodoAcademico periodoAcademico) {
        dao.update(periodoAcademico);
    }

    @Override
    public void eliminar(String id) {
        dao.delete(id);
    }

    @Override
    public PeriodoAcademico buscar(String id) {
        return dao.find(id);
    }

    @Override
    public List<PeriodoAcademico> listar() {
        return dao.findAll();
    }

    @Override
    public List<PeriodoAcademico> listarActivos() {
        return dao.findByEstado("A");
    }
}
