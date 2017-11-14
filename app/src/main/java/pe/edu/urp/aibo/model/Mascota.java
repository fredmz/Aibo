package pe.edu.urp.aibo.model;


import pe.edu.urp.aibo.model.enumeration.Sexo;
import pe.edu.urp.aibo.model.enumeration.Tamano;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Mascota.
 */
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nombre;
    
    private Integer meses;

    private Tamano tamano;

    private Sexo sexo;
    
    private byte[] foto;
    
    private String fotoContentType;
    
    private Raza raza;
    
    private String dueno;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Mascota nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMeses() {
        return meses;
    }

    public Mascota meses(Integer meses) {
        if (meses <= 0) {
            throw new IllegalArgumentException("Debe ingresar un número mayor a cero");
        }
        this.meses = meses;
        return this;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public Mascota tamano(Tamano tamano) {
        this.tamano = tamano;
        return this;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Mascota sexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public Mascota foto(byte[] foto) {
        this.foto = foto;
        return this;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getFotoContentType() {
        return fotoContentType;
    }

    public Mascota fotoContentType(String fotoContentType) {
        this.fotoContentType = fotoContentType;
        return this;
    }

    public void setFotoContentType(String fotoContentType) {
        this.fotoContentType = fotoContentType;
    }

    public Raza getRaza() {
        return raza;
    }

    public Mascota raza(Raza raza) {
        this.raza = raza;
        return this;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public String getDueno() {
        return dueno;
    }

    public Mascota dueno(String user) {
        this.dueno = user;
        return this;
    }

    public void setDueno(String user) {
        this.dueno = user;
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
        Mascota mascota = (Mascota) o;
        if (mascota.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mascota.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Mascota{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", meses='" + getMeses() + "'" +
            ", tamano='" + getTamano() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", foto='" + getFoto() + "'" +
            ", fotoContentType='" + fotoContentType + "'" +
            "}";
    }

    public String getEdad() {
        if (meses == null) {
            return "No especificado";
        }
        String edad = "";
        if (meses < 12) {
            if (meses == 1) {
                edad = "1 mes";
            } else {
                edad = meses + " meses";
            }
        } else {
            Integer intAnhos = meses / 12;
            Integer intMeses = meses % 12;
            edad = (intAnhos == 1) ? "1 año" : intAnhos + " años";
            if (intMeses > 0) {
                edad += (intMeses == 1) ? "y 1 mes" : " y " + intMeses + " meses";
            }
        }
        return edad;
    }

    // validar que sea entero mayor a cero
    // Devolver la edad: 15 meses debe retornar 1 año y 3 meses
    // Invocar el metodo sin tener datos de la edad

    // validar que se ingreses url de la img y simular que se graba
    // consultar la imagen grabada

    // Fecha de pérdida debe existir y ser menor igual a la fecha actual
}
