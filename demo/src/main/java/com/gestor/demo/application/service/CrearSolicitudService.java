package com.gestor.demo.application.service;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.domain.port.in.RegistrarSolicitudUseCase;
import com.gestor.demo.domain.port.out.SolicitudRepository;
import org.springframework.stereotype.Service;


public class CrearSolicitudService implements RegistrarSolicitudUseCase {

    private final SolicitudRepository solicitudRepository;

    public CrearSolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public Solicitud create(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

}
