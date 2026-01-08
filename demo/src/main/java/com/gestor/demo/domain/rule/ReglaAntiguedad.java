package com.gestor.demo.domain.rule;

import com.gestor.demo.domain.model.Solicitud;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ReglaAntiguedad implements ReglaPrioridad {
    @Override
    public int calcular(Solicitud solicitud) {
        long horas = ChronoUnit.HOURS.between(
                solicitud.getFechaCreacion(),
                LocalDateTime.now());
        return (int) Math.min(horas, 20);
    }
}
