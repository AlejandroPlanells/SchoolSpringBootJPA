package com.aplanells.school.application.mapper;

import com.aplanells.school.application.dto.DatosFacturacionDto;
import com.aplanells.school.domain.entity.DatosFacturacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { AlumnoMapper.class })
public interface DatosFacturacionMapper extends EntityMapper<DatosFacturacionDto, DatosFacturacion>{

    default DatosFacturacion fromId(Long id) {
        if (id == null) return null;
        DatosFacturacion datosFacturacion = new DatosFacturacion();
        datosFacturacion.setId(id);
        return datosFacturacion;
    }

}
