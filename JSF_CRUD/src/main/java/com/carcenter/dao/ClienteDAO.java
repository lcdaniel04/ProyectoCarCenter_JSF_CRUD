package com.carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.carcenter.model.Cliente;
import com.carcenter.model.JPAUtil;

public class ClienteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	// Guardar objeto cliente
	public void guardar(Cliente cliente) {
		// Iniciar transacción
		entity.getTransaction().begin();
		// Persistir objeto
		entity.persist(cliente);
		// Terminar transacción
		entity.getTransaction().commit();
		// Cerrar conexión
		//JPAUtil.shutdown();
	}
	
	// Editar objeto cliente
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	// Buscar cliente
	public Cliente buscar(Long ideCliente) {
		Cliente cliente = new Cliente();
		cliente = entity.find(Cliente.class, ideCliente);
		//JPAUtil.shutdown();
		return cliente;
	}
	
	// Obtener todos los clientes
	public List<Cliente> obtenerClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}
	
	// Eliminar cliente
	public void eliminarCliente(Long ideCliente) {
		Cliente cliente = new Cliente();
		cliente = entity.find(Cliente.class, ideCliente);
		entity.getTransaction().begin();
		entity.remove(cliente);
		entity.getTransaction().commit();
	}
}
