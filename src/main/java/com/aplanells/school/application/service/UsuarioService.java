package com.aplanells.school.application.service;

import com.aplanells.school.application.dto.UsuarioDto;
import com.aplanells.school.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioDto> obtenerUsuarios();
    Optional<UsuarioDto> obtenerUsuarioPorId(Long usuarioId);
    Usuario crearUsuario(UsuarioDto usuarioDto);
}
