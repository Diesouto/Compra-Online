package proyecto_tienda;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class CreacionTablas {

        public static void crearTablas(Statement sentencia,Connection conexion) {


        try {
            sentencia.execute("CREATE TABLE IF NOT EXISTS CLIENTE (nombre VARCHAR(15) NOT NULL, apellidos VARCHAR(25) NOT NULL, correo_electronico VARCHAR(25) NOT NULL, dni VARCHAR(25) PRIMARY KEY, "
                                + "fechaNacimiento DATE NOT NULL, direccion Direccion NOT NULL, telefono VARCHAR(9) NULL, tarjeta Tarjeta NULL ;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS PRODUCTO (precio FLOAT NOT NULL, stock INT NOT NULL, proveedor Proveedor NOT NULL, nombre VARCHAR(30) NOT NULL,"
                                + " descripcion VARCHAR(100) NOT NULL;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS TARJETA (num_tarjeta VARCHAR(19) NOT NULL, clave INT(4) NOT NULL, fecha,vencimiento DATE NOT NULL, nombre_propiet VARCHAR(40) NOT NULL;");
            
            sentencia.execute("CREATE TABLE IF NOT EXIST CUENTA (contraseña VARCHAR(15) NOT NULL, correo_electronico VARCHAR(40) NOT NULL;");
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(5);
        }
    }    
}
