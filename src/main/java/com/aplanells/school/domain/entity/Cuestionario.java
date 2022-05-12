package com.aplanells.school.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cuestionarios")
public class Cuestionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "nota_minima", nullable = false)
    private Integer notaMinima;

    @OneToMany(mappedBy = "cuestionario", cascade = CascadeType.ALL)
    private Set<PreguntaCuestionario> preguntas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(Integer notaMinima) {
        this.notaMinima = notaMinima;
    }

    public Set<PreguntaCuestionario> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaCuestionario> preguntas) {
        this.preguntas = preguntas;
    }
}
