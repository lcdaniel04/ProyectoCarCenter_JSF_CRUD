-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: carcenter_bd
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `prefactura`
--

DROP TABLE IF EXISTS `prefactura`;
/*!50001 DROP VIEW IF EXISTS `prefactura`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prefactura` AS SELECT 
 1 AS `TIPO_DOC_CLIENTE`,
 1 AS `NUM_DOC_CLIENTE`,
 1 AS `PRIMER_NOMBRE_CLIENTE`,
 1 AS `SEGUNDO_NOMBRE_CLIENTE`,
 1 AS `PRIMER_APELLIDO_CLIENTE`,
 1 AS `SEGUNDO_APELLIDO_CLIENTE`,
 1 AS `TIPO_DOC_MECANICO`,
 1 AS `NUM_DOC_MECANICO`,
 1 AS `PRIMER_NOMBRE_MECANICO`,
 1 AS `SEGUNDO_NOMBRE_MECANICO`,
 1 AS `PRIMER_APELLIDO_MECANICO`,
 1 AS `SEGUNDO_APELLIDO_MECANICO`,
 1 AS `IDE_MANTENIMIENTO`,
 1 AS `IDE_CLIENTE`,
 1 AS `IDE_MECANICO`,
 1 AS `PRODUCTO`,
 1 AS `VAL_CANTIDAD_USADA`,
 1 AS `TIPO_PRODUCTO`,
 1 AS `COD_PRODUCTO`,
 1 AS `VALOR`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `prefactura`
--

/*!50001 DROP VIEW IF EXISTS `prefactura`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prefactura` AS select `cli`.`TIPO_DOCUMENTO` AS `TIPO_DOC_CLIENTE`,`cli`.`NUM_DOCUMENTO` AS `NUM_DOC_CLIENTE`,`cli`.`PRIMER_NOMBRE` AS `PRIMER_NOMBRE_CLIENTE`,`cli`.`SEGUNDO_NOMBRE` AS `SEGUNDO_NOMBRE_CLIENTE`,`cli`.`PRIMER_APELLIDO` AS `PRIMER_APELLIDO_CLIENTE`,`cli`.`SEGUNDO_APELLIDO` AS `SEGUNDO_APELLIDO_CLIENTE`,`mec`.`TIPO_DOCUMENTO` AS `TIPO_DOC_MECANICO`,`mec`.`NUM_DOCUMENTO` AS `NUM_DOC_MECANICO`,`mec`.`PRIMER_NOMBRE` AS `PRIMER_NOMBRE_MECANICO`,`mec`.`SEGUNDO_NOMBRE` AS `SEGUNDO_NOMBRE_MECANICO`,`mec`.`PRIMER_APELLIDO` AS `PRIMER_APELLIDO_MECANICO`,`mec`.`SEGUNDO_APELLIDO` AS `SEGUNDO_APELLIDO_MECANICO`,`man`.`IDE_MANTENIMIENTO` AS `IDE_MANTENIMIENTO`,`cli`.`IDE_CLIENTE` AS `IDE_CLIENTE`,`mec`.`IDE_MECANICO` AS `IDE_MECANICO`,`man`.`VALORACION` AS `PRODUCTO`,`man`.`VAL_CANTIDAD_USADA` AS `VAL_CANTIDAD_USADA`,`man`.`TIPO_PRODUCTO` AS `TIPO_PRODUCTO`,`man`.`COD_PRODUCTO` AS `COD_PRODUCTO`,(case when (`man`.`TIPO_PRODUCTO` = 1) then (select (`s`.`VR_MANO_OBRA` - `s`.`DESCUENTO`) AS `VALOR` from `servicios` `s` where (`s`.`IDE_SERVICIO` = `man`.`COD_PRODUCTO`)) else (select (`r`.`PRECIO_UNIDAD` - `r`.`DESCUENTO`) AS `VALOR` from `repuestos` `r` where (`r`.`IDE_REPUESTO` = `man`.`COD_PRODUCTO`)) end) AS `VALOR` from (((`mantenimientos` `man` join `vehiculos` `ve`) join `clientes` `cli`) join `mecanicos` `mec`) where ((`man`.`IDE_VEHICULO` = `ve`.`IDE_VEHICULO`) and (`man`.`IDE_MECANICO` = `mec`.`IDE_MECANICO`) and (`ve`.`IDE_CLIENTE` = `cli`.`IDE_CLIENTE`) and (`man`.`ESTADO` = 'T')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-20 21:32:39
