package com.carcenter.model.vistas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prefactura")
public class Prefactura {
	
	@Id
	@Column(name="IDE_MANTENIMIENTO")
	private Long ideMantenimiento;
	@Column(name="IDE_CLIENTE")
	private Long ideCliente;
	@Column(name="IDE_MECANICO")
	private Long ideMecanico;
	@Column(name="TIPO_DOC_CLIENTE")
	private String tipoDocCliente;
	@Column(name="NUM_DOC_CLIENTE")
	private Long numDocCliente;
	@Column(name="PRIMER_NOMBRE_CLIENTE")
	private String primerNombreCliente;
	@Column(name="SEGUNDO_NOMBRE_CLIENTE")
	private String segundoNombreCliente;
	@Column(name="PRIMER_APELLIDO_CLIENTE")
	private String primerApellidoCliente;
	@Column(name="SEGUNDO_APELLIDO_CLIENTE")
	private String segundoApellidoCliente;
		
	@Column(name="TIPO_DOC_MECANICO")
	private String tipoDocMecanico;
	@Column(name="NUM_DOC_MECANICO")
	private Long numDocMecanico;
	@Column(name="PRIMER_NOMBRE_MECANICO")
	private String primerNombreMecanico;
	@Column(name="SEGUNDO_NOMBRE_MECANICO")
	private String segundoNombreMecanico;
	@Column(name="PRIMER_APELLIDO_MECANICO")
	private String primerApellidoMecanico;
	@Column(name="SEGUNDO_APELLIDO_MECANICO")
	private String segundoApellidoMecanico;
	@Column(name="PRODUCTO")
	private String producto;
	@Column(name="VAL_CANTIDAD_USADA")
	private Integer valCantidadUsada;
	@Column(name="TIPO_PRODUCTO")
	private Integer tipoProducto;
	@Column(name="COD_PRODUCTO")
	private Integer codProducto;
	@Column(name="VALOR")
	private Long valorUnitarioProducto;
	
	
	
	public Long getValorUnitarioProducto() {
		return valorUnitarioProducto;
	}
	public void setValorUnitarioProducto(Long valorUnitarioProducto) {
		this.valorUnitarioProducto = valorUnitarioProducto;
	}
	public Long getNumDocCliente() {
		return numDocCliente;
	}
	public String getPrimerApellidoCliente() {
		return primerApellidoCliente;
	}
	public void setPrimerApellidoCliente(String primerApellidoCliente) {
		this.primerApellidoCliente = primerApellidoCliente;
	}
	public String getSegundoApellidoCliente() {
		return segundoApellidoCliente;
	}
	public void setSegundoApellidoCliente(String segundoApellidoCliente) {
		this.segundoApellidoCliente = segundoApellidoCliente;
	}
	public String getPrimerApellidoMecanico() {
		return primerApellidoMecanico;
	}
	public void setPrimerApellidoMecanico(String primerApellidoMecanico) {
		this.primerApellidoMecanico = primerApellidoMecanico;
	}
	public String getSegundoApellidoMecanico() {
		return segundoApellidoMecanico;
	}
	public void setSegundoApellidoMecanico(String segundoApellidoMecanico) {
		this.segundoApellidoMecanico = segundoApellidoMecanico;
	}
	public void setNumDocCliente(Long numDocCliente) {
		this.numDocCliente = numDocCliente;
	}
	public String getPrimerNombreCliente() {
		return primerNombreCliente;
	}
	public void setPrimerNombreCliente(String primerNombreCliente) {
		this.primerNombreCliente = primerNombreCliente;
	}
	public String getSegundoNombreCliente() {
		return segundoNombreCliente;
	}
	public void setSegundoNombreCliente(String segundoNombreCliente) {
		this.segundoNombreCliente = segundoNombreCliente;
	}
	
	public String getTipoDocCliente() {
		return tipoDocCliente;
	}
	public void setTipoDocCliente(String tipoDocCliente) {
		this.tipoDocCliente = tipoDocCliente;
	}
	public String getTipoDocMecanico() {
		return tipoDocMecanico;
	}
	public void setTipoDocMecanico(String tipoDocMecanico) {
		this.tipoDocMecanico = tipoDocMecanico;
	}
	public Long getNumDocMecanico() {
		return numDocMecanico;
	}
	public void setNumDocMecanico(Long numDocMecanico) {
		this.numDocMecanico = numDocMecanico;
	}
	public String getPrimerNombreMecanico() {
		return primerNombreMecanico;
	}
	public void setPrimerNombreMecanico(String primerNombreMecanico) {
		this.primerNombreMecanico = primerNombreMecanico;
	}
	public String getSegundoNombreMecanico() {
		return segundoNombreMecanico;
	}
	public void setSegundoNombreMecanico(String segundoNombreMecanico) {
		this.segundoNombreMecanico = segundoNombreMecanico;
	}
	public Long getIdeMantenimiento() {
		return ideMantenimiento;
	}
	public void setIdeMantenimiento(Long ideMantenimiento) {
		this.ideMantenimiento = ideMantenimiento;
	}
	public Long getIdeCliente() {
		return ideCliente;
	}
	public void setIdeCliente(Long ideCliente) {
		this.ideCliente = ideCliente;
	}
	public Long getIdeMecanico() {
		return ideMecanico;
	}
	public void setIdeMecanico(Long ideMecanico) {
		this.ideMecanico = ideMecanico;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Integer getValCantidadUsada() {
		return valCantidadUsada;
	}
	public void setValCantidadUsada(Integer valCantidadUsada) {
		this.valCantidadUsada = valCantidadUsada;
	}
	public Integer getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(Integer tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public Integer getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}
	
	

}
