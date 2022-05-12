package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.AdjuntoDto;
import com.aplanells.school.application.service.AdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdjuntoRestController {
    private final AdjuntoService adjuntoService;

    @Autowired
    public AdjuntoRestController(AdjuntoService adjuntoService) {
        this.adjuntoService = adjuntoService;
    }

    @GetMapping(value = "/adjuntos", produces = "application/json")
    public ResponseEntity<List<AdjuntoDto>> obtenerAdjuntos() {
        List<AdjuntoDto> adjuntoDtos = adjuntoService.obtenerAdjuntos();
        return new ResponseEntity<>(adjuntoDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/adjuntos/{adjuntoId}", produces = "application/json")
    public ResponseEntity<AdjuntoDto> obtenerAdjuntosPorId(@PathVariable Long adjuntoId) {
        return adjuntoService
                .obtenerAdjuntoPorId(adjuntoId)
                .map(adjuntoDto -> new ResponseEntity(adjuntoDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/adjuntos", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AdjuntoDto> crearAdjunto(@RequestBody AdjuntoDto adjuntoDto) {
        adjuntoDto = adjuntoService.crearAdjunto(adjuntoDto);
        return new ResponseEntity<>(adjuntoDto, HttpStatus.CREATED);
    }
}
