package com.aplanells.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class DatosFacturacionDto implements Serializable {
    private Long id;
    private String documentoIdentificacion;
    private String direccion;
    private String pais;
    private AlumnoSimpleDto alumno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public AlumnoSimpleDto getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoSimpleDto alumno) {
        this.alumno = alumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosFacturacionDto that = (DatosFacturacionDto) o;
        return id.equals(that.id) && documentoIdentificacion.equals(that.documentoIdentificacion) && direccion.equals(that.direccion) && Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentoIdentificacion, direccion, pais);
    }

    @Override
    public String toString() {
        return "DatosFacturacionDto{" +
                "id=" + id +
                ", documentoIdentificacion='" + documentoIdentificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
