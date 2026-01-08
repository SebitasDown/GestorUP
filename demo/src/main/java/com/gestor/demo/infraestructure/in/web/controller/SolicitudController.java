package com.gestor.demo.infraestructure.in.web.controller;

import com.gestor.demo.domain.model.Solicitud;
import com.gestor.demo.domain.port.in.ObtenerPriorizadasUseCase;
import com.gestor.demo.domain.port.in.ObtenerTodasSolicitudesUseCase;
import com.gestor.demo.domain.port.in.RegistrarSolicitudUseCase;
import com.gestor.demo.infraestructure.in.web.dto.SolicitudDTO;
import com.gestor.demo.infraestructure.in.web.mapper.SolicitudMapperDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
@RequiredArgsConstructor
public class SolicitudController {

    private final RegistrarSolicitudUseCase registrarSolicitudUseCase;
    private final ObtenerPriorizadasUseCase obtenerPriorizadasUseCase;
    private final ObtenerTodasSolicitudesUseCase obtenerTodasSolicitudesUseCase;
    private final SolicitudMapperDto mapper;

    @PostMapping
    public ResponseEntity<SolicitudDTO> crear(@Valid @RequestBody SolicitudDTO dto) {
        Solicitud soli = mapper.toDomain(dto);
        Solicitud solicitudCreada = registrarSolicitudUseCase.create(soli);
        SolicitudDTO respuesta = mapper.toDto(solicitudCreada);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudDTO>> listarTodas() {
        List<Solicitud> solicitudes = obtenerTodasSolicitudesUseCase.findAll();
        List<SolicitudDTO> respuesta = solicitudes.stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/priorizadas")
    public ResponseEntity<List<SolicitudDTO>> listarPrioridades() {
        List<Solicitud> priorizadas = obtenerPriorizadasUseCase.priorizadas();

        List<SolicitudDTO> respuesta = priorizadas.stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }
}
