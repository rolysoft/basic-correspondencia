package com.correspondencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.correspondencia.model.Correspondencia;

@Repository
public interface CorrespondenciaDAO extends JpaRepository<Correspondencia, Integer> {

}
