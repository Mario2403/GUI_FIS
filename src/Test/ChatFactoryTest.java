package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import whatsUPM.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChatFactoryTest {

    private ChatFactory chatFactory;

    @Before
    public void setUp() throws Exception {
        chatFactory = new ChatFactory();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateChatIndividual() {

        ArrayList<Perfil> contactos = new ArrayList<>();
        contactos.add(new Perfil("Test1"));


        Chat chat = chatFactory.createChat(contactos);
        assertEquals(chat.getClass(), ChatIndividual.class);
    }


    @Test
    public void testCreateChatGrupal() {

        ArrayList<Perfil> contactos = new ArrayList<>();
        contactos.add(new Perfil("Test1"));
        contactos.add(new Perfil("Test2"));
        contactos.add(new Perfil("Test3"));
        contactos.add(new Perfil("Test4"));
        contactos.add(new Perfil("Test5"));

        Chat chat = chatFactory.createChat(contactos);
        assertEquals(chat.getClass(), ChatGrupal.class);
    }
}