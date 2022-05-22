package com.carcenter.dao;

import javax.persistence.EntityManager;

import com.carcenter.model.DetalleFactura;
import com.carcenter.model.JPAUtil;

public class DetalleFacturaDAO {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardarRegistro(DetalleFactura detFactura) {
		// Iniciar transacción
		entity.getTransaction().begin();
		// Persistir objeto
		entity.persist(detFactura);
		// Terminar transacción
		entity.getTransaction().commit();
		// Cerrar conexión
		//JPAUtil.shutdown();
	}

}
