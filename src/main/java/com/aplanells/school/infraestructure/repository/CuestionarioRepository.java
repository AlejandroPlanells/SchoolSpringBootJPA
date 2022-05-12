package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {
}
