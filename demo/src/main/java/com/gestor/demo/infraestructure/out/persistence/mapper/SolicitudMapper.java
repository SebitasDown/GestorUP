package com.gestor.demo.infraestructure.out.persistence.mapper;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.infraestructure.out.persistence.entity.SolicitudEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SolicitudMapper {

    Solicitud toDomain(SolicitudEntity entity);

    @Mapping(target = "id", ignore = true)
    SolicitudEntity toEntity(Solicitud domain);
}
