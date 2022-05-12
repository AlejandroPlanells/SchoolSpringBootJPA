package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasRepository extends JpaRepository<Pregunta, Long> {
}
