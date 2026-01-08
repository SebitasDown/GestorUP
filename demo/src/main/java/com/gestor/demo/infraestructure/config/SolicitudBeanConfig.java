package com.gestor.demo.infraestructure.config;

import com.gestor.demo.application.service.CrearSolicitudService;
import com.gestor.demo.application.service.ObtenerTodasSolicitudesService;
import com.gestor.demo.application.service.PriorizadasSolicitudService;
import com.gestor.demo.domain.port.out.SolicitudRepository;
import com.gestor.demo.domain.rule.ReglaAntiguedad;
import com.gestor.demo.domain.rule.ReglaPrioridadManual;
import com.gestor.demo.domain.rule.ReglaTipoIncidente;
import com.gestor.demo.domain.service.MotorPrioridad;
import com.gestor.demo.domain.service.MotorPrioridadInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SolicitudBeanConfig {

    @Bean
    public MotorPrioridadInterface motorPrioridad() {

        return new MotorPrioridad(List.of(
                new ReglaAntiguedad(),
                new ReglaTipoIncidente(),
                new ReglaPrioridadManual()));
    }

    @Bean
    public PriorizadasSolicitudService priorizadasSolicitudService(
            SolicitudRepository repository,
            MotorPrioridadInterface motor) {
        return new PriorizadasSolicitudService(repository, motor);
    }

    @Bean
    public CrearSolicitudService registrarSolicitudService(SolicitudRepository repository) {
        return new CrearSolicitudService(repository);
    }

    @Bean
    public ObtenerTodasSolicitudesService obtenerTodasSolicitudesService(SolicitudRepository repository) {
        return new ObtenerTodasSolicitudesService(repository);
    }
}
