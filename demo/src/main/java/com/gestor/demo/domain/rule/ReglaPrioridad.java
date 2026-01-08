package com.gestor.demo.domain.rule;

import com.gestor.demo.domain.model.Solicitud;

public interface ReglaPrioridad {
    int calcular(Solicitud solicitud);
}
