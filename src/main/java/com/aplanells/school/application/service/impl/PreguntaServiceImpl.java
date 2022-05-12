package com.aplanells.school.application.service.impl;

import com.aplanells.school.application.dto.PreguntaDto;
import com.aplanells.school.application.mapper.PreguntaMapper;
import com.aplanells.school.application.service.PreguntaService;
import com.aplanells.school.domain.entity.Pregunta;
import com.aplanells.school.infraestructure.repository.PreguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntasRepository preguntasRepository;
    private final PreguntaMapper preguntaMapper;

    @Autowired
    public PreguntaServiceImpl(PreguntasRepository preguntasRepository, PreguntaMapper preguntaMapper) {
        this.preguntasRepository = preguntasRepository;
        this.preguntaMapper = preguntaMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreguntaDto> obtenerPreguntas() {
        List<Pregunta> preguntas = preguntasRepository.findAll();
        return preguntaMapper.toDto(preguntas);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PreguntaDto> obtenerPreguntasPorId(Long id) {
        return preguntasRepository
                .findById(id)
                .map(preguntaMapper::toDto);
    }

    @Override
    @Transactional
    public PreguntaDto crearPregunta(PreguntaDto preguntaDto) {
        Pregunta pregunta = preguntaMapper.toEntity(preguntaDto);
        pregunta = preguntasRepository.save(pregunta);
        return preguntaMapper.toDto(pregunta);
    }
}
