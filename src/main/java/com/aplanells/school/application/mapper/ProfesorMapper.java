package com.aplanells.school.application.mapper;

import com.aplanells.school.application.dto.ProfesorDto;
import com.aplanells.school.domain.entity.Profesor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfesorMapper extends EntityMapper<ProfesorDto, Profesor> {
    default Profesor fromId(Long id) {
        if (id == null) return null;
        Profesor profesor = new Profesor();
        profesor.setId(id);
        return profesor;
    }
}
