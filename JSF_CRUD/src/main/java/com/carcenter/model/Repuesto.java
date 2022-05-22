package com.carcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="REPUESTOS")
public class Repuesto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="IDE_REPUESTO")
	private long ideRepuesto;
	@Column (name="NOM_REPUESTO")
	private String nomRepuesto;
	@Column (name="PRECIO_UNIDAD")
	private long precioUnidad;
	@Column (name="NUM_UNIDAD")
	private long numUnidad;
	@Column (name="DESCUENTO")
	private long descuento;
	
	public long getIdeRepuesto() {
		return ideRepuesto;
	}
	public void setIdeRepuesto(long ideRepuesto) {
		this.ideRepuesto = ideRepuesto;
	}
	public String getNomRepuesto() {
		return nomRepuesto;
	}
	public void setNomRepuesto(String nomRepuesto) {
		this.nomRepuesto = nomRepuesto;
	}
	public long getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(long precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public long getNumUnidad() {
		return numUnidad;
	}
	public void setNumUnidad(long numUnidad) {
		this.numUnidad = numUnidad;
	}
	public long getDescuento() {
		return descuento;
	}
	public void setDescuento(long descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public String toString() {
		return "Repuesto [ideRepuesto=" + ideRepuesto + ", nomRepuesto=" + nomRepuesto + ", precioUnidad="
				+ precioUnidad + ", numUnidad=" + numUnidad + ", descuento=" + descuento + "]";
	}
}