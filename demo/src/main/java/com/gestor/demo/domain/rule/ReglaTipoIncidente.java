package com.gestor.demo.domain.rule;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.domain.model.TipoSolicitud;

public class ReglaTipoIncidente implements ReglaPrioridad {

    @Override
    public int calcular(Solicitud solicitud) {
        return solicitud.getTipo() == TipoSolicitud.INCIDENTE ? 50 : 0;
    }
}
