package Test;

import org.junit.Before;
import org.junit.Test;
import whatsUPM.Mensaje;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class MensajeTest {
    private Mensaje mensaje;

    @Before
    public void setUp() throws Exception {
        mensaje = new Mensaje("HolaTest", "1");
    }

    @Test
    public void getTexto() {
        assertEquals(String.class, mensaje.getTexto().getClass() );
    }

    @Test
    public void setTexto() {

        mensaje.setTexto("Hola!");
        assertEquals( "Hola!", mensaje.getTexto());

    }

    @Test
    public void getUsuarioOrigen() {
        mensaje.setUsuarioOrigen(1);
        assertEquals((Integer)1, mensaje.getUsuarioOrigen());
    }

    @Test
    public void setUsuarioOrigen() {
        mensaje.setUsuarioOrigen(2);
        assertEquals((Integer)2, mensaje.getUsuarioOrigen());
    }

    @Test
    public void getFecha() {
        Date now = new Date();
        mensaje.setFecha(new Date());

        assertEquals(now,mensaje.getFecha());
    }

    @Test
    public void setFecha() {
        Date fecha = new Date(System.currentTimeMillis());
        mensaje.setFecha(fecha);
        assertEquals(System.currentTimeMillis(),fecha.getTime());

    }

    @Test
    public void getEsRecibido() {

        assertEquals(false, mensaje.getEsRecibido());

    }

    @Test
    public void setEsRecibido() {
        mensaje.setEsRecibido(true);
        assertEquals(true, mensaje.getEsRecibido());
    }

    @Test
    public void getEsVisto() {
        assertEquals(false, mensaje.getEsRecibido());
    }

    @Test
    public void setEsVisto() {
        mensaje.setEsVisto(true);
        assertEquals(true, mensaje.getEsVisto());

    }

    @Test
    public void marcarComoRecibido() {
        mensaje.marcarComoRecibido();
        assertTrue( mensaje.getEsRecibido());
    }

    @Test
    public void marcarComoLeido() {
        mensaje.marcarComoLeido();
        assertTrue(mensaje.getEsVisto());
    }
}