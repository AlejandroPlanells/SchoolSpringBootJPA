package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
