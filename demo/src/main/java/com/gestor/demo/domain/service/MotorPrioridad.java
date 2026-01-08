package com.gestor.demo.domain.service;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.domain.rule.ReglaPrioridad;

import java.util.List;

public class MotorPrioridad implements  MotorPrioridadInterface{

    private final List<ReglaPrioridad> reglas;

    public MotorPrioridad(List<ReglaPrioridad> reglas) {
        this.reglas = reglas;
    }

    @Override
    public int calcularPrioridad(Solicitud solicitud) {
        return reglas.stream()
                .mapToInt(regla -> regla.calcular(solicitud))
                .sum();
    }
}
