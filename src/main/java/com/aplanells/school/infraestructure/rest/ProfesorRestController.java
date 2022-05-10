package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.ProfesorDto;
import com.aplanells.school.application.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorRestController {

    private final ProfesorService profesorService;

    @Autowired
    public ProfesorRestController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping(value = "/profesores", produces = "application/json")
    public ResponseEntity<List<ProfesorDto>> obtenerProfesores() {
        List<ProfesorDto> profesores = profesorService.obtenerProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @GetMapping(value = "/profesores/{profesorId}", produces = "application/json")
    public ResponseEntity<ProfesorDto> obtenerProfesorPorId(@PathVariable Long profesorId) {
        return profesorService
                .obtenerProfesorPorId(profesorId)
                .map(profesorDto -> new ResponseEntity(profesorDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/profesores", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ProfesorDto> crearProfesor(@RequestBody ProfesorDto profesorDto) {
        profesorDto = profesorService.crearProfesor(profesorDto);
        return new ResponseEntity<>(profesorDto, HttpStatus.CREATED);
    }

}
