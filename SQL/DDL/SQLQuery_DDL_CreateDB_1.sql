-- Crear la base de datos
IF NOT EXISTS (SELECT 1 FROM sys.databases WHERE name = 'bancoprueba')
BEGIN
    CREATE DATABASE bancoprueba;
END;




