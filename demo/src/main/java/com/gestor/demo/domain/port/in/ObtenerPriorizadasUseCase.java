package com.gestor.demo.domain.port.in;

import com.gestor.demo.domain.model.Solicitud;

import java.util.List;

public interface ObtenerPriorizadasUseCase {
    List<Solicitud> priorizadas();
}
