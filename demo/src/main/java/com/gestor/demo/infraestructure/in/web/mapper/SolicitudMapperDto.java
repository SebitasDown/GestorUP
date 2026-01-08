package com.gestor.demo.infraestructure.in.web.mapper;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.infraestructure.in.web.dto.SolicitudDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitudMapperDto {

    Solicitud toDomain(SolicitudDTO solicitudDTO);

    SolicitudDTO toDto(Solicitud solicitud);
}
