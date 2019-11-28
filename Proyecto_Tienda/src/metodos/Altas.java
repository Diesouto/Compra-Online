/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.*;
import java.io.*;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class Altas {
    
    public static BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
    
    public static void crearCuenta() throws IOException{
        
        System.out.println("CREAR CUENTA");
        System.out.print("Nombre de usuario: ");
        String username = lee.readLine();
        System.out.print("Contraseña: ");
        String password = lee.readLine();
        
        /*Obliga a crear un cliente*/
        Cliente cliente = Altas.crearUsuario();
        
        /*Falta comprobar que el nombre de usuario no está cogido*/
        Cuenta cuenta = new Cuenta (username, password, cliente);
        
        
    }
    
    public static Cliente crearUsuario() throws IOException{
        
        System.out.println("CREAR CLIENTE");
        System.out.print("Nombre: ");
        String nombre = lee.readLine();
        System.out.print("Apellidos: ");
        String apellidos = lee.readLine();
        String dni = Validar.dni();
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        System.out.print("Fecha de nacimiento: ");
        Date fecha_nacimiento = Validar.validarFecha();
        String telefono = Validar.telefono();
        
        Cliente cliente = new Cliente(nombre, apellidos, dni, correo, fecha_nacimiento);
        
        return cliente;
    }
    
    public static void addTarjeta(Cliente cliente) throws IOException{
        
        System.out.println("AÑADIR TARJETA");
        System.out.print("Número de tarjeta: ");
        String numero = lee.readLine();
        System.out.print("Contraseña: ");
        int contraseña = Integer.parseInt(lee.readLine());
        System.out.print("Fecha vencimiento: ");
        Date fechaVencimiento = Validar.validarFecha();
        System.out.print("Nombre del propietario: ");
        String nombre = lee.readLine();
        
        Tarjeta tarjeta = new Tarjeta(numero, contraseña, fechaVencimiento, nombre);
        
        cliente.setTarjeta(tarjeta);
    }
    
    public static void addDireccion(Cliente cliente) throws IOException{
        
        System.out.println("AÑADIR DIRECCION");
        System.out.print("Nombre de la calle: ");
        String calle = lee.readLine();
        System.out.print("Número de la calle: ");
        int num_calle = Integer.parseInt(lee.readLine());
        System.out.print("Código postal: ");
        int cod_postal = Integer.parseInt(lee.readLine());
        System.out.print("Ciudad: ");
        String ciudad = lee.readLine();
        System.out.print("País: ");
        String pais = lee.readLine();
        
        Direccion direccion = new Direccion(calle, num_calle, cod_postal, ciudad, pais);
        
        cliente.setDireccion(direccion);
    }
    
}
