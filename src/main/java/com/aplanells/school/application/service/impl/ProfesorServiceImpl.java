package com.aplanells.school.application.service.impl;

import com.aplanells.school.application.dto.ProfesorDto;
import com.aplanells.school.application.mapper.ProfesorMapper;
import com.aplanells.school.application.service.ProfesorService;
import com.aplanells.school.domain.entity.Profesor;
import com.aplanells.school.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }

    @Override
    public List<ProfesorDto> obtenerProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesorMapper.toDto(profesores);
    }

    @Override
    public Optional<ProfesorDto> obtenerProfesorPorId(Long profesorId) {
        return profesorRepository
                .findById(profesorId)
                .map(profesor -> profesorMapper.toDto(profesor));
    }

    @Override
    public ProfesorDto crearProfesor(ProfesorDto profesorDto) {
        Profesor profesor = profesorMapper.toEntity(profesorDto);
        profesor = profesorRepository.save(profesor);
        return profesorMapper.toDto(profesor);
    }
}
