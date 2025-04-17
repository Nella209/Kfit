-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS KFit;
USE KFit;

-- Borrar tablas existentes para evitar conflictos
DROP TABLE IF EXISTS detalle_ventas;
DROP TABLE IF EXISTS ventas;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS categorias_productos;
DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS usuarios;

-- Tabla de Usuarios (Usuarios que se registran en la plataforma)
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(250),
    contraseña VARCHAR(150) NOT NULL,
    rol VARCHAR(50) DEFAULT 'usuario'
);

-- Tabla de Categorías de Productos (Categorías de servicios o artículos ofrecidos)
CREATE TABLE IF NOT EXISTS categorias_productos (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- Tabla de Productos (Servicios o artículos que KFit ofrece)
CREATE TABLE IF NOT EXISTS productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias_productos(id_categoria)
);

-- Tabla de Clientes (Clientes registrados que compran productos o servicios)
CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    telefono VARCHAR(15),
    direccion VARCHAR(250)
);

-- Tabla de Ventas (Transacciones realizadas)
CREATE TABLE IF NOT EXISTS ventas (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Tabla de Detalle de Ventas (Detalles de cada venta)
CREATE TABLE IF NOT EXISTS detalle_ventas (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) AS (cantidad * precio_unitario) STORED,
    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
); SHOW DATABASES;

