//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WhatsUPM GT22-8
//  @ File Name : Perfil.java
//  @ Date : 26/05/2018
//  @ Author : 
//
//

package whatsUPM;


import javafx.scene.image.Image;

public class Perfil implements InterfacePerfil {
	private Image foto;
	private Integer idPerfil;
	private String estado;
	private String descripcion;
	private String alias;

	public Perfil(String alias) {
	    this.alias=alias;
	
	}

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void modificarPerfil() {
	
	}
	
	public void visualizarPerfil() {
	
	}
	
	public void destroy() {
	
	}
}
