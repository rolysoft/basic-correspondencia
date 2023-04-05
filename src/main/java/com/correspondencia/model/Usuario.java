package com.correspondencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ok
 *
 */
@Entity
@Table(name = "seg_usuario")
@Getter
@Setter
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name ="usuario", length = 100, nullable = false)
    private String usuario;
    
    @Column(name ="password", length = 100, nullable = false)
    private String password;
    
    @Column(name ="nombre_completo", length = 100, nullable = false)
    private String nombreCompleto;

     
    
}
