package com.carcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="VEHICULOS")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="IDE_VEHICULO")
	private String ideVehiculo;
	@Column (name="MARCA")
	private String marca;
	@Column (name="IDE_CLIENTE")
	private long ideCliente;
	
	public String getIdeVehiculo() {
		return ideVehiculo;
	}
	public void setIdeVehiculo(String ideVehiculo) {
		this.ideVehiculo = ideVehiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public long getIdeCliente() {
		return ideCliente;
	}
	public void setIdeCliente(long ideCliente) {
		this.ideCliente = ideCliente;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [ideVehiculo=" + ideVehiculo + ", marca=" + marca + ", ideCliente=" + ideCliente + "]";
	}
}