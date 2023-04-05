package com.correspondencia.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.correspondencia.dao.DocumentoDAO;
import com.correspondencia.model.Correspondencia;
import com.correspondencia.model.Documento;
import com.correspondencia.model.Usuario;
import com.correspondencia.service.CorrespondenciaService;
import com.correspondencia.service.UsuarioService;

import lombok.Data;

@Named(value = "correspondenciaController")
@SessionScoped			//ViewScoped
@Data
public class CorrespondenciaController {
	
	@Autowired
	private CorrespondenciaService correspondenciaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	private List<Documento> lstDocumentoGenerado;
	private List<Correspondencia> lstCorreRecibida;
	private List<Usuario> lstDestino;
	private Documento documentoEdit;
	private String idUsuarioDestino;
	
	@PostConstruct
	public void init() {
		System.out.println("Construct Correspondencia");	
		documentoEdit = new Documento();
		documentoEdit.setFechaCreacion(new Date());		
		documentoEdit.setContenido("<p>De mi consideración:</p></br><p>Mediante la presente,...</p></br></br></br></br></br><p>Adios</p>");
	}
	
	
	public void inicio() {
		Usuario usu = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SS_USUARIO");
		
		//Listas
		lstDestino = usuarioService.lstDestino(usu.getId());
				
		//Generado
		lstDocumentoGenerado = correspondenciaService.listaDocumentosEnviados(usu.getId());	
		
		//Recibido
		lstCorreRecibida = correspondenciaService.corresDerivadaToUser(usu.getId());
		
	}
	
	
	public void generarDocumento() {
		System.out.println("generarDocumento()");
		Usuario usu = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SS_USUARIO");
		documentoEdit.setUsuarioRemite(usuarioService.getUsuarioById(usu.getId()));
		documentoEdit.setEstado("GENERADO");
		documentoEdit.setUsuarioDestino(usuarioService.getUsuarioById(Integer.parseInt(idUsuarioDestino)));
		correspondenciaService.generaDocumento(documentoEdit);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Documento Generado."));
	}
	
	
	public void derivarDocumento(Documento doc) {
		System.out.println("derivarDocumento()");
		System.out.println(doc);
		
		Correspondencia corr = new Correspondencia();
		corr.setDestino(doc.getUsuarioDestino());
		corr.setRemitente(doc.getUsuarioRemite());
		corr.setDocumento(doc);
		corr.setFechaDerivacion(new Date());
		corr.setObs("Ok");
		correspondenciaService.deriva(corr);
		
		doc.setEstado("DERIVADO");
		correspondenciaService.updEstado(doc);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Documento Derivado."));
	}
	
	public void nuevoDocumento() {
		documentoEdit = new Documento();
		documentoEdit.setFechaCreacion(new Date());
	}
	public void verDocumento(Documento doc) {
		System.out.println("verDocumento(doc)");
		System.out.println(doc);
		documentoEdit = doc;
	}
	
	
	
	
	
	
	

	

	public List<Documento> getLstDocumentoGenerado() {
		return lstDocumentoGenerado;
	}


	public void setLstDocumentoGenerado(List<Documento> lstDocumentoGenerado) {
		this.lstDocumentoGenerado = lstDocumentoGenerado;
	}


	public List<Correspondencia> getLstCorreRecibida() {
		return lstCorreRecibida;
	}


	public void setLstCorreRecibida(List<Correspondencia> lstCorreRecibida) {
		this.lstCorreRecibida = lstCorreRecibida;
	}


	public Documento getDocumentoEdit() {
		return documentoEdit;
	}

	public void setDocumentoEdit(Documento documentoEdit) {
		this.documentoEdit = documentoEdit;
	}

	public List<Usuario> getLstDestino() {
		return lstDestino;
	}

	public void setLstDestino(List<Usuario> lstDestino) {
		this.lstDestino = lstDestino;
	}


	public String getIdUsuarioDestino() {
		return idUsuarioDestino;
	}


	public void setIdUsuarioDestino(String idUsuarioDestino) {
		this.idUsuarioDestino = idUsuarioDestino;
	}
	
	
	
}
