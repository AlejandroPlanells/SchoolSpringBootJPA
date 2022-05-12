package com.aplanells.school.application.service;

import com.aplanells.school.application.dto.CuestionarioDto;
import com.aplanells.school.application.dto.PreguntaCuestionarioDto;

import java.util.List;
import java.util.Optional;

public interface CuestionarioService {
    List<CuestionarioDto> obtenerCuestionarios();
    Optional<CuestionarioDto> obtenerCuestionarioPorId(Long id);
    CuestionarioDto crearCuestionario(CuestionarioDto cuestionarioDto);

    List<PreguntaCuestionarioDto> anadePreguntaEnCuestionario(Long cuestionarioId, PreguntaCuestionarioDto preguntaCuestionarioDto);
    List<PreguntaCuestionarioDto> obtenerPreguntasDecuestionario(Long cuestionarioId);
}
