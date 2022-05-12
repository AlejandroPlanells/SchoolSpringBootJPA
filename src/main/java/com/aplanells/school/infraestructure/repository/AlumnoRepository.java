package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
