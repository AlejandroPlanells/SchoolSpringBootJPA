package com.aplanells.school.domain.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//Indica que se puede utilizar dentro de las entidades.
@Embeddable
public class PreguntaCuestionarioKey implements Serializable {

    private static final long serialVersionUID = 7468266628905861318L;
    @Column(name = "cuestionario_id")
    private Long cuestionarioId;

    @Column(name = "pregunta_id")
    private Long preguntaId;

    public PreguntaCuestionarioKey() {
    }

    public Long getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Long cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaCuestionarioKey that = (PreguntaCuestionarioKey) o;
        return cuestionarioId.equals(that.cuestionarioId) && preguntaId.equals(that.preguntaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuestionarioId, preguntaId);
    }
}
