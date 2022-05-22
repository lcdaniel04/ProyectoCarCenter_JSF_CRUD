package com.carcenter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.carcenter.dao.ClienteDAO;
import com.carcenter.dao.DetalleFacturaDAO;
import com.carcenter.dao.FacturaDAO;
import com.carcenter.model.Cliente;
import com.carcenter.model.DetalleFactura;
import com.carcenter.model.Factura;
import com.carcenter.model.vistas.Prefactura;

@ManagedBean (name="facturaBean")
@ViewScoped
public class FacturaBean {
	private List<SelectItem> listaClientes;	
	private List<SelectItem> listaProductosMan;
	
	private Cliente cliente;
	private Long codigoCliente;
	private String tipoDocCliente;
	
	private Long numDocCliente;
	private String primerNombreCliente;
	private String primerApellidoCliente;
	private String tipoDocMecanico;
	private Long numDocMecanico;
	private String primerNombreMecanico;
	private String primerApellidoMecanico;
	private Long subtotal;
	private Double valorIVA;
	private Long totalFactura;
	
	public Long getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(Long subtotal) {
		this.subtotal = subtotal;
	}



	public Double getValorIVA() {
		return valorIVA;
	}



	public void setValorIVA(Double valorIVA) {
		this.valorIVA = valorIVA;
	}



	public Long getTotalFactura() {
		return totalFactura;
	}



	public void setTotalFactura(Long totalFactura) {
		this.totalFactura = totalFactura;
	}



	private List<DetalleFactura> detallesFactura;
	private List<Prefactura> infoPrefactura;
	
	
	
	
	
	
	
	public FacturaBean() {
		cliente = new Cliente();
	}
	
	
	
	// Permite consultar clientes.
	public void buscarCliente() {
		ClienteDAO clienteDao = new ClienteDAO();
		Cliente cliente = clienteDao.buscar(codigoCliente);
	}
	
	
	
	public List<SelectItem> getListaClientes() {
		this.listaClientes = new ArrayList<SelectItem>();
		ClienteBean clienteBean = new ClienteBean();
		List<Cliente> consClientes = clienteBean.consultarClientes();
		
		listaClientes.clear();
		
		for(Cliente cliente : consClientes) {
			SelectItem clienteItem = new SelectItem(cliente.getIdeCliente(),cliente.getNumDocumento()+"-"+cliente.getPrimerNombre()+" "+cliente.getPrimerApellido());
			this.listaClientes.add(clienteItem);
		}
		return listaClientes;
	}
	
	

	public void setListaClientes(List<SelectItem> listaClientes) {
		this.listaClientes = listaClientes;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Long getCodigoCliente() {
		return codigoCliente;
	}


	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}


	public String buscar() {
		FacturaDAO daoFac=new FacturaDAO();
		infoPrefactura=daoFac.cargarDatosPrefactura(codigoCliente);
		if(infoPrefactura!=null && !infoPrefactura.isEmpty()) {
			Prefactura aux=infoPrefactura.get(0);
			setTipoDocCliente(aux.getTipoDocCliente());
			setNumDocCliente(aux.getNumDocCliente());
			setPrimerApellidoCliente(aux.getPrimerApellidoCliente());
			setPrimerNombreCliente(aux.getPrimerNombreCliente());
			setPrimerApellidoMecanico(aux.getPrimerApellidoMecanico());
			setPrimerNombreMecanico(aux.getPrimerNombreMecanico());
			setTipoDocMecanico(aux.getTipoDocMecanico());
			setNumDocMecanico(aux.getNumDocMecanico());
			subtotal=0L;
			for(Prefactura p:infoPrefactura) {
				subtotal=subtotal+(p.getValorUnitarioProducto()*p.getValCantidadUsada());
			}
			valorIVA=subtotal*(0.19);
			totalFactura=valorIVA.longValue()+subtotal;
		}/*fin de if*/
		return null;
	}


	public String getTipoDocCliente() {
		return tipoDocCliente;
	}


	public void setTipoDocCliente(String tipoDocCliente) {
		this.tipoDocCliente = tipoDocCliente;
	}


	public Long getNumDocCliente() {
		return numDocCliente;
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


	public String getPrimerApellidoCliente() {
		return primerApellidoCliente;
	}


	public void setPrimerApellidoCliente(String primerApellidoCliente) {
		this.primerApellidoCliente = primerApellidoCliente;
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


	public String getPrimerApellidoMecanico() {
		return primerApellidoMecanico;
	}


	public void setPrimerApellidoMecanico(String primerApellidoMecanico) {
		this.primerApellidoMecanico = primerApellidoMecanico;
	}



	public List<DetalleFactura> getDetallesFactura() {
		return detallesFactura;
	}



	public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
		this.detallesFactura = detallesFactura;
	}



	public List<Prefactura> getInfoPrefactura() {
		return infoPrefactura;
	}



	public void setInfoPrefactura(List<Prefactura> infoPrefactura) {
		this.infoPrefactura = infoPrefactura;
	}
	
	
	public String guardarFactura() {
		Factura fac=new Factura();
		fac.setFecRegistro(new java.util.Date(System.currentTimeMillis()));
		fac.setIdeCliente(codigoCliente);
		fac.setIdeMantenimiento(infoPrefactura.get(infoPrefactura.size()-1).getIdeMantenimiento());
		fac.setNumFactura("N/A");
		fac.setValTotal(totalFactura);
		fac.setValIVA(valorIVA.longValue());
		fac.setSubTotal(subtotal);
		FacturaDAO daoFac=new FacturaDAO();
		daoFac.guardarFactura(fac);
		fac=daoFac.recuperarUltimaFactura();
		for(Prefactura pre:infoPrefactura) {
			DetalleFactura df=new DetalleFactura();
			df.setIdeFactura(fac.getIdeFactura());
			if(pre.getTipoProducto()==1) {
				df.setIdeServicio(pre.getCodProducto());
				df.setIdeRepuesto(1);
			}else {
				df.setIdeRepuesto(pre.getCodProducto());
				df.setIdeServicio(1);
			}
			df.setValCantidad(pre.getValCantidadUsada());
			df.setValSubtotal(pre.getValCantidadUsada() * pre.getValorUnitarioProducto());
			DetalleFacturaDAO daoDF=new DetalleFacturaDAO();
			daoDF.guardarRegistro(df);
		}
		FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"FACTURA CREADA CORRECTAMENTE.",null);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return null;
	}
	
}
