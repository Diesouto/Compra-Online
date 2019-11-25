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
        System.out.print("DNI: ");
        String dni = lee.readLine();
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        System.out.print("Fecha de nacimiento: ");
        //Date fecha_nacimiento = Validar.fechaNacimiento;
        System.out.print("Telefono (Opcional):");
        String telefono = lee.readLine();
        
        //Cliente cliente = new Cliente(nombre, apellidos, dni, correo, fecha_nacimiento);
        
        return cliente;
    }
    
}
