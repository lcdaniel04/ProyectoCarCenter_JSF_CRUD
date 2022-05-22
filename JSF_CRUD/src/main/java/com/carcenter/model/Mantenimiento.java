package com.carcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "MANTENIMIENTOS")
public class Mantenimiento {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="IDE_MANTENIMIENTO")
	private long ideMantenimiento;
	@Column (name="ESTADO")
	private char estado;
	@Column (name="VALORACION")
	private String valoracion;
	@Column (name="IDE_VEHICULO")
	private String ideVehiculo;
	@Column (name="IDE_MECANICO")
	private long ideMecanico;
	@Column (name="VAL_CANTIDAD_USADA")
	private long valCantidadUsada;
	@Column (name="TIPO_PRODUCTO")
	private int tipoProducto;
	@Column (name="COD_PRODUCTO")
	private int codProducto;
	
	public long getIdeMantenimiento() {
		return ideMantenimiento;
	}
	public void setIdeMantenimiento(long ideMantenimiento) {
		this.ideMantenimiento = ideMantenimiento;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public String getIdeVehiculo() {
		return ideVehiculo;
	}
	public void setIdeVehiculo(String ideVehiculo) {
		this.ideVehiculo = ideVehiculo;
	}
	public long getIdeMecanico() {
		return ideMecanico;
	}
	public void setIdeMecanico(long ideMecanico) {
		this.ideMecanico = ideMecanico;
	}
	@Override
	public String toString() {
		return "Mantenimiento [ideMantenimiento=" + ideMantenimiento + ", estado=" + estado + ", valoracion="
				+ valoracion + ", ideVehiculo=" + ideVehiculo + ", ideMecanico=" + ideMecanico + "]";
	}
	public long getValCantidadUsada() {
		return valCantidadUsada;
	}
	public void setValCantidadUsada(long valCantidadUsada) {
		this.valCantidadUsada = valCantidadUsada;
	}
	public int getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(int tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	
	
}