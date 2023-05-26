-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 23-05-2023 a las 07:25:08
-- Versión del servidor: 5.5.60-0+deb7u1
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `AlltrazBDD`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Empresa`
--
CREATE DATABASE Alltraz;

USE Alltraz;



CREATE TABLE `Empresa` (
  `Id_empresa` int(11) NOT NULL,
  `Cif` varchar(45) NOT NULL,
  `Contraseña` varchar(45) NOT NULL,
  `Icono` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Movimientos`
--

CREATE TABLE `Movimientos` (
  `Id_movimientos` int(11) NOT NULL,
  `Id_producto` int(11) NOT NULL,
  `Fecha_plantacion` date NOT NULL,
  `Fecha_cosecha` date NOT NULL,
  `Fecha_llegadaAlmacen` date NOT NULL,
  `Fecha_salidaAlmacen` date NOT NULL,
  `Hora_salidaAlmacen` date NOT NULL,
  `Hora_LlegadaAlmacen` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE `Producto` (
  `Id_producto` int(11) NOT NULL,
  `Id_empresa` int(11) DEFAULT NULL,
  `id_TipoProducto` int(11) NOT NULL,
  `Numero_lote` int(11) DEFAULT NULL,
  `Caracteristicas` varchar(3000) DEFAULT NULL,
  `Imagen` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Seguir`
--

CREATE TABLE `Seguir` (
  `id_Empresa` int(11) NOT NULL,
  `id_Usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `Id_usuario` int(11) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Contraseña` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Empresa`
--
ALTER TABLE `Empresa`
  ADD PRIMARY KEY (`Id_empresa`);

--
-- Indices de la tabla `Movimientos`
--
ALTER TABLE `Movimientos`
  ADD PRIMARY KEY (`Id_movimientos`),
  ADD KEY `Id_producto` (`Id_producto`);

--
-- Indices de la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`Id_producto`),
  ADD KEY `Id_empresa` (`Id_empresa`);

--
-- Indices de la tabla `Seguir`
--
ALTER TABLE `Seguir`
  ADD KEY `id_Empresa` (`id_Empresa`),
  ADD KEY `id_Usuario` (`id_Usuario`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`Id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Empresa`
--
ALTER TABLE `Empresa`
  MODIFY `Id_empresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Movimientos`
--
ALTER TABLE `Movimientos`
  MODIFY `Id_movimientos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Producto`
--
ALTER TABLE `Producto`
  MODIFY `Id_producto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `Id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Movimientos`
--
ALTER TABLE `Movimientos`
  ADD CONSTRAINT `Movimientos_ibfk_1` FOREIGN KEY (`Id_producto`) REFERENCES `Producto` (`Id_producto`);

--
-- Filtros para la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD CONSTRAINT `Producto_ibfk_1` FOREIGN KEY (`Id_empresa`) REFERENCES `Empresa` (`Id_empresa`);

--
-- Filtros para la tabla `Seguir`
--
ALTER TABLE `Seguir`
  ADD CONSTRAINT `Seguir_ibfk_2` FOREIGN KEY (`id_Usuario`) REFERENCES `Usuario` (`Id_usuario`),
  ADD CONSTRAINT `Seguir_ibfk_1` FOREIGN KEY (`id_Empresa`) REFERENCES `Empresa` (`Id_empresa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
