package com.aplanells.school.application.mapper;

import com.aplanells.school.application.dto.UsuarioDto;
import com.aplanells.school.domain.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario> {
}
