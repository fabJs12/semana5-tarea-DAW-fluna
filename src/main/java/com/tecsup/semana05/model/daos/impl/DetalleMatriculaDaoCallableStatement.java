package com.tecsup.semana05.model.daos.impl;

import com.tecsup.semana05.model.daos.DetalleMatriculaDao;
import com.tecsup.semana05.model.entities.DetalleMatricula;
import com.tecsup.semana05.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleMatriculaDaoCallableStatement implements DetalleMatriculaDao {
    @Override
    public List<DetalleMatricula> findByCurso(String codigoCurso) {
        List<DetalleMatricula> lista = new ArrayList<>();
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_findByCurso_detalle(?)}")) {

            cs.setString(1, codigoCurso);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                DetalleMatricula detalle = new DetalleMatricula();
                detalle.setCodigo(rs.getString("chrDetCodigo"));
                detalle.setCodigoMatricula(rs.getString("chrMatCodigo"));
                detalle.setCodigoCurso(rs.getString("chrCurCodigo"));
                detalle.setEstado(rs.getString("chrDetEstado"));
                detalle.setCodigoAlumno(rs.getString("chrAluCodigo"));
                detalle.setNombreAlumno(rs.getString("vchAluNombres"));
                detalle.setApellidoAlumno(rs.getString("vchAluApellidos"));
                lista.add(detalle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<DetalleMatricula> findByMatricula(String codigoMatricula) {
        return List.of();
    }

    @Override
    public void create(DetalleMatricula detalleMatricula) {
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_ins_detalle(?,?,?,?)}")) {

            cs.setString(1, detalleMatricula.getCodigo());
            cs.setString(2, detalleMatricula.getCodigoMatricula());
            cs.setString(3, detalleMatricula.getCodigoCurso());
            cs.setString(4, detalleMatricula.getEstado());
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetalleMatricula find(String id) {
        DetalleMatricula detalle = null;
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_find_detalle(?)}")) {

            cs.setString(1, id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                detalle = new DetalleMatricula();
                detalle.setCodigo(rs.getString("chrDetCodigo"));
                detalle.setCodigoMatricula(rs.getString("chrMatCodigo"));
                detalle.setCodigoCurso(rs.getString("chrCurCodigo"));
                detalle.setEstado(rs.getString("chrDetEstado"));
                detalle.setCodigoAlumno(rs.getString("chrAluCodigo"));
                detalle.setNombreCurso(rs.getString("vchCurNombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalle;
    }

    @Override
    public List<DetalleMatricula> findAll() {
        List<DetalleMatricula> lista = new ArrayList<>();
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_findAll_detalle()}")) {

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                DetalleMatricula detalle = new DetalleMatricula();
                detalle.setCodigo(rs.getString("chrDetCodigo"));
                detalle.setCodigoMatricula(rs.getString("chrMatCodigo"));
                detalle.setCodigoCurso(rs.getString("chrCurCodigo"));
                detalle.setEstado(rs.getString("chrDetEstado"));
                detalle.setCodigoAlumno(rs.getString("chrAluCodigo"));
                detalle.setNombreAlumno(rs.getString("vchAluNombres"));
                detalle.setApellidoAlumno(rs.getString("vchAluApellidos"));
                detalle.setNombreCurso(rs.getString("vchCurNombre"));
                lista.add(detalle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(DetalleMatricula detalleMatricula) {
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_upd_detalle(?,?,?,?)}")) {

            cs.setString(1, detalleMatricula.getCodigo());
            cs.setString(2, detalleMatricula.getCodigoMatricula());
            cs.setString(3, detalleMatricula.getCodigoCurso());
            cs.setString(4, detalleMatricula.getEstado());
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try (Connection conn = DBConn.getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_del_detalle(?)}")) {

            cs.setString(1, id);
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
