package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.DatosFacturacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosFacturacionRepository extends JpaRepository<DatosFacturacion, Long> {
}
