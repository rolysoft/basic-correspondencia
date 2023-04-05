package com.correspondencia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "documento")
@Data
public class Documento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name ="tipo", length = 100, nullable = false)
    private String tipo;
    
    @Column(name ="codigo", length = 100, nullable = false)
    private String codigo;
    
    @Column(name ="referencia", length = 100, nullable = false)
    private String referencia;
    
    @Column(name ="contenido", length = 10000, nullable = false)
    private String contenido;
    
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_creacion")
    private Date fechaCreacion;
    
    @ManyToOne
    @JoinColumn(name = "usuarioremite_id")
    private Usuario usuarioRemite;
    
    @OneToOne
    @JoinColumn(name = "usuariodestino_id")
    private Usuario usuarioDestino;

    @Column(name ="estado", length = 100, nullable = false)
    private String estado;
    
    
    
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuarioRemite() {
		return usuarioRemite;
	}

	public void setUsuarioRemite(Usuario usuarioRemite) {
		this.usuarioRemite = usuarioRemite;
	}

	public Usuario getUsuarioDestino() {
		return usuarioDestino;
	}

	public void setUsuarioDestino(Usuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
       
    
}
