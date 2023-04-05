package com.correspondencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.correspondencia.model.Documento;

@Repository
public interface DocumentoDAO extends JpaRepository<Documento, Integer> {

}
