-- 5.	Consulta de Clientes que han comprado un acumulado $100.000 en los últimos 60 días
select cli.NUM_DOCUMENTO, cli.PRIMER_NOMBRE, cli.PRIMER_APELLIDO
from carcenter_bd.clientes cli, carcenter_bd.facturas fac
where cli.IDE_CLIENTE = fac.IDE_CLIENTE and fac.FEC_REGISTRO between DATE_ADD(NOW(),INTERVAL -60 DAY) and sysdate()
having sum(fac.VR_TOTAL)=100000;

-- 6.	Consulta de los 100 productos más vendidos en los últimos 30 días
select rep.IDE_REPUESTO, rep.NOM_REPUESTO
from carcenter_bd.repuestos rep, carcenter_bd.detalles_factura det, carcenter_bd.facturas fac
where rep.IDE_REPUESTO = det.IDE_REPUESTO and det.IDE_FACTURA = fac.IDE_FACTURA
 and fac.FEC_REGISTRO between DATE_ADD(NOW(),INTERVAL -30 DAY) and sysdate()
having sum(det.VAL_CANTIDAD);

-- 8.	Consulta de todos los clientes que han tenido más de un(1) mantenimento en los últimos 30 días.
select cli.NUM_DOCUMENTO,cli.PRIMER_NOMBRE,cli.PRIMER_APELLIDO,count(man.IDE_MANTENIMIENTO) CANTIDAD
from carcenter_bd.clientes cli, carcenter_bd.facturas fac, carcenter_bd.mantenimientos man
where cli.IDE_CLIENTE = fac.IDE_CLIENTE and fac.IDE_MANTENIMIENTO = man.IDE_MANTENIMIENTO
and fac.FEC_REGISTRO between DATE_ADD(NOW(),INTERVAL -30 DAY) and sysdate()
having count(man.IDE_MANTENIMIENTO)>1;
