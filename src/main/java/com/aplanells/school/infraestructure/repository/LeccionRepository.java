package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeccionRepository extends JpaRepository<Leccion, Long> {
    List<Leccion> findByCurso_Id(Long cursoId);

    Optional<Leccion> findOneByIdAndCurso_Id(Long leccionId, Long cursoId);
}
