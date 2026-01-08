package com.gestor.demo.domain.model;

import java.time.LocalDateTime;

public class Solicitud {
    private Long id;
    private TipoSolicitud tipo;
    private int prioridadManual;
    private LocalDateTime fechaCreacion;
    private String usuario;

    public Solicitud(Long id, TipoSolicitud tipo, int prioridadManual, String usuario, LocalDateTime fechaCreacion) {
        this.id = id;
        this.tipo = tipo;
        this.prioridadManual = prioridadManual;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public TipoSolicitud getTipo() {
        return tipo;
    }

    public int getPrioridadManual() {
        return prioridadManual;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getUsuario() {
        return usuario;
    }
}
