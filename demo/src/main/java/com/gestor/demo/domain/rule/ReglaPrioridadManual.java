package com.gestor.demo.domain.rule;

import com.gestor.demo.domain.model.Solicitud;

public class ReglaPrioridadManual implements ReglaPrioridad {
    @Override
    public int calcular(Solicitud solicitud) {
        return solicitud.getPrioridadManual() * 10;
    }
}
