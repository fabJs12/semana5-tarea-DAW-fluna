package com.tecsup.semana05.model.daos.impl;

import com.tecsup.semana05.model.daos.AdministradorDao;
import com.tecsup.semana05.model.daos.CursoDao;
import com.tecsup.semana05.util.Tipo;

public class DaoFactory {

    public static AdministradorDao getAdministradorDao(Tipo tipo) {
        switch (tipo) {
            case CST:
                return new AdministradorDaoCallableStatement();
            default:
                return null;
        }
    }

    public static CursoDao getCursoDao(Tipo tipo) {
        switch (tipo) {
            case CST:
                return new CursoDaoCallableStatement();
                default:
                    return null;
        }
    }
}
