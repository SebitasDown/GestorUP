package com.gestor.demo.domain.port.out;

import com.gestor.demo.domain.model.Solicitud;

import java.util.List;

public interface SolicitudRepository {
    Solicitud save (Solicitud solicitud);
    List<Solicitud> findAll();
}
