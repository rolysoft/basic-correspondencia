package com.correspondencia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.correspondencia.dao.CorrespondenciaDAO;
import com.correspondencia.dao.DocumentoDAO;
import com.correspondencia.model.Correspondencia;
import com.correspondencia.model.Documento;


@Service
public class CorrespondenciaService {

	@Autowired 
	private DocumentoDAO documentoDAO;
	
	@Autowired 
	private CorrespondenciaDAO correspoDAO;
	
	public List<Documento> listaDocumentosEnviados(int idUsuario) {
		List<Documento> lstDocumentos = documentoDAO.findAll();
		return (List<Documento>) lstDocumentos.stream().filter(d -> d.getUsuarioRemite().getId() == idUsuario).collect(Collectors.toList());
	}
	
	public List<Documento> listaDocumentosRecibidos(int idUsuario) {
		List<Documento> lstDocumentos = documentoDAO.findAll();
		return (List<Documento>) lstDocumentos.stream().filter(d -> d.getUsuarioRemite().getId() == idUsuario).collect(Collectors.toList());
	}
	
	public void generaDocumento(Documento doc) {
		documentoDAO.save(doc);		
	}
	
	public void updEstado(Documento doc) {
		documentoDAO.save(doc);		
	}
	
	public void deriva(Correspondencia corre) {
		correspoDAO.save(corre);		
	}
	
	
	public List<Correspondencia> corresDerivadaToUser(int idUsuario) {
		List<Correspondencia> lstCorre = correspoDAO.findAll().stream().filter(co -> co.getDestino().getId() == idUsuario).collect(Collectors.toList());
		return lstCorre;
	}
	
	
}
