package com.aplanells.school.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 255)
    private  String nombre;

    @Column(name = "URL", nullable = true, length = 255)
    private String url;

    @ManyToMany
    @JoinTable(
            name = "alumnos_cursos",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private Set<Calificacion> calificaciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "datos_facturacion_id", referencedColumnName = "id")
    private DatosFacturacion datosFacturacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Set<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Set<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public DatosFacturacion getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(DatosFacturacion datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }

    public void eliminarCursoPorId(Long cursoId) {
        if (cursoId == null) return;
        for (Curso curso : this.getCursos()) {
            if (cursoId.equals(curso.getId())) {
                this.cursos.remove(curso);
                break;
            }
        }
    }
}
