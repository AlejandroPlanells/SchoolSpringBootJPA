package com.aplanells.school.application.mapper;

import com.aplanells.school.application.dto.LeccionDto;
import com.aplanells.school.domain.entity.Leccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses =  { CursoMapper.class, ProfesorMapper.class })
public interface LeccionMapper extends EntityMapper<LeccionDto, Leccion>{

    @Override
    @Mapping(source = "cursoId", target = "curso")
    @Mapping(source = "profesorId", target = "profesor")
    Leccion toEntity(LeccionDto dto);

    @Override
    @Mapping(source = "curso.id", target = "cursoId")
    @Mapping(source = "curso.nombre", target = "cursoNombre")
    @Mapping(source = "profesor.id", target = "profesorId")
    @Mapping(source = "profesor.nombre", target = "profesorNombre")
    LeccionDto toDto(Leccion entity);
}
