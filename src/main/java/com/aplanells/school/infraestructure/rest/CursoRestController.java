package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.CursoDto;
import com.aplanells.school.application.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoRestController {

    private final CursoService cursoService;

    @Autowired
    public CursoRestController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @GetMapping(value = "/cursos", produces = "application/json")
    public ResponseEntity<List<CursoDto>> obtenerCursos() {
        List<CursoDto> cursoDtos = cursoService.obtenerCursos();
        return new ResponseEntity<>(cursoDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/cursos/{cursoId}", produces = "application/json")
    public ResponseEntity<CursoDto> obtenerCursoPorId(@PathVariable Long cursoId) {
        return cursoService
                .obtenerCursoPorId(cursoId)
                .map(cursoDto -> new ResponseEntity(cursoDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/cursos", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CursoDto> crearCurso(@RequestBody CursoDto cursoDto) {
        cursoDto = cursoService.crearCurso(cursoDto);
        return new ResponseEntity<>(cursoDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/cursos/{cursoId}")
    public ResponseEntity<Void> eliminarCursoPorId(@PathVariable Long cursoId) {
        cursoService.eliminarCursoPorId(cursoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
