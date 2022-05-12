package com.aplanells.school.application.service.impl;

import com.aplanells.school.application.dto.AdjuntoDto;
import com.aplanells.school.application.mapper.AdjuntoMapper;
import com.aplanells.school.application.service.AdjuntoService;
import com.aplanells.school.domain.entity.Adjunto;
import com.aplanells.school.infraestructure.repository.AdjuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdjuntoServiceImpl implements AdjuntoService {

    private final AdjuntoRepository adjuntoRepository;
    private final AdjuntoMapper adjuntoMapper;

    @Autowired
    public AdjuntoServiceImpl(AdjuntoRepository adjuntoRepository, AdjuntoMapper adjuntoMapper) {
        this.adjuntoRepository = adjuntoRepository;
        this.adjuntoMapper = adjuntoMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<AdjuntoDto> obtenerAdjuntos() {
        List<Adjunto> adjuntos = adjuntoRepository.findAll();
        return adjuntoMapper.toDto(adjuntos);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AdjuntoDto> obtenerAdjuntoPorId(Long id) {
        return adjuntoRepository
                .findById(id)
                .map(adjuntoMapper::toDto);
    }

    @Override
    @Transactional
    public AdjuntoDto crearAdjunto(AdjuntoDto adjuntoDto) {
        Adjunto adjunto = adjuntoMapper.toEntity(adjuntoDto);
        adjunto = adjuntoRepository.save(adjunto);
        return adjuntoMapper.toDto(adjunto);
    }
}
