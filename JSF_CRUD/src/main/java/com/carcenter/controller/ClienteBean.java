package com.carcenter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import com.carcenter.dao.ClienteDAO;
import com.carcenter.model.Cliente;

@ManagedBean (name="clienteBean")
@RequestScoped
public class ClienteBean {
	
	private List<Cliente> listaClientes;
	
	// Direcciona nuevo cliente.
	public String nuevoCliente() {
		Cliente unCliente = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", unCliente);
		return "/faces/nuevo.xhtml";
	}
	
	// Permite guardar un cliente.
	public String guardar(Cliente cliente) {
		ClienteDAO clienteDao = new ClienteDAO();
		
		clienteDao.guardar(cliente);
		return "/faces/regClientes.xhtml";
	}
	
	// Permite consultar clientes.
	public List<Cliente> consultarClientes() {
		ClienteDAO clienteDao = new ClienteDAO();
		
		List<Cliente> lc = clienteDao.obtenerClientes();
		
		/*Cliente c1 = new Cliente();
		c1.setIdeCliente(3L);
		c1.setPrimerNombre("Carlos");
		c1.setSegundoNombre("Andres");
		c1.setPrimerApellido("Fernandez");
		c1.setSegundoApellido("Perez");
		c1.setTipoDocumento("CC");
		c1.setNumDocumento(45454545);
		c1.setNumCelular("3115484848");
		c1.setDireccion("Calle 20 #44 21 B/ La Floresta");
		c1.setCorreoElectronico("carlitO21@gmail.com");
		
		Cliente c2 = new Cliente();
		c2.setIdeCliente(4L);
		c2.setPrimerNombre("Jorge");
		c2.setSegundoNombre("Andres");
		c2.setPrimerApellido("Mercado");
		c2.setSegundoApellido("Ruiz");
		c2.setTipoDocumento("CC");
		c2.setNumDocumento(464515151);
		c2.setNumCelular("3125334841");
		c2.setDireccion("Calle 12 #22 34 B/ La Campiña");
		c2.setCorreoElectronico("jorgeMer@gmail.com");
		
		listaClientes.add(c1);
		listaClientes.add(c2);
		
		return listaClientes;*/	
		return lc;
		 
	}
	
	// Permite editar un cliente.
	public String editar(Long ideCliente) {
		ClienteDAO clienteDao = new ClienteDAO();
		Cliente unCliente = new Cliente();
		unCliente = clienteDao.buscar(ideCliente);
		System.out.println(unCliente);
		System.out.println("---- Cliente Actualizado ----");
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", unCliente);
		return "/faces/editar.xhtml";
	}
	
	// Direcciona para actualizar cliente.
	public String actualizar(Cliente cliente) {
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.editar(cliente);
		return "/faces/regClientes.xhtml";
	}
	
	// Eliminar un cliente
	public String eliminar(Long ideCliente) {
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.eliminarCliente(ideCliente);
		System.out.println("---- Cliente Eliminado ----");
		return "/faces/regClientes.xhtml";
	}

	public List<Cliente> getListaClientes() {
		listaClientes=consultarClientes();
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	
}