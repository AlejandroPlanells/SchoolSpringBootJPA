package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
