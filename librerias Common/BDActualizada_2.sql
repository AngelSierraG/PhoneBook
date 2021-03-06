-- phpMyAdmin SQL Dump
-- version 2.11.9.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-03-2015 a las 19:21:52
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
(1, 'Modorola', 'img_1'),
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
  PRIMARY KEY  (`idModelo`,`Marcas_idMarca`),
  KEY `fk_Modelos_Marcas1` (`Marcas_idMarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `modelos`
--

INSERT INTO `modelos` (`idModelo`, `NombreModelo`, `PrecioNuevo`, `SisOperativo`, `VidaUtil`, `Marcas_idMarca`, `Camara`, `ResolucionC`, `Cfrontal`, `ResolucionCF`, `Touch`, `Dimensiones`, `PesoGR`, `GPS`, `Procesador`, `MemoriaInterna`, `WIFI`, `Colores`, `Bloetooth`) VALUES
(1, 'Moto G', 3000, 'Android', 3, 1, 1, '5 Megapixeles', 1, '2.5 Megapixeles', 1, '9 x 5 cm', 300, 1, 'I-Core', '4GB', 1, 'Negro', 1),
(2, 'Samsung Galaxy Express', 2500, 'Android', 3, 2, 1, '3 Megapixeles', 0, '', 1, '9 x 5 cm', 300, 1, 'I-Core', '4GB', 1, 'Blanco', 1),
(3, 'LG7', 5000, 'Android', 3, 3, 1, '5 Megapixeles', 1, '3 Megapixeles', 1, '9 x 5 cm', 350, 1, 'I-Core', '5GB', 1, 'Blanco, Negro', 1),
(4, 'Lumia 520', 3500, 'Windows Phone', 3, 4, 1, '8 Megapixeles', 1, '1', 1, '6 x 8 cm', 250, 1, 'Intel', '5GB', 1, 'Blanco, Negro, Rosa', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `publicaciones`
--

INSERT INTO `publicaciones` (`idPublicacion`, `Activo`, `Titulo`, `FechaInicio`, `FechaFinal`, `Precio`, `Descripcion`, `urlImage`, `Usuario`, `Modelos_idModelo`) VALUES
(1, '\0', 'Vendo Cel', '2015-03-24', '2015-03-25', 150, 'Esta chido', 'brain.jpg', 'Usuario', 4),
(2, '\0', 'Vendo MotoG', '2015-03-24', '2015-03-25', 150, 'una breve', 'Img_4.jpg', 'Usuario', 2),
(3, '\0', 'Vendo MotoG', '2015-03-24', '2015-03-26', 155, 'Una breve', 'Img_0.jpg', 'Usuario', 3),
(4, '\0', 'Vendo MotoG', '2015-03-24', '2015-03-26', 155, 'Una breve', 'Img_0.jpg', 'Usuario', 3),
(5, '\0', 'Robo', '2015-03-26', '2015-03-27', 1800, 'sere breve', 'Img_4.jpg', 'Usuario', 4);

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
  `Direccion` varchar(45) default NULL,
  `VisibleTelefono` tinyint(1) NOT NULL,
  `Telefono` varchar(45) default NULL,
  `CalfVendedor` smallint(6) NOT NULL,
  PRIMARY KEY  (`NickName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `usuarios`
--

