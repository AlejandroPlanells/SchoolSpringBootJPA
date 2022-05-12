package com.aplanells.school.application.mapper;

import com.aplanells.school.application.dto.PreguntaCuestionarioDto;
import com.aplanells.school.domain.entity.Cuestionario;
import com.aplanells.school.domain.entity.PreguntaCuestionario;
import com.aplanells.school.domain.key.PreguntaCuestionarioKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CuestionarioMapper.class, PreguntaMapper.class })
public interface PreguntaCuestionarioMapper extends EntityMapper<PreguntaCuestionarioDto, PreguntaCuestionario>{

    @Override
    @Mapping(source = "cuestionarioId", target = "cuestionario")
    @Mapping(source = "cuestionarioId", target = "id.cuestionarioId")
    @Mapping(source = "preguntaId", target = "pregunta")
    @Mapping(source = "preguntaId", target = "id.preguntaId")
    PreguntaCuestionario toEntity(PreguntaCuestionarioDto dto);

    @Override
    @Mapping(source = "cuestionario.id",target = "cuestionarioId")
    @Mapping(source = "cuestionario.titulo",target = "cuestionarioTitulo")
    @Mapping(source = "pregunta.id",target = "preguntaId")
    @Mapping(source = "pregunta.pregunta",target = "preguntaPregunta")
    PreguntaCuestionarioDto toDto(PreguntaCuestionario entity);

    default PreguntaCuestionario fromId(PreguntaCuestionarioKey id) {
        if (id == null) return null;
        PreguntaCuestionario preguntaCuestionario = new PreguntaCuestionario();
        preguntaCuestionario.setId(id);
        return preguntaCuestionario;
    }
}
