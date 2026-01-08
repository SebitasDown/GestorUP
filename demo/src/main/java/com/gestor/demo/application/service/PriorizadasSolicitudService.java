package com.gestor.demo.application.service;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.domain.port.in.ObtenerPriorizadasUseCase;
import com.gestor.demo.domain.port.out.SolicitudRepository;
import com.gestor.demo.domain.service.MotorPrioridadInterface;

import java.util.ArrayList;
import java.util.List;

public class PriorizadasSolicitudService implements ObtenerPriorizadasUseCase {

    private final SolicitudRepository solicitudRepository;
    private final MotorPrioridadInterface motorPrioridad;

    public PriorizadasSolicitudService(SolicitudRepository solicitudRepository,
            MotorPrioridadInterface motorPrioridad) {
        this.solicitudRepository = solicitudRepository;
        this.motorPrioridad = motorPrioridad;
    }

    @Override
    public List<Solicitud> priorizadas() {
        List<Solicitud> lista = solicitudRepository.findAll();
        List<Solicitud> listaMutable = new ArrayList<>(lista);

        listaMutable.sort((s1, s2) -> {
            int puntos1 = motorPrioridad.calcularPrioridad(s1);
            int puntos2 = motorPrioridad.calcularPrioridad(s2);
            return Integer.compare(puntos2, puntos1);
        });

        return listaMutable;
    }
}
