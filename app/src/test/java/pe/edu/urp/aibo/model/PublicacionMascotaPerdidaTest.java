package pe.edu.urp.aibo.model;

import org.junit.Test;
import pe.edu.urp.aibo.model.enumeration.EstadoMascotaPerdida;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class PublicacionMascotaPerdidaTest {
    @Test(expected = IllegalArgumentException.class)
    public void setFechaMayorAhoyThrowException() throws Exception {
        PublicacionMascotaPerdida publicacionMascotaPerdida = new PublicacionMascotaPerdida();
        Date manana = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(manana);
        c.add(Calendar.DATE, 1);
        manana = c.getTime();
        publicacionMascotaPerdida.setFecha(manana);
    }

    @Test
    public void setFechaDehoy() throws Exception {
        PublicacionMascotaPerdida publicacionMascotaPerdida = new PublicacionMascotaPerdida();
        Date manana = new Date();
        publicacionMascotaPerdida.setFecha(manana);
    }

    @Test
    public void setFechaMenorAhoy() throws Exception {
        PublicacionMascotaPerdida publicacionMascotaPerdida = new PublicacionMascotaPerdida();
        Date manana = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(manana);
        c.add(Calendar.DATE, -1);
        manana = c.getTime();
        publicacionMascotaPerdida.setFecha(manana);
    }

    @Test()
    public void cerrarCasoExitosoFechaEncuentroIsComplete() throws Exception {
        PublicacionMascotaPerdida publicacionMascotaPerdida = new PublicacionMascotaPerdida();
        publicacionMascotaPerdida.cerrarCasoExistoso();

        assertNotNull(publicacionMascotaPerdida.getFechaEncuentro());
    }

    @Test(expected = RuntimeException.class)
    public void cerrarCasoExitosoCerradoShouldThrowException() throws Exception {
        PublicacionMascotaPerdida publicacionMascotaPerdida = new PublicacionMascotaPerdida();
        publicacionMascotaPerdida.setEstado(EstadoMascotaPerdida.ENCONTRADA);

        publicacionMascotaPerdida.cerrarCasoExistoso();
    }
}