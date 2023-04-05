package com.correspondencia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "correspondencia")
@Data
public class Correspondencia {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@OneToOne
    @JoinColumn(name = "remitente_id")
    private Usuario remitente;
    
    @OneToOne
    @JoinColumn(name = "destino_id")
    private Usuario destino;
    
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_derivacion")
    private Date fechaDerivacion;
    
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_recepcion")
    private Date fechaRecepcion;
    
    @Column(name ="obs", length = 300, nullable = false)
    private String obs;
    
    @OneToOne
    @JoinColumn(name = "documento_id")
    private Documento documento;

    
    
    
    
    
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getRemitente() {
		return remitente;
	}

	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}

	public Usuario getDestino() {
		return destino;
	}

	public void setDestino(Usuario destino) {
		this.destino = destino;
	}

	public Date getFechaDerivacion() {
		return fechaDerivacion;
	}

	public void setFechaDerivacion(Date fechaDerivacion) {
		this.fechaDerivacion = fechaDerivacion;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
    
}
