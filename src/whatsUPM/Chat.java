//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WhatsUPM GT22-8
//  @ File Name : Chat.java
//  @ Date : 26/05/2018
//  @ Author : 
//
//



package whatsUPM;

import java.util.ArrayList;
import java.util.Date;

public class Chat implements InterfaceChat {
	private Date fecha;
	private ArrayList<Perfil> integrantes;
	private ArrayList<Mensaje> mensajes;
	public Usuario Pertenece;

	public Chat() {
	
	}
	
	public void setFecha(Date fecha) {
	
	}
	
	public void setMensajes(ArrayList<Mensaje> mensajes) {
	
	}
	
	public void setIntegrantes(ArrayList<Perfil> integrantes) {
	
	}
	
	public Date getFecha() {

	return null;
	}
	
	public ArrayList<Mensaje> getMensajes() {
        return null;
	}
	
	public ArrayList<Perfil> getIntegrantes() {
        return null;
	}
	
	public boolean enviarMensaje() {

        return true;
	}
	
	public void destroy() {
	
	}

    @Override
    public void enviarMensaje(Mensaje mensaje) {

    }

    @Override
    public void listarMensajes() {

    }

    @Override
    public void visualizarIntegrantes() {

    }

    @Override
    public void anadirIntegrantes() {

    }

    @Override
    public void modificarChat() {

    }

    @Override
    public void eliminarMensaje() {

    }
}