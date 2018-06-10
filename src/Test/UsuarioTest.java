package Test;

import org.junit.Before;
import org.junit.Test;
import whatsUPM.Agenda;
import whatsUPM.Chat;
import whatsUPM.Perfil;
import whatsUPM.Usuario;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UsuarioTest {
    Usuario usuario;

    @Before
    public void setUp() throws Exception {
        usuario= new Usuario(1, "Correo", "contrasena");
    }

    @Test
    public void setIdUsuario() {
        usuario.setIdUsuario(2);
        assertEquals((Integer)2, usuario.getIdUsuario());
    }

    @Test
    public void setCorreo() {
        usuario.setCorreo("OtroCorreo");
        assertEquals("OtroCorreo", usuario.getCorreo());
    }

    @Test
    public void setContrasena() {
        usuario.setContrasena("ContraseñaNueva");
        assertEquals("ContraseñaNueva", usuario.getContrasena());
    }

    @Test
    public void setAgendas() {
        ArrayList<Agenda> agendas= usuario.getAgendas();
        assertEquals(agendas, usuario.getAgendas());

    }

    @Test
    public void setPerfil() {
       Perfil p = new Perfil("test2");
        usuario.setPerfil(p);
        assertEquals(p, usuario.getPerfil());

    }

    @Test
    public void setChats() {
        ArrayList<Chat> chats=usuario.getChats();
        usuario.setChats(chats);
        assertEquals(chats, usuario.getChats());
    }

    @Test
    public void getIdUsuario() {
        assertEquals((Integer)1, usuario.getIdUsuario());
    }

    @Test
    public void getCorreo() {
        assertEquals("Correo", usuario.getCorreo());
    }

    @Test
    public void getContrasena() {
        assertEquals("contrasena", usuario.getContrasena());
    }

    @Test
    public void getAgendas() {
        ArrayList<Agenda> agendas= usuario.getAgendas();
        assertEquals(agendas, usuario.getAgendas());

    }

    @Test
    public void getPerfil() {
        Perfil p = new Perfil("test2");
        usuario.setPerfil(p);
        assertEquals(p, usuario.getPerfil());
    }

    @Test
    public void getChats() {
        ArrayList<Chat> chats=usuario.getChats();
        usuario.setChats(chats);
        assertEquals(chats, usuario.getChats());
    }


}