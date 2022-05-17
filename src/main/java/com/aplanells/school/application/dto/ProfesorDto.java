package com.aplanells.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProfesorDto implements Serializable {
    private Long id;
    private String nombre;
    private String numeroTelefono;
    private  UsuarioDto usuario;

    public ProfesorDto() {
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesorDto that = (ProfesorDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(numeroTelefono, that.numeroTelefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, numeroTelefono);
    }

    @Override
    public String toString() {
        return "ProfesorDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                '}';
    }
}
