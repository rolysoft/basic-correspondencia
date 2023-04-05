package com.correspondencia.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.correspondencia.model.Documento;
import com.correspondencia.model.Usuario;
import com.correspondencia.service.UsuarioService;

import lombok.Data;

@Named(value = "loginController")
@SessionScoped //@ViewScoped
@Data
public class LoginController {
	
	private String usuario;
	private Usuario us;
	private Documento doc;
	private String password;
	private List<Usuario> lstUsuario;
    
	@Autowired
	UsuarioService usuarioService;
	
    @PostConstruct
    public void init() {
    	System.out.println("Construct LoginController");
    	lstUsuario = usuarioService.getAll();        
        //usuario = new Usuario();
    }
    
    public void hello() {
    	//doc.
        System.out.println("Hola: " + usuario);        
        System.out.println("Total: ");
        System.out.println(lstUsuario.size());
    }
    
    public String login() {
    	System.out.println("Login");
    	List<Usuario> lstExiste = lstUsuario.stream().filter(u -> u.getUsuario().equals(usuario)).collect(Collectors.toList());
    	if(lstExiste.size()==0) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario incorrecto."));
    		return null;
    	} else {   		
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SS_USUARIO", lstExiste.get(0));            
    	}
    	return "/bandeja.xhtml?faces-redirect=true";
	}
    
    public String logout() {
    	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("SS_USUARIO");
    	return "/index.xhtml?faces-redirect=true";
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    

	
}
