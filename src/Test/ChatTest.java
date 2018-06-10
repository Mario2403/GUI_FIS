package Test;

import org.junit.Before;
import org.junit.Test;
import whatsUPM.Chat;
import whatsUPM.Mensaje;
import whatsUPM.Perfil;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ChatTest {
    private Chat chat;

    @Before
    public void setUp() throws Exception {
        chat = new Chat(new ArrayList<Perfil>());
    }

    @Test
    public void getFecha() {
        Date fecha = new Date();
        chat.setFecha(fecha);
        assertEquals(fecha, chat.getFecha());
    }

    @Test
    public void setFecha() {
        Date fecha = new Date();
        chat.setFecha(fecha);
        assertEquals(fecha, chat.getFecha());
    }

    @Test
    public void getIntegrantes() {
        ArrayList<Perfil> integrantes = new ArrayList<>();
        chat.setIntegrantes(integrantes);
        assertEquals(integrantes, chat.getIntegrantes());
    }

    @Test
    public void setIntegrantes() {
        ArrayList<Perfil> integrantes = new ArrayList<>();
        chat.setIntegrantes(integrantes);
        assertEquals(integrantes, chat.getIntegrantes());
    }

    @Test
    public void getMensajes() {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        chat.setMensajes(mensajes);
        assertEquals(mensajes, chat.getMensajes());
    }

    @Test
    public void setMensajes() {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        chat.setMensajes(mensajes);
        assertEquals(mensajes, chat.getMensajes());
    }
}