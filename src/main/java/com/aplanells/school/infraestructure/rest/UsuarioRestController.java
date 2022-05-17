package com.aplanells.school.infraestructure.rest;

import com.aplanells.school.application.dto.UsuarioDto;
import com.aplanells.school.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioRestController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/usuarios", produces = "application/json")
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios() {
        List<UsuarioDto> usuarioDtos = usuarioService.obtenerUsuarios();
        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/usuarios/{usuarioId}", produces = "application/json")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable Long usuarioId) {
        return usuarioService
                .obtenerUsuarioPorId(usuarioId)
                .map(usuarioDto -> new ResponseEntity(usuarioDto, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

}
