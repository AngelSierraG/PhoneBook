-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-03-2015 a las 01:11:51
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `mydb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncios`
--

CREATE TABLE IF NOT EXISTS `anuncios` (
  `idAnuncio` int(11) NOT NULL,
  `Activo` bit(1) NOT NULL DEFAULT b'0',
  `Titulo` varchar(40) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFinal` date NOT NULL,
  `Precio` smallint(6) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `urlImage` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Modelos_idModelo` int(11) NOT NULL,
  PRIMARY KEY (`Usuario`),
  KEY `fk_Anuncios_Modelos` (`Modelos_idModelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `anuncios`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE IF NOT EXISTS `marcas` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `NombreMarca` varchar(45) DEFAULT NULL,
  `urlImage` varchar(50) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `marcas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modelos`
--

CREATE TABLE IF NOT EXISTS `modelos` (
  `idModelo` int(11) NOT NULL,
  `NombreModelo` varchar(45) NOT NULL,
  `PrecioNuevo` int(11) NOT NULL COMMENT 'Precio actual del celular nuevo, actualizado',
  `SisOperativo` varchar(45) NOT NULL,
  `VidaUtil` smallint(6) NOT NULL,
  `Marcas_idMarca` int(11) NOT NULL,
  `Camara` tinyint(1) NOT NULL,
  `ResolucionC` varchar(45) NOT NULL,
  `Cfrontal` tinyint(1) NOT NULL,
  `ResolucionCF` varchar(45) NOT NULL,
  `Touch` tinyint(1) NOT NULL,
  `Dimensiones` varchar(45) NOT NULL,
  `PesoGR` smallint(6) NOT NULL,
  `GPS` tinyint(1) NOT NULL,
  `Procesador` varchar(45) NOT NULL,
  `MemoriaInterna` varchar(45) NOT NULL,
  `WIFI` tinyint(1) NOT NULL,
  `Colores` varchar(100) NOT NULL,
  `Bloetooth` tinyint(1) NOT NULL,
  PRIMARY KEY (`idModelo`,`Marcas_idMarca`),
  KEY `fk_Modelos_Marcas1` (`Marcas_idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `modelos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `Password` varchar(45) NOT NULL,
  `NickName` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `Ciudad` varchar(45) NOT NULL,
  `VisibleDireccion` tinyint(1) NOT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `VisibleTelefono` tinyint(1) NOT NULL,
  `Telefono` varchar(45) DEFAULT NULL,
  `CalfVendedor` smallint(6) NOT NULL,
  PRIMARY KEY (`NickName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `usuarios`
--


--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `anuncios`
--
ALTER TABLE `anuncios`
  ADD CONSTRAINT `anuncios_ibfk_1` FOREIGN KEY (`Usuario`) REFERENCES `usuarios` (`NickName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `anuncios_ibfk_2` FOREIGN KEY (`Modelos_idModelo`) REFERENCES `modelos` (`idModelo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `modelos`
--
ALTER TABLE `modelos`
  ADD CONSTRAINT `fk_Modelos_Marcas1` FOREIGN KEY (`Marcas_idMarca`) REFERENCES `marcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION;
