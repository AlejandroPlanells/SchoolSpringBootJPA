package com.aplanells.school.application.mapper;

import com.aplanells.school.application.dto.AdjuntoDto;
import com.aplanells.school.domain.entity.Adjunto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdjuntoMapper extends EntityMapper<AdjuntoDto, Adjunto> {
}
