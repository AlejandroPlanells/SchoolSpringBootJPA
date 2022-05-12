package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.CuestionarioDto;
import com.aplanells.school.application.dto.PreguntaCuestionarioDto;
import com.aplanells.school.application.service.CuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuestionarioRestController {
    private final CuestionarioService cuestionarioService;

    @Autowired
    public CuestionarioRestController(CuestionarioService cuestionarioService) {
        this.cuestionarioService = cuestionarioService;
    }

    @GetMapping(value = "/cuestionarios", produces = "application/json")
    public ResponseEntity<List<CuestionarioDto>> obtenerCuestionarios() {
        List<CuestionarioDto> cuestionarioDtos = cuestionarioService.obtenerCuestionarios();
        return new ResponseEntity<>(cuestionarioDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/cuestionarios/{cuestionarioId}", produces = "application/json")
    public ResponseEntity<CuestionarioDto> obtenerCuestionarioPorId(@PathVariable Long cuestionarioId) {
        return cuestionarioService
                .obtenerCuestionarioPorId(cuestionarioId)
                .map(cuestionarioDto -> new ResponseEntity(cuestionarioDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/cuestionarios", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CuestionarioDto> crearCuestionario(@RequestBody CuestionarioDto cuestionarioDto) {
        cuestionarioDto = cuestionarioService.crearCuestionario(cuestionarioDto);
        return new ResponseEntity<>(cuestionarioDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/cuestionarios/{cuestionarioId}/preguntas", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<PreguntaCuestionarioDto>> anadePreguntaEnCuestionario(@PathVariable Long cuestionarioId,
                                                                                     @RequestBody PreguntaCuestionarioDto preguntaCuestionarioDto) {
        List<PreguntaCuestionarioDto> preguntaCuestionarioDtos = cuestionarioService
                .anadePreguntaEnCuestionario(cuestionarioId, preguntaCuestionarioDto);
        return new ResponseEntity<>(preguntaCuestionarioDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/cuestionarios/{cuestionarioId}/preguntas", produces = "application/json")
    public ResponseEntity<List<PreguntaCuestionarioDto>> obtenerPreguntaDeCuestionario(@PathVariable Long cuestionarioId) {
        List<PreguntaCuestionarioDto> preguntaCuestionarioDtos = cuestionarioService
                .obtenerPreguntasDecuestionario(cuestionarioId);
        return new ResponseEntity<>(preguntaCuestionarioDtos, HttpStatus.OK);
    }


}
