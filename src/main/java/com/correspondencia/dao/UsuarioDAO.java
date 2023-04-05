package com.correspondencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.correspondencia.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

}
