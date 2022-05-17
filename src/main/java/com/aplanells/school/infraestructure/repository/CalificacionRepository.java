package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

    List<Calificacion> findByAlumno_id(Long alumnoId);

    Optional<Calificacion> findOneByIdAndAlumno_id(Long calificacionId, Long alumnoId);
}
