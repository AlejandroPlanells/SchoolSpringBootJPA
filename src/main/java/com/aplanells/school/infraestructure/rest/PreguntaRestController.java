package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.PreguntaDto;
import com.aplanells.school.application.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PreguntaRestController {
    private final PreguntaService preguntaService;

    @Autowired
    public PreguntaRestController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping(value = "/preguntas", produces = "application/json")
    public ResponseEntity<List<PreguntaDto>> obtenerPreguntas() {
        List<PreguntaDto> preguntaDtos = preguntaService.obtenerPreguntas();
        return new ResponseEntity<>(preguntaDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/preguntas/{preguntaId}", produces = "application/json")
    public ResponseEntity<PreguntaDto> obtenerPreguntasPorId(@PathVariable Long preguntaId) {
        return preguntaService
                .obtenerPreguntasPorId(preguntaId)
                .map(preguntaDto -> new ResponseEntity(preguntaDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/preguntas", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PreguntaDto> crearPregunta(@RequestBody PreguntaDto preguntaDto) {
        preguntaDto = preguntaService.crearPregunta(preguntaDto);
        return new ResponseEntity<>(preguntaDto, HttpStatus.CREATED);
    }

}
