package pe.edu.urp.aibo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MascotaTest {
    @Test
    public void getEdadDe15meses() throws Exception {
        Mascota mascota = new Mascota();
        mascota.meses(15);

        String valor = "1 año y 3 meses";

        assertEquals(valor, mascota.getEdad());
    }

    @Test
    public void getEdadNoEspecificado() throws Exception {
        Mascota mascota = new Mascota();

        String valor = "No especificado";

        assertEquals(valor, mascota.getEdad());
    }

    @Test
    public void getEdadDe12meses() throws Exception {
        Mascota mascota = new Mascota();
        mascota.meses(12);

        String valor = "1 año";

        assertEquals(valor, mascota.getEdad());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setEdadValor0ShouldThroughtException() throws Exception {
        Mascota mascota = new Mascota();
        mascota.meses(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setEdadValorNegativoShouldThroughtException() throws Exception {
        Mascota mascota = new Mascota();
        mascota.meses(-1);
    }
}