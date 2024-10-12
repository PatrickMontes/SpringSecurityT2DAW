CREATE DATABASE t2DawPregunta2;
USE t2DawPregunta2;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    rol ENUM('COORDINADOR', 'GESTOR'),
    activo BOOLEAN DEFAULT TRUE
);
