package com.gestor.demo.domain.service;

import com.gestor.demo.domain.model.Solicitud;

public interface MotorPrioridadInterface {
    int calcularPrioridad(Solicitud solicitud);
}
