-- phpMyAdmin SQL Dump
-- version 2.11.9.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 26-03-2015 a las 05:18:40
-- Versión del servidor: 5.0.67
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `phonebook`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE IF NOT EXISTS `marcas` (
  `idMarca` int(11) NOT NULL auto_increment,
  `NombreMarca` varchar(45) default NULL,
  `urlImage` varchar(50) NOT NULL,
  PRIMARY KEY  (`idMarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`idMarca`, `NombreMarca`, `urlImage`) VALUES
(1, 'Modorola', 'img_1.jpg'),
(2, 'Samsung', 'img_2'),
(3, 'LG', 'img_3'),
(4, 'Nokia', 'img_4'),
(5, 'Sony Ericsson ', 'img_5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modelos`
--

CREATE TABLE IF NOT EXISTS `modelos` (
  `idModelo` int(11) NOT NULL auto_increment,
  `NombreModelo` varchar(45) NOT NULL,
  `PrecioNuevo` int(11) NOT NULL COMMENT 'Precio actual del celular nuevo, actualizado',
  `SisOperativo` varchar(45) NOT NULL,
  `Marcas_idMarca` int(11) NOT NULL,
  `Camara` tinyint(1) NOT NULL,
  `ResolucionC` varchar(45) NOT NULL,
  `MemoriaInterna` varchar(45) NOT NULL,
  PRIMARY KEY  (`idModelo`,`Marcas_idMarca`),
  KEY `fk_Modelos_Marcas1` (`Marcas_idMarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `modelos`
--

INSERT INTO `modelos` (`idModelo`, `NombreModelo`, `PrecioNuevo`, `SisOperativo`, `Marcas_idMarca`, `Camara`, `ResolucionC`, `MemoriaInterna`) VALUES
(1, 'Moto G', 3000, 'Android', 1, 1, '5 Megapixeles', '4GB'),
(2, 'Samsung Galaxy Express', 2500, 'Android', 2, 1, '3 Megapixeles', '4GB'),
(3, 'LG7', 5000, 'Android', 3, 1, '5 Megapixeles', '5GB'),
(4, 'Lumia 520', 3500, 'Windows Phone', 4, 1, '8 Megapixeles', '5GB');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicaciones`
--

CREATE TABLE IF NOT EXISTS `publicaciones` (
  `idPublicacion` int(11) NOT NULL auto_increment,
  `Activo` bit(1) NOT NULL default '\0',
  `Titulo` varchar(40) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFinal` date NOT NULL,
  `Precio` smallint(6) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `urlImage` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Modelos_idModelo` int(11) NOT NULL,
  PRIMARY KEY  (`idPublicacion`),
  KEY `fk_Anuncios_Modelos` (`Modelos_idModelo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `publicaciones`
--

INSERT INTO `publicaciones` (`idPublicacion`, `Activo`, `Titulo`, `FechaInicio`, `FechaFinal`, `Precio`, `Descripcion`, `urlImage`, `Usuario`, `Modelos_idModelo`) VALUES
(1, '\0', 'VendoMOTO', '2015-03-24', '2015-03-25', 150, 'Esta chAROOOOOS', 'Img_1.jpg', 'Usuario', 4),
(2, '\0', 'VendoCulei', '2015-03-24', '2015-03-25', 150, 'una breve', 'Img_2.jpg', 'Usuario', 2),
(3, '\0', 'VEndoCaca', '2015-03-24', '2015-03-26', 155, 'Una breve', 'Img_3.jpg', 'Usuario', 3),
(4, '\0', 'VendoRZZZ', '2015-03-26', '2015-03-31', 1560, 'Una breve leve leve', 'Img_4.jpg', 'Usuario', 4),
(5, '\0', 'Robo', '2015-03-26', '2015-03-27', 1800, 'sere breve', 'Img_4.jpg', 'Usuario', 4),
(6, '\0', 'Vendo Ihpbe', '2015-03-24', '2015-03-28', 500, 'lev leve', 'Img_5.jpg', 'Usuario', 1);

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
  `Direccion` varchar(45) default NULL,
  `Telefono` varchar(45) default NULL,
  `Tipo` tinyint(1) NOT NULL default '0',
  `Activo` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`NickName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Password`, `NickName`, `Nombre`, `Apellido`, `Estado`, `Ciudad`, `Direccion`, `Telefono`, `Tipo`, `Activo`) VALUES
('1234', 'ac-marlon@hotmail.com', 'Marlon', 'Aguilar', 'Chiapas', 'San Cristobal de las Casas', 'Calle de ejemplo', '9671255555', 0, 0),
('1456', 'dago@hotmail.com', 'Dago', 'Marroquin', 'Chiapas', 'Arriaga', 'Calle ejamplo', '7855226669', 0, 0);
