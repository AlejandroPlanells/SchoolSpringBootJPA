package com.aplanells.school.application.service.impl;

import com.aplanells.school.application.dto.AlumnoDto;
import com.aplanells.school.application.dto.CalificacionDto;
import com.aplanells.school.application.dto.CursoSimpleDto;
import com.aplanells.school.application.dto.DatosFacturacionDto;
import com.aplanells.school.application.mapper.AlumnoMapper;
import com.aplanells.school.application.mapper.DatosFacturacionMapper;
import com.aplanells.school.application.service.AlumnoService;
import com.aplanells.school.domain.entity.Alumno;
import com.aplanells.school.domain.entity.DatosFacturacion;
import com.aplanells.school.infraestructure.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;
    private final DatosFacturacionMapper datosFacturacionMapper;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper, DatosFacturacionMapper datosFacturacionMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
        this.datosFacturacionMapper = datosFacturacionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlumnoDto> obtenerAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnoMapper.toDto(alumnos);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AlumnoDto> obtenerAlumnoPorId(Long id) {
        return alumnoRepository
                .findById(id)
                .map(alumnoMapper::toDto);
    }

    @Override
    @Transactional
    public AlumnoDto crearAlumno(AlumnoDto alumnoDto) {
        Alumno alumno = alumnoMapper.toEntity(alumnoDto);
        alumno = alumnoRepository.save(alumno);
        return alumnoMapper.toDto(alumno);
    }

    @Override
    public void eliminarAlumnoPorId(Long alumnoId) {
        alumnoRepository.deleteById(alumnoId);
    }

    @Override
    @Transactional
    public List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDto) {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no existe"));
        alumnoDto.getCursos().add(cursoSimpleDto);
        Alumno alumno = alumnoRepository.save(alumnoMapper.toEntity(alumnoDto));
        alumnoDto = alumnoMapper.toDto(alumno);
        return alumnoDto.getCursos();
    }

    @Override
    @Transactional
    public void eliminarCursoDeAlumno(Long alumnoId, Long cursoId) {
        Alumno alumno = alumnoRepository
                .findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumno.eliminarCursoPorId(cursoId);
        alumnoRepository.save(alumno);
    }

    @Override
    @Transactional
    public AlumnoDto anadirCalificacion(Long alumnoId, CalificacionDto calificacionDto) {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumnoDto.getCalificaciones().add(calificacionDto);
        Alumno alumno = alumnoMapper.toEntity(alumnoDto);
        alumno = alumnoRepository.save(alumno);
        return alumnoMapper.toDto(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DatosFacturacionDto> obtenerDatosFacturacionPorId(Long alumnoId) {
        return obtenerAlumnoPorId(alumnoId)
                .map(alumnoDto -> alumnoDto.getDatosFacturacion());
    }

    @Override
    @Transactional
    public DatosFacturacionDto actualizarDatosFacturacion(Long alumnoId, DatosFacturacionDto datosFacturacionDto) {
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        DatosFacturacion datosFacturacion = datosFacturacionMapper.toEntity(datosFacturacionDto);
        alumno.setDatosFacturacion(datosFacturacion);
        alumno = alumnoRepository.save(alumno);
        return alumnoMapper.toDto(alumno).getDatosFacturacion();
    }
}
