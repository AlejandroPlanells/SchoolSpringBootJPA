package com.aplanells.school.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "datos_facturacion")
public class DatosFacturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "documento_identificacion", nullable = false, length = 9)
    private String documentoIdentificacion;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Column(name = "pais", nullable = true, length = 100)
    private String pais;

    @OneToOne(mappedBy = "datosFacturacion")
    private Alumno alumno;

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

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
