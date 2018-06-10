package Test;

import javafx.scene.image.Image;
import org.junit.Before;
import org.junit.Test;
import whatsUPM.Perfil;

import static org.junit.Assert.*;

public class PerfilTest {
    private Perfil perfil;

    @Before
    public void setUp() throws Exception {
        perfil = new Perfil("alias");
    }

    @Test
    public void getFoto() {
        Image image =perfil.getFoto();
        perfil.setFoto(image);
        assertEquals(image, perfil.getFoto());
    }

    @Test
    public void setFoto() {
        Image image =perfil.getFoto();
        perfil.setFoto(image);
        assertEquals(image, perfil.getFoto());
    }

    @Test
    public void getIdPerfil() {
        Integer id = 1;
        perfil.setIdPerfil(id);
        assertEquals(id, perfil.getIdPerfil());
    }

    @Test
    public void setIdPerfil() {
        Integer id = 1;
        perfil.setIdPerfil(id);
        assertEquals(id, perfil.getIdPerfil());
    }

    @Test
    public void getEstado() {
        String estado = "estado";
        perfil.setEstado(estado);
        assertEquals(estado, perfil.getEstado());
    }

    @Test
    public void setEstado() {
        String estado = "estado";
        perfil.setEstado(estado);
        assertEquals(estado, perfil.getEstado());
    }

    @Test
    public void getDescripcion() {
        String descripcion = "descripcion";
        perfil.setDescripcion(descripcion);
        assertEquals(descripcion, perfil.getDescripcion());
    }

    @Test
    public void setDescripcion() {
        String descripcion = "descripcion";
        perfil.setDescripcion(descripcion);
        assertEquals(descripcion, perfil.getDescripcion());
    }

    @Test
    public void getAlias() {
        String alias = "alias";
        perfil.setAlias(alias);
        assertEquals(alias, perfil.getAlias());
    }

    @Test
    public void setAlias() {
        String alias = "alias";
        perfil.setAlias(alias);
        assertEquals(alias, perfil.getAlias());
    }
}