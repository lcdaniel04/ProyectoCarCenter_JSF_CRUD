package com.carcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="SERVICIOS")
public class Servicio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="IDE_SERVICIO")
	private long ideServicio;
	@Column (name="NOM_SERVICIO")
	private String nomServicio;
	@Column (name="VR_MANO_OBRA")
	private long valManoObra;
	@Column (name="DESCUENTO")
	private long descuento;
	
	public long getIdeServicio() {
		return ideServicio;
	}
	public void setIdeServicio(long ideServicio) {
		this.ideServicio = ideServicio;
	}
	public String getNomServicio() {
		return nomServicio;
	}
	public void setNomServicio(String nomServicio) {
		this.nomServicio = nomServicio;
	}
	public long getValManoObra() {
		return valManoObra;
	}
	public void setValManoObra(long valManoObra) {
		this.valManoObra = valManoObra;
	}
	public long getDescuento() {
		return descuento;
	}
	public void setDescuento(long descuento) {
		this.descuento = descuento;
	}
	@Override
	public String toString() {
		return "Servicio [ideServicio=" + ideServicio + ", nomServicio=" + nomServicio + ", valManoObra=" + valManoObra
				+ ", descuento=" + descuento + "]";
	}
}