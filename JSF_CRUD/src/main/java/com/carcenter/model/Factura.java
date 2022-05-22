package com.carcenter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name ="FACTURAS")
public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="IDE_FACTURA")
	private long ideFactura;
	@Column (name="NUM_FACTURA")
	private String numFactura;
	@Column (name="IDE_CLIENTE")
	private long ideCliente;
	@Column (name="IDE_MANTENIMIENTO")
	private long ideMantenimiento;
	@Column (name="VR_TOTAL")
	private long valTotal;
	@Column (name="FEC_REGISTRO")
	private Date fecRegistro;
	@Column (name="SUBTOTAL")
	private long subTotal;
	@Column (name="VAL_IVA")
	private long valIVA;
	
	public long getIdeFactura() {
		return ideFactura;
	}
	public void setIdeFactura(long ideFactura) {
		this.ideFactura = ideFactura;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public long getIdeCliente() {
		return ideCliente;
	}
	public void setIdeCliente(long ideCliente) {
		this.ideCliente = ideCliente;
	}
	public long getIdeMantenimiento() {
		return ideMantenimiento;
	}
	public void setIdeMantenimiento(long ideMantenimiento) {
		this.ideMantenimiento = ideMantenimiento;
	}
	public long getValTotal() {
		return valTotal;
	}
	public void setValTotal(long valTotal) {
		this.valTotal = valTotal;
	}
	public Date getFecRegistro() {
		return fecRegistro;
	}
	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
	
	
	
	public long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(long subTotal) {
		this.subTotal = subTotal;
	}
	public long getValIVA() {
		return valIVA;
	}
	public void setValIVA(long valIVA) {
		this.valIVA = valIVA;
	}
	@Override
	public String toString() {
		return "Factura [ideFactura=" + ideFactura + ", numFactura=" + numFactura + ", ideCliente=" + ideCliente
				+ ", ideMantenimiento=" + ideMantenimiento + ", valTotal=" + valTotal + ", fecRegistro=" + fecRegistro
				+ "]";
	}
}