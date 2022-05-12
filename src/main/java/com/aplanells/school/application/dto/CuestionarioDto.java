package com.aplanells.school.application.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CuestionarioDto implements Serializable {
    private Long id;
    private String titulo;
    private Integer notaMinima;
    private List<PreguntaCuestionarioDto> preguntas;

    public CuestionarioDto() {
    }

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

    public List<PreguntaCuestionarioDto> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaCuestionarioDto> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuestionarioDto that = (CuestionarioDto) o;
        return id.equals(that.id) && titulo.equals(that.titulo) && notaMinima.equals(that.notaMinima);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, notaMinima);
    }

    @Override
    public String toString() {
        return "CuestionarioDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", notaMinima=" + notaMinima +
                '}';
    }
}
