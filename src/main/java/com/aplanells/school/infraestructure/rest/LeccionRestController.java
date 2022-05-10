package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.LeccionDto;
import com.aplanells.school.application.service.LeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos/{cursoId}")
public class LeccionRestController {
    private final LeccionService leccionService;

    @Autowired
    public LeccionRestController(LeccionService leccionService) {
        this.leccionService = leccionService;
    }

    @GetMapping(value = "/lecciones", produces = "application/json")
    public ResponseEntity<List<LeccionDto>> obtenerLeccionesDeCurso(@PathVariable Long cursoId) {
        List<LeccionDto> leccioneDtos = leccionService.obtenerLeccionesDeUnCurso(cursoId);
        return new ResponseEntity<>(leccioneDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/lecciones/{leccionId}", produces = "application/json")
    public ResponseEntity<LeccionDto> obtenerLeccion(@PathVariable Long cursoId, @PathVariable Long leccionId) {
        return leccionService
                .obtenerLeccionDeUnCurso(cursoId, leccionId)
                .map(leccionDto -> new ResponseEntity(leccionDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/lecciones", produces = "application/json", consumes = "application/json")
    public ResponseEntity<LeccionDto> crearLeccionEnCurso(@PathVariable Long cursoId, @RequestBody LeccionDto leccionDto) {
        leccionDto = leccionService.crearLeccion(cursoId, leccionDto);
        return new ResponseEntity<>(leccionDto, HttpStatus.CREATED);
    }


}
