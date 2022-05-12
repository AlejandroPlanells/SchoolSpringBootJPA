package com.aplanells.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class CursoSimpleDto implements Serializable {
    private Long id;
    private String nombre;

    public CursoSimpleDto() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoSimpleDto that = (CursoSimpleDto) o;
        return id.equals(that.id) && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "CursoSimpleDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
