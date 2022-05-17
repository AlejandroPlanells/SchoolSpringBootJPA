package com.aplanells.school.application.service.impl;

import com.aplanells.school.application.dto.ProfesorDto;
import com.aplanells.school.application.dto.UsuarioDto;
import com.aplanells.school.application.mapper.ProfesorMapper;
import com.aplanells.school.application.service.ProfesorService;
import com.aplanells.school.application.service.UsuarioService;
import com.aplanells.school.domain.entity.Profesor;
import com.aplanells.school.domain.entity.Usuario;
import com.aplanells.school.domain.type.UserType;
import com.aplanells.school.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;
    private final UsuarioService usuarioService;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper, UsuarioService usuarioService) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
        this.usuarioService = usuarioService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorDto> obtenerProfesores() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesorMapper.toDto(profesores);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProfesorDto> obtenerProfesorPorId(Long profesorId) {
        return profesorRepository
                .findById(profesorId)
                .map(profesor -> profesorMapper.toDto(profesor));
    }

    @Override
    @Transactional
    public ProfesorDto crearProfesor(ProfesorDto profesorDto) {
        Profesor profesor = profesorMapper.toEntity(profesorDto);

        UsuarioDto usuarioDto = profesorDto.getUsuario();
        usuarioDto.setTipoUsuario(UserType.PROFESOR);
        Usuario usuario = usuarioService.crearUsuario(usuarioDto);
        profesor.setUsuario(usuario);

        profesor = profesorRepository.save(profesor);
        return profesorMapper.toDto(profesor);
    }
}
