package com.carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.carcenter.model.Factura;
import com.carcenter.model.JPAUtil;
import com.carcenter.model.vistas.Prefactura;

public class FacturaDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	// Obtener todos los clientes
	public List<Prefactura> cargarDatosPrefactura(Long ideCliente) {
		String sql="SELECT * FROM prefactura WHERE IDE_CLIENTE="+ideCliente;
		List<Prefactura> listaObjetos = new ArrayList<Prefactura>();
		Query q = entity.createNativeQuery(sql,Prefactura.class);
		listaObjetos = q.getResultList();
		return listaObjetos;
	}
	
	public Factura recuperarUltimaFactura() {
		String sql="SELECT * FROM facturas WHERE IDE_FACTURA IN(SELECT MAX(IDE_FACTURA) FROM facturas)";
		Factura fac = new Factura();
		Query q = entity.createNativeQuery(sql,Factura.class);
		fac = (Factura) q.getSingleResult();
		return fac;
	}
	
	// Guardar objeto cliente
	public void guardarFactura(Factura datosFactura) {
		// Iniciar transacción
		entity.getTransaction().begin();
		// Persistir objeto
		entity.persist(datosFactura);
		// Terminar transacción
		entity.getTransaction().commit();
		// Cerrar conexión
		//JPAUtil.shutdown();
	}
}