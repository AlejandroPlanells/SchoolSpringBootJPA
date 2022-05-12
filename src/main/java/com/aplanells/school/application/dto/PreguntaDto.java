package com.aplanells.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class PreguntaDto implements Serializable {
    private Long id;
    private String pregunta;
    private String respuesta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaDto that = (PreguntaDto) o;
        return id.equals(that.id) && pregunta.equals(that.pregunta) && respuesta.equals(that.respuesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pregunta, respuesta);
    }

    @Override
    public String toString() {
        return "PreguntaDto{" +
                "id=" + id +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }
}
