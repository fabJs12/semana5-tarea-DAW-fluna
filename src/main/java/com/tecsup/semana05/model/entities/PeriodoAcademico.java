package com.tecsup.semana05.model.entities;

import java.util.Date;

public class PeriodoAcademico {
    private String codigo;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;

    public PeriodoAcademico() {}

    public PeriodoAcademico(String codigo, String nombre, Date fechaInicio, String estado, Date fechaFin) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
