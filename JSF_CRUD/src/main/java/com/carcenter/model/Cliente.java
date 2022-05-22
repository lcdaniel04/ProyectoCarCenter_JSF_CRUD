package com.carcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="IDE_CLIENTE")
	private Long ideCliente;
	@Column (name="PRIMER_NOMBRE")
	private String primerNombre;
	@Column (name="SEGUNDO_NOMBRE")
	private String segundoNombre;
	@Column (name="PRIMER_APELLIDO")
	private String primerApellido;
	@Column (name="SEGUNDO_APELLIDO")
	private String segundoApellido;
	@Column (name="TIPO_DOCUMENTO")
	private String tipoDocumento;
	@Column (name="NUM_DOCUMENTO")
	private Integer numDocumento;
	@Column (name="NUM_CELULAR")
	private String numCelular;
	@Column (name="DIRECCION")
	private String direccion;
	@Column (name="CORREO_ELECTRONICO")
	private String correoElectronico;
	
	public Long getIdeCliente() {
		return ideCliente;
	}
	public void setIdeCliente(Long ideCliente) {
		this.ideCliente = ideCliente;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}
	public String getNumCelular() {
		return numCelular;
	}
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + ideCliente + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", tipoDocumento="
				+ tipoDocumento + ", numDocumento=" + numDocumento + ", numCelular=" + numCelular + ", direccion="
				+ direccion + ", correoElectronico=" + correoElectronico + "]";
	}
}
