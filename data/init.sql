IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'MedicalDB')
BEGIN
    CREATE DATABASE MedicalDB;
END;
GO
