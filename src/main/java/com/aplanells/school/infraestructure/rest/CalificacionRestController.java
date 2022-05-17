package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.CalificacionDto;
import com.aplanells.school.application.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos/{alumnoId}")
public class CalificacionRestController {
    private final CalificacionService calificacionService;

    @Autowired
    public CalificacionRestController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @GetMapping(value = "/calificaciones", produces = "application/json")
    public ResponseEntity<List<CalificacionDto>> obtenerCalificaciones(@PathVariable Long alumnoId) {
        List<CalificacionDto> calificacionDtos = calificacionService.obtenerCalificacionesDeUnAlumno(alumnoId);
        return new ResponseEntity<>(calificacionDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/calificaciones/{calificacionId}", produces = "application/json")
    public ResponseEntity<CalificacionDto> obtenerCalificacion(@PathVariable Long alumnoId, @PathVariable Long calificacionId) {
        return calificacionService
                .obtenerCalificacionDeUnAlumno(alumnoId, calificacionId)
                .map(calificacionDto -> new ResponseEntity(calificacionDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/calificaciones", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<CalificacionDto>> crearCalificacion(@PathVariable Long alumnoId, @RequestBody CalificacionDto calificacionDto) {
        List<CalificacionDto> calificacionDtos = calificacionService.crearCalificacionDeAlumno(alumnoId, calificacionDto);
        return new ResponseEntity<>(calificacionDtos, HttpStatus.CREATED);
    }

}
