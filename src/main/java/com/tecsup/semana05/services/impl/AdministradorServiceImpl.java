package com.tecsup.semana05.services.impl;

import com.tecsup.semana05.model.daos.AdministradorDao;
import com.tecsup.semana05.model.daos.impl.DaoFactory;
import com.tecsup.semana05.model.entities.Administrador;
import com.tecsup.semana05.services.AdministradorService;
import com.tecsup.semana05.util.Util;

public class AdministradorServiceImpl implements AdministradorService {

    private AdministradorDao dao;

    public AdministradorServiceImpl() {
        dao = DaoFactory.getAdministradorDao(Util.opc);
    }

    @Override
    public Administrador validar(String u, String p) {
        return dao.validar(u, p);
    }
}
