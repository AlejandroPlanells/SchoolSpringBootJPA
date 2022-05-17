package com.aplanells.school.application.service.impl;

import com.aplanells.school.application.dto.UsuarioDto;
import com.aplanells.school.application.mapper.UsuarioMapper;
import com.aplanells.school.application.service.UsuarioService;
import com.aplanells.school.domain.entity.Usuario;
import com.aplanells.school.infraestructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDto> obtenerUsuarioPorId(Long usuarioId) {
        return usuarioRepository
                .findById(usuarioId)
                .map(usuario -> usuarioMapper.toDto(usuario));
    }

    @Override
    @Transactional
    public Usuario crearUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }
}
