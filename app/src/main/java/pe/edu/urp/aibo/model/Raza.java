package pe.edu.urp.aibo.model;


import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Raza.
 */
public class Raza extends SugarRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Raza nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Raza raza = (Raza) o;
        if (raza.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), raza.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Raza{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            "}";
    }
}
