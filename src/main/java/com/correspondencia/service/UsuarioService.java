package com.correspondencia.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.correspondencia.dao.UsuarioDAO;
import com.correspondencia.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@PostConstruct
	public List<Usuario> getAll() {
        return (List<Usuario>) usuarioDAO.findAll();
    }
	
	public List<Usuario> lstDestino(int idUsuario) {
		List<Usuario> lstUsuarios = (List<Usuario>) usuarioDAO.findAll();
		return (List<Usuario>)lstUsuarios.stream().filter(u -> u.getId()!=idUsuario).collect(Collectors.toList());
	}
	
	public Usuario getUsuarioById(int idUsuario) {
		return usuarioDAO.findById(idUsuario).get();		
	}
}
