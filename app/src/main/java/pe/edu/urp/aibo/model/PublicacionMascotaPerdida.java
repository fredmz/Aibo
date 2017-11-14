package pe.edu.urp.aibo.model;


import pe.edu.urp.aibo.model.enumeration.EstadoMascotaPerdida;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A PublicacionMascotaPerdida.
 */
public class PublicacionMascotaPerdida implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date fecha;

    private String lugar;

    private Date fechaEncuentro;

    private EstadoMascotaPerdida estado;

    private String dueno;

    private Distrito distrito;

    private Mascota mascota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public PublicacionMascotaPerdida fecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public void setFecha(Date fecha) {
        Date hoy = new Date();
        if (fecha.after(hoy)) {
            throw new IllegalArgumentException("Debe registrar una fecha menor o igual a la actual");
        }
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public PublicacionMascotaPerdida lugar(String lugar) {
        this.lugar = lugar;
        return this;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaEncuentro() {
        return fechaEncuentro;
    }

    public PublicacionMascotaPerdida fechaEncuentro(Date fechaEncuentro) {
        this.fechaEncuentro = fechaEncuentro;
        return this;
    }

    public void setFechaEncuentro(Date fechaEncuentro) {
        this.fechaEncuentro = fechaEncuentro;
    }

    public EstadoMascotaPerdida getEstado() {
        return estado;
    }

    public PublicacionMascotaPerdida estado(EstadoMascotaPerdida estado) {
        this.estado = estado;
        return this;
    }

    public void setEstado(EstadoMascotaPerdida estado) {
        this.estado = estado;
    }

    public String getDueno() {
        return dueno;
    }

    public PublicacionMascotaPerdida dueno(String user) {
        this.dueno = user;
        return this;
    }

    public void setDueno(String user) {
        this.dueno = user;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public PublicacionMascotaPerdida distrito(Distrito distrito) {
        this.distrito = distrito;
        return this;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public PublicacionMascotaPerdida mascota(Mascota mascota) {
        this.mascota = mascota;
        return this;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PublicacionMascotaPerdida publicacionMascotaPerdida = (PublicacionMascotaPerdida) o;
        if (publicacionMascotaPerdida.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), publicacionMascotaPerdida.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PublicacionMascotaPerdida{" +
            "id=" + getId() +
            ", fecha='" + getFecha() + "'" +
            ", lugar='" + getLugar() + "'" +
            ", fechaEncuentro='" + getFechaEncuentro() + "'" +
            ", estado='" + getEstado() + "'" +
            "}";
    }
}
