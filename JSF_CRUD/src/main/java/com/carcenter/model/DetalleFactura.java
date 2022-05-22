package com.carcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="DETALLES_FACTURA")
public class DetalleFactura {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="NUM_DETALLE")
	private long numDetalle;
	@Column (name="IDE_FACTURA")
	private long ideFactura;
	@Column (name="IDE_SERVICIO")
	private long ideServicio;
	@Column (name="IDE_REPUESTO")
	private long ideRepuesto;
	@Column (name="VAL_CANTIDAD")
	private long valCantidad;
	@Column (name="VAL_SUBTOTAL")
	private long valSubtotal;
	
	public long getNumDetalle() {
		return numDetalle;
	}
	public void setNumDetalle(long numDetalle) {
		this.numDetalle = numDetalle;
	}
	public long getIdeFactura() {
		return ideFactura;
	}
	public void setIdeFactura(long ideFactura) {
		this.ideFactura = ideFactura;
	}
	public long getIdeServicio() {
		return ideServicio;
	}
	public void setIdeServicio(long ideServicio) {
		this.ideServicio = ideServicio;
	}
	public long getIdeRepuesto() {
		return ideRepuesto;
	}
	public void setIdeRepuesto(long ideRepuesto) {
		this.ideRepuesto = ideRepuesto;
	}
	public long getValCantidad() {
		return valCantidad;
	}
	public void setValCantidad(long valCantidad) {
		this.valCantidad = valCantidad;
	}
	public long getValSubtotal() {
		return valSubtotal;
	}
	public void setValSubtotal(long valSubtotal) {
		this.valSubtotal = valSubtotal;
	}
	@Override
	public String toString() {
		return "DetalleFactura [numDetalle=" + numDetalle + ", ideFactura=" + ideFactura + ", ideServicio="
				+ ideServicio + ", ideRepuesto=" + ideRepuesto + ", valCantidad=" + valCantidad + ", valSubtotal="
				+ valSubtotal + "]";
	}
}