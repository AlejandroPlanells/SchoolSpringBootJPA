package com.aplanells.school.infraestructure.repository;

import com.aplanells.school.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
