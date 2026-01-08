package com.gestor.demo.infraestructure.out.persistence.jpa;

import com.gestor.demo.infraestructure.out.persistence.entity.SolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudJpaRepository extends JpaRepository<SolicitudEntity, Long> {
}
