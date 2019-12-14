/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import JavaBeans.Proveedor;
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
     
        public static void crearCuenta() throws IOException{
        
        /*Obliga a crear un cliente*/
        Cliente cliente = Altas.crearCliente();
        if(cliente != null){
        System.out.println("CREAR CUENTA");
        System.out.print("Usuario: ");
        String usuario = cliente.getCorreo_electronico();
        System.out.print(usuario +"\n");
        System.out.print("Contraseña: ");
        String password = lee.readLine();
        Date date = new Date();
        ArrayList<Producto> aux = new ArrayList<>();
        Cesta cesta = new Cesta(date,aux);
        
        /*Falta comprobar que el nombre de usuario no está cogido*/
        Cuenta cuenta = new Cuenta (usuario, password, cliente, cesta);
        
        Guardar.guardarObjeto(cuenta);}{
        System.out.println("\nEste correo ya existe! Pruebe iniciar sesion...");
    }
        
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
        
        cliente = new Cliente(nombre, apellidos, dni, correo, fecha_nacimiento);
        }
        sesion.close();
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
        
        cliente.getTarjetas().add(tarjeta);
    }
    
    
    public static Direccion insertDireccion() throws IOException{
        
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
        
        return direccion;
    }
    
    public static void insertProveedor() throws IOException{
        System.out.println("INSERTAR PROVEEDOR");
        System.out.println("nombre:");
        String nombre = lee.readLine();
        System.out.println("Direccion:");
        Direccion direccion = insertDireccion();
        System.out.println("Telefono: ");
        String tlf = lee.readLine();
        
        Proveedor aux = new Proveedor(nombre,direccion,tlf);
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
