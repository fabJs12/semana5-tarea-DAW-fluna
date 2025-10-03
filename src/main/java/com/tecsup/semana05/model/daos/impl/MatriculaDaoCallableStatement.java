package com.tecsup.semana05.model.daos.impl;

import com.tecsup.semana05.model.daos.MatriculaDao;
import com.tecsup.semana05.model.entities.Matricula;
import com.tecsup.semana05.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDaoCallableStatement implements MatriculaDao {
    @Override
    public List<Matricula> findByAlumno(String codigoAlumno) {
        return List.of();
    }

    @Override
    public List<Matricula> findByPeriodo(String codigoPeriodo) {
        return List.of();
    }

    @Override
    public void create(Matricula matricula) {
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_ins_matricula(?,?,?,?,?)}")) {

            cs.setString(1, matricula.getCodigo());
            cs.setString(2, matricula.getCodigoAlumno());
            cs.setString(3, matricula.getCodigoPeriodo());
            cs.setDate(4, new java.sql.Date(matricula.getFecha().getTime()));
            cs.setString(5, matricula.getEstado());
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Matricula find(String id) {
        Matricula matricula = null;
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_find_matricula(?)}")) {

            cs.setString(1, id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                matricula = new Matricula();
                matricula.setCodigo(rs.getString("chrMatCodigo"));
                matricula.setCodigoAlumno(rs.getString("chrAluCodigo"));
                matricula.setCodigoPeriodo(rs.getString("chrPerCodigo"));
                matricula.setFecha(rs.getDate("dtmMatFecha"));
                matricula.setEstado(rs.getString("chrMatEstado"));
                matricula.setNombreAlumno(rs.getString("vchAluNombres"));
                matricula.setApellidoAlumno(rs.getString("vchAluApellidos"));
                matricula.setNombrePeriodo(rs.getString("vchPerNombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matricula;
    }

    @Override
    public List<Matricula> findAll() {
        List<Matricula> lista = new ArrayList<>();
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_findAll_matricula()}")) {

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setCodigo(rs.getString("chrMatCodigo"));
                matricula.setCodigoAlumno(rs.getString("chrAluCodigo"));
                matricula.setCodigoPeriodo(rs.getString("chrPerCodigo"));
                matricula.setFecha(rs.getDate("dtmMatFecha"));
                matricula.setEstado(rs.getString("chrMatEstado"));
                matricula.setNombreAlumno(rs.getString("vchAluNombres"));
                matricula.setApellidoAlumno(rs.getString("vchAluApellidos"));
                matricula.setNombrePeriodo(rs.getString("vchPerNombre"));
                lista.add(matricula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(Matricula matricula) {
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_upd_matricula(?,?,?,?,?)}")) {

            cs.setString(1, matricula.getCodigo());
            cs.setString(2, matricula.getCodigoAlumno());
            cs.setString(3, matricula.getCodigoPeriodo());
            cs.setDate(4, new java.sql.Date(matricula.getFecha().getTime()));
            cs.setString(5, matricula.getEstado());
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_del_matricula(?)}")) {

            cs.setString(1, id);
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
