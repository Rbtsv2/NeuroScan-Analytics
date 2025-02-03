#!/bin/bash

# Attendre que SQL Server soit prêt
until /opt/mssql-tools18/bin/sqlcmd -S localhost -U SA -P "YourStrong!Passw0rd" -Q "SELECT 1" > /dev/null 2>&1; do
    echo "⏳ En attente du démarrage de SQL Server..."
    sleep 5
done

# Créer la base de données MedicalDB si elle n'existe pas
/opt/mssql-tools18/bin/sqlcmd -S localhost -U SA -P "YourStrong!Passw0rd" -Q "IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'MedicalDB') BEGIN CREATE DATABASE MedicalDB; END;"

echo "✅ Base de données MedicalDB vérifiée/créée avec succès."
