package com.gestor.demo.domain.port.in;

import com.gestor.demo.domain.model.Solicitud;

public interface RegistrarSolicitudUseCase {
    Solicitud create (Solicitud solicitud);
}
