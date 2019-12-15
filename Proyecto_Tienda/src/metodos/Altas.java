/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;


import POJOS.*;
import hibernate.HibernateUtil;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class Altas {
    
    public static BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
     
        public static Cuenta crearCuenta() throws IOException{
        
        /*Obliga a crear un cliente*/
        Cliente cliente = Altas.crearCliente();
        Cuenta cuenta = null;
        if(cliente != null){
            System.out.println("\nCREAR CUENTA");
            System.out.print("Usuario: ");
            String usuario = cliente.getCorreo_electronico();
            System.out.print(usuario +"\n");
            System.out.print("Contraseña: ");
            String password = lee.readLine();
            Date date = new Date();
            ArrayList<Producto> aux = new ArrayList<>();
            Cesta cesta = new Cesta(date,aux);
            
            /*Falta comprobar que el nombre de usuario no está cogido*/
            cuenta = new Cuenta (usuario, password, cliente, cesta);
            Guardar.guardarObjeto(cesta);
            Guardar.guardarObjeto(cuenta);
            
            
        }else{
        System.out.println("\nEste correo ya existe! Pruebe iniciar sesion...");
    }
        return cuenta;
}
    
    protected static Cliente crearCliente() throws IOException{
                
        Cliente cliente = null;
        
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        correo = correo.replace(" ","");
        
        Session sesion = HibernateUtil.getSession();
        Cliente aux = AccionesUsuario.getCliente(correo, sesion);
        if(aux==null){
        
        
        System.out.println("CREAR CLIENTE");
        System.out.print("Nombre: ");
        String nombre = lee.readLine();
        System.out.print("Apellidos: ");
        String apellidos = lee.readLine();
        String dni = Validar.dni();
        System.out.print("Fecha de nacimiento (xx/xx/xxxx): \n");
        Date fecha_nacimiento = Validar.validarFecha();
        String telefono = Validar.telefono();
        System.out.println("Direccion:"
                + "\nCalle, codPostal, Provincia. ");
        String direccion = lee.readLine();
       
        
        cliente = new Cliente(nombre, apellidos, dni, correo, fecha_nacimiento, telefono, direccion);
        }
        sesion.close();
        return cliente;
    }
   
    public static void insertProducto() throws IOException{
        
        System.out.println("INSERTAR PRODUCTO");
        
        System.out.print("Nombre del producto: ");
        String nombre = lee.readLine();
        System.out.print("Precio del producto: ");
        float precio = Float.parseFloat(lee.readLine());
        System.out.print("Stock del producto");
        int stock = Integer.parseInt(lee.readLine());
        System.out.print("Descripcion del producto: ");
        String descripcion = lee.readLine();
        
        Producto producto = new Producto(precio, stock, nombre, descripcion);
        
        Guardar.guardarObjeto(producto);
    }
}
