package com.aplanells.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class PreguntaCuestionarioDto implements Serializable {
    private Long cuestionarioId;
    private String cuestionarioTitulo;
    private Long preguntaId;
    private String preguntaPregunta;
    private Integer orden;

    public PreguntaCuestionarioDto() {
    }

    public Long getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Long cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    public String getCuestionarioTitulo() {
        return cuestionarioTitulo;
    }

    public void setCuestionarioTitulo(String cuestionarioTitulo) {
        this.cuestionarioTitulo = cuestionarioTitulo;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getPreguntaPregunta() {
        return preguntaPregunta;
    }

    public void setPreguntaPregunta(String preguntaPregunta) {
        this.preguntaPregunta = preguntaPregunta;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaCuestionarioDto that = (PreguntaCuestionarioDto) o;
        return cuestionarioId.equals(that.cuestionarioId) && cuestionarioTitulo.equals(that.cuestionarioTitulo) && preguntaId.equals(that.preguntaId) && preguntaPregunta.equals(that.preguntaPregunta) && orden.equals(that.orden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuestionarioId, cuestionarioTitulo, preguntaId, preguntaPregunta, orden);
    }

    @Override
    public String toString() {
        return "PreguntaCuestionarioDto{" +
                "cuestionarioId=" + cuestionarioId +
                ", cuestionarioTitulo='" + cuestionarioTitulo + '\'' +
                ", preguntaId=" + preguntaId +
                ", preguntaPregunta='" + preguntaPregunta + '\'' +
                ", orden=" + orden +
                '}';
    }
}
