package proyecto_tienda;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class CreacionTablas {

        public static void crearTablas(Statement sentencia,Connection conexion) {

        try{
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
            sentencia=conexion.createStatement();
            
            sentencia.execute("CREATE DATABASE IF NOT EXISTS PROYECTO_TIENDA");
            
            sentencia.execute("USE PROYECTO_TIENDA");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS CLIENTE ("
                    + "nombre VARCHAR(15) NOT NULL, "
                    + "apellidos VARCHAR(25) NOT NULL, "
                    + "correo_electronico VARCHAR(25) PRIMARY KEY, "
                    + "dni VARCHAR(25) NOT NULL, "
                    + "fechaNacimiento DATE NOT NULL, "
                    + "telefono VARCHAR(9) NULL, "
                    + "tarjeta Tarjeta NULL ;"
                    + "PRIMARY KEY (dni),"
                    + "");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS PRODUCTO ("
                    + "idProducto INT(5) AUTO_INCREMENT NOT NULL"
                    + "precio FLOAT NOT NULL, "
                    + "stock INT(5) NOT NULL, "
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "descripcion VARCHAR(100) NOT NULL," 
                    + "proveedor Proveedor NOT NULL, "
                    + "PRIMARY KEY (idProducto),"
                    + "ON UPDATE CASCADE"
                    + "ON DELETE CASCADE)");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS TARJETA ("
                    + "num_tarjeta VARCHAR(19) NOT NULL, "
                    + "clave INT(4) NOT NULL, "
                    + "fecha,vencimiento DATE NOT NULL, "
                    + "nombre_propiet VARCHAR(40) NOT NULL"
                    + "PRIMARY KEY (num_tarjeta),"
                    + "ON UPDATE CASCADE"
                    + "ON DELETE CASCADE)");
            
            sentencia.execute("CREATE TABLE IF NOT EXIST CUENTA ("
                    + "contraseña VARCHAR(15) NOT NULL, "
                    + "correo_electronico VARCHAR(40) NOT NULL, "
                    + "PRIMARY KEY (correo_electronico);");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS PROVEEDOR ("
                    + "nombre VARCHAR(20) NOT NULL,"
                    + "direccion VARCHAR(30) NOT NULL,"
                    + "telefono VARCHAR(9) NOT NULL; ");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS CESTA ("
                    + "id_cesta INT(5) AUTO_INCREMENT NOT NULL,"
                    + "fechaAñadido DATE NOT NULL,"
                    + "contadorProductos INT (3) NOT NULL,"
                    + "PRIMARY KEY (id_cesta),"
                    + "");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS DIRECCION ("
                    + "calle VARCHAR(30) NOT NULL,"
                    + "num_calle INT(3) NULL,"
                    + "codigo_postal INT(5) NOT NULL,"
                    + "ciudad VARCHAR(15) NOT NULL,"
                    + "pais VARCHAR (15) NOT NULL,"
                    + "PRIMARY KEY (calle),"
                    + "ON UPDATE CASCADE"
                    + "ON DELETE CASCADE)");
        
            sentencia.execute("CREATE TABLE IF NOT EXISTS FACTURA ("
                    + "idFactura INT(5) AUTO_INCREMENT NOT NULL,"
                    + "fechaCompra DATE NOT NULL,"
                    + "precio FLOAT NOT NULL, "
                    + "PRIMARY KEY (idFactura);"
                    + "");
        
        System.out.println("\n - BASE DE DATOS LISTA - \n");
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(5);
        }
    }    
}
