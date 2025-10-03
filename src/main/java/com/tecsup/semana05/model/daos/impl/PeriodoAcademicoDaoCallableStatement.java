package com.tecsup.semana05.model.daos.impl;

import com.tecsup.semana05.model.daos.PeriodoAcademicoDao;
import com.tecsup.semana05.model.entities.PeriodoAcademico;
import com.tecsup.semana05.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeriodoAcademicoDaoCallableStatement implements PeriodoAcademicoDao {
    @Override
    public List<PeriodoAcademico> findByEstado(String estado) {
        List<PeriodoAcademico> lista = new ArrayList<>();
        try (Connection conn = DBConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM PeriodoAcademico WHERE chrPerEstado = ?")) {

            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PeriodoAcademico periodo = new PeriodoAcademico();
                periodo.setCodigo(rs.getString("chrPerCodigo"));
                periodo.setNombre(rs.getString("vchPerNombre"));
                periodo.setFechaInicio(rs.getDate("dtmPerFechaInicio"));
                periodo.setFechaFin(rs.getDate("dtmPerFechaFin"));
                periodo.setEstado(rs.getString("chrPerEstado"));
                lista.add(periodo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void create(PeriodoAcademico periodoAcademico) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cs = con.prepareCall("{call sp_ins_periodo(?,?,?,?,?)}")) {
            cs.setString(1, periodoAcademico.getCodigo());
            cs.setString(2, periodoAcademico.getNombre());
            cs.setDate(3, new java.sql.Date(periodoAcademico.getFechaInicio().getTime()));
            cs.setDate(4, new java.sql.Date(periodoAcademico.getFechaFin().getTime()));
            cs.setString(5, periodoAcademico.getEstado());
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PeriodoAcademico find(String id) {
        PeriodoAcademico periodoAcademico = null;
        try (Connection con = DBConn.getConnection();
            CallableStatement cst = con.prepareCall("{call sp_find_periodo(?)}")) {
            cst.setString(1, id);
            ResultSet rs = cst.executeQuery();

            if (rs.next()) {
                periodoAcademico = new PeriodoAcademico();
                periodoAcademico.setCodigo(rs.getString("chrPerCodigo"));
                periodoAcademico.setNombre(rs.getString("vchPerNombre"));
                periodoAcademico.setFechaInicio(rs.getDate("dtmPerFechaInicio"));
                periodoAcademico.setFechaFin(rs.getDate("dtmPerFechaFin"));
                periodoAcademico.setEstado(rs.getString("chrPerEstado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return periodoAcademico;
    }

    @Override
    public List<PeriodoAcademico> findAll() {
        List<PeriodoAcademico> lista = new ArrayList<>();
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_findAll_periodo()}")) {
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                PeriodoAcademico periodo = new PeriodoAcademico();
                periodo.setCodigo(rs.getString("chrPerCodigo"));
                periodo.setNombre(rs.getString("vchPerNombre"));
                periodo.setFechaInicio(rs.getDate("dtmPerFechaInicio"));
                periodo.setFechaFin(rs.getDate("dtmPerFechaFin"));
                periodo.setEstado(rs.getString("chrPerEstado"));
                lista.add(periodo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(PeriodoAcademico periodoAcademico) {
        try(Connection con = DBConn.getConnection();
            CallableStatement cst = con.prepareCall("{call sp_upd_periodo(?,?,?,?,?)}")) {
            cst.setString(1, periodoAcademico.getCodigo());
            cst.setString(2, periodoAcademico.getNombre());
            cst.setDate(3, new java.sql.Date(periodoAcademico.getFechaInicio().getTime()));
            cst.setDate(4, new java.sql.Date(periodoAcademico.getFechaFin().getTime()));
            cst.setString(5, periodoAcademico.getEstado());
            cst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try(Connection con = DBConn.getConnection();
            CallableStatement cst = con.prepareCall("{call sp_del_periodo(?)}")) {
            cst.setString(1, id);
            cst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
