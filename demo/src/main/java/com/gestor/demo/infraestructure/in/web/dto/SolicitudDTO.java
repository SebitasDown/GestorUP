package com.gestor.demo.infraestructure.in.web.dto;

import com.gestor.demo.domain.model.TipoSolicitud;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
    private Long id;

    @NotNull(message = "El de solicitud debe ser obligatoria")
    private TipoSolicitud tipo;

    @Min(value = 1, message = "La prioridad minima es 1")
    @Min(value = 1, message = "La prioridad maxima es 5")
    private int prioridadManual;

    private LocalDateTime fechaCreacion;

    @NotBlank(message = "El niombre de usuario es obligatorio")
    private String usuario;
}
