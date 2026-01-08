package com.gestor.demo.infraestructure.out.persistence.adapter;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.domain.port.out.SolicitudRepository;
import com.gestor.demo.infraestructure.out.persistence.entity.SolicitudEntity;
import com.gestor.demo.infraestructure.out.persistence.jpa.SolicitudJpaRepository;
import com.gestor.demo.infraestructure.out.persistence.mapper.SolicitudMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SolicitudAdapter implements SolicitudRepository {

    private final SolicitudJpaRepository solicitudJpaRepository;
    private final SolicitudMapper solicitudMapper;

    public SolicitudAdapter(SolicitudJpaRepository solicitudJpaRepository, SolicitudMapper solicitudMapper) {
        this.solicitudJpaRepository = solicitudJpaRepository;
        this.solicitudMapper = solicitudMapper;
    }

    @Override
    public Solicitud save(Solicitud solicitud) {
        SolicitudEntity soli = solicitudMapper.toEntity(solicitud);
        if (soli.getFechaCreacion() == null) {
            soli.setFechaCreacion(java.time.LocalDateTime.now());
        }
        SolicitudEntity save = solicitudJpaRepository.save(soli);
        return solicitudMapper.toDomain(save);
    }

    @Override
    public List<Solicitud> findAll() {
        List<SolicitudEntity> entityList = solicitudJpaRepository.findAll();
        return entityList.stream()
                .map(solicitudMapper::toDomain)
                .toList();
    }
}
