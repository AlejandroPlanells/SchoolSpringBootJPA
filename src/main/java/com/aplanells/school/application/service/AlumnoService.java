package com.aplanells.school.application.service;

import com.aplanells.school.application.dto.AlumnoDto;
import com.aplanells.school.application.dto.CursoSimpleDto;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<AlumnoDto> obtenerAlumnos();
    Optional<AlumnoDto> obtenerAlumnoPorId(Long id);
    AlumnoDto crearAlumno(AlumnoDto alumnoDto);
    void eliminarAlumnoPorId(Long alumnoId);
    List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDto);

    void eliminarCursoDeAlumno(Long alumnoId, Long cursoId);
}