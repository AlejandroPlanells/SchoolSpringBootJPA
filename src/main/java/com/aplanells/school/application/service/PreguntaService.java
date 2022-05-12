package com.aplanells.school.application.service;

import com.aplanells.school.application.dto.PreguntaDto;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    List<PreguntaDto> obtenerPreguntas();
    Optional<PreguntaDto> obtenerPreguntasPorId(Long id);
    PreguntaDto crearPregunta(PreguntaDto preguntaDto);
}
