//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WhatsUPM GT22-8
//  @ File Name : Agenda.java
//  @ Date : 26/05/2018
//  @ Author : 
//
//

package whatsUPM;


import java.util.ArrayList;
import java.util.Date;

public class Agenda implements InterfazAgenda {
	private Boolean esFavorito;
	private Integer idAgenda;
	private String categoria;
	private Date fechaCreacion;
	private ArrayList<Perfil> contactos;
	public Usuario Contiene;
	public Usuario Tiene;
	public Usuario Pertenece;

	public  Agenda(ArrayList<Perfil> listaContactos, String categoria, Integer idAgenda) {
	
	}
	
	public void setFavorito(Boolean favorito) {
	
	}
	
	public void setCategoria(String nombre) {
	
	}
	
	public void setContactos(ArrayList<Perfil> contactos) {
	
	}
	
	public boolean getFavorito() {

	    return true;
	}
	
	public void getId() {
	
	}
	
	public String getCategoria() {
        return null;
	}
	
	public Date getfechaCreacion() {
        return null;
	}
	
	public ArrayList<Perfil> getContactos() {
        return null;
	}
	
	public void modificarAgenda() {

	}
	
	public void seleccionarIntegrantesAgenda() {

	}
	
	public void introducirUsuariosAgenda() {

	}
	
	public void destroy() {
	
	}

    @Override
    public void crearAgenda() {

    }

    @Override
    public void marcarComoFavorito() {

    }

    @Override
    public void cambiarNombreAgenda(String categoria) {

    }

    @Override
    public void modificarIntegrantes() {

    }

    @Override
    public void eliminarAgenda() {

    }
}
