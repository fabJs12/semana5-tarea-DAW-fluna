package com.tecsup.semana05.model.daos.impl;

import com.tecsup.semana05.model.daos.*;
import com.tecsup.semana05.util.Tipo;
import com.tecsup.semana05.util.Util;

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

    public static PeriodoAcademicoDao getPeriodoAcademicoDao(Tipo tipo) {
        switch (tipo) {
            case CST:
                return new PeriodoAcademicoDaoCallableStatement();
                default:
                    return null;
        }
    }

    public static MatriculaDao getMatriculaDao(Tipo tipo) {
        switch (tipo) {
            case CST:
                return new MatriculaDaoCallableStatement();
                default:
                    return null;
        }
    }

    public static DetalleMatriculaDao getDetalleMatriculaDao(Tipo tipo) {
        switch (tipo) {
            case CST:
                return new DetalleMatriculaDaoCallableStatement();
                default:
                    return null;
        }
    }
}
