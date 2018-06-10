package Test;

import javafx.scene.image.Image;
import org.junit.Before;
import org.junit.Test;
import whatsUPM.ChatGrupal;
import whatsUPM.Perfil;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChatGrupalTest {

    ChatGrupal chatGrupal;

    @Before
    public void setUp() throws Exception {

        ArrayList<Perfil> contactos = new ArrayList<Perfil>();
        contactos.add(new Perfil("Test1"));
        contactos.add(new Perfil("Test2"));
        contactos.add(new Perfil("Test3"));
        chatGrupal = new ChatGrupal(contactos);


    }

    @Test
    public void setImagen() {
        Image imagen =chatGrupal.getImagen();
        chatGrupal.setImagen(imagen);
        assertEquals(imagen, chatGrupal.getImagen());
    }

    @Test
    public void setNombre() {
        chatGrupal.setNombre("Test1");
        assertEquals("Test1", chatGrupal.getNombre());
    }

    @Test
    public void introducirNombreImagenGrupo() {
        Image imagen = chatGrupal.getImagen();
        String nombre = "Test1";
        chatGrupal.introducirNombreImagenGrupo(nombre, imagen);

        assertEquals(imagen, chatGrupal.getImagen());
        assertEquals(nombre, chatGrupal.getNombre());

    }

    @Test
    public void getImagen() {
        Image image = chatGrupal.getImagen();
        chatGrupal.setImagen(image);
        assertEquals(image, chatGrupal.getImagen());

    }

    @Test
    public void getNombre() {
        chatGrupal.setNombre("Test1");
        assertEquals("Test1", chatGrupal.getNombre());
    }
}