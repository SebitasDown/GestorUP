package com.gestor.demo.application.service;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.domain.port.in.ObtenerTodasSolicitudesUseCase;
import com.gestor.demo.domain.port.out.SolicitudRepository;

import java.util.List;

public class ObtenerTodasSolicitudesService implements ObtenerTodasSolicitudesUseCase {

    private final SolicitudRepository solicitudRepository;

    public ObtenerTodasSolicitudesService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }
}
