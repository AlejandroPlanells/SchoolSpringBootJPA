package com.aplanells.school.application.mapper;

import com.aplanells.school.application.dto.PreguntaDto;
import com.aplanells.school.domain.entity.Pregunta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreguntaMapper extends EntityMapper<PreguntaDto, Pregunta>{

    default Pregunta fromId(Long id) {
        if (id == null) return null;
        Pregunta pregunta = new Pregunta();
        pregunta.setId(id);
        return pregunta;
    }

}
