/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.Cliente;
import POJOS.Sesion;
import java.io.*;
import POJOS.Cuenta;
import POJOS.Producto;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import static proyecto_tienda.Proyecto_Tienda.sesion;

/**
 *
 * @author Diego
 */
public class Menu {
    
    public static BufferedReader lee = new BufferedReader(new InputStreamReader(System.in)); 
    
    public static Sesion menuLogin() throws IOException{
        Sesion s = new Sesion();
        byte op;
        
        System.out.println("----JAVIEXPRESS SHOP--- \n"
                + "1. Crear usuario \n"
                + "2. Iniciar sesión \n"
                + "3. Salir del programa\n");
        
        op = Byte.parseByte(lee.readLine());
        
        do{
            try{
                switch(op){
                    case 1:
                        Altas.crearCuenta();
                        break;
                    case 2:
                        AccionesUsuario.iniciarSesion(lee,s);
                        break;
                    case 3:
                        System.out.println("\n - FIN DEL PROGRAMA - \n");
                        System.exit(0);
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }   
        } while(op!=3);
        return s;
    }
        
       
    
    
    public static void menuPrincipal(Sesion s) throws IOException{
        
        byte op;
        do{
            if(s.isLogeado()){
                System.out.println("\n\tMENÚ PRINCIPAL \n"
                    + "1. Ver productos \n"
                    + "2. Seleccionar producto\n"
                    + "3. Ver cesta y realizar compra \n"
                    + "4. Modificar datos usuario \n"
                    + "5. Cerrar sesión \n");
            }else if (!s.isLogeado()){
                System.out.println("\n\tMENÚ PRINCIPAL \n"
                    + "1. Ver productos \n"
                    + "2. Seleccionar producto\n"
                    + "3. Ver cesta y realizar compra \n"
                    + "4. Modificar datos usuario \n"
                    + "5. Cerrar sesión \n"
                    + "6. Iniciar sesion\n");
            }
            
            op = Byte.parseByte(lee.readLine());
            try{
                switch(op){
                    case 1:
                        Visualizar.productos();
                        break;
                    case 2:
                        AccionesUsuario.añadirProducto(s);
                        break;
                    case 3:
                        if(s.isLogeado() == true){
                            Menu.menuCesta(s);
                        } else {
                            System.out.println("Esta funcion esta reservada para usuarios registrados.");
                        }
                        break;
                    case 4:
                        if(s.isLogeado() == true){
                            Menu.menuModificar(lee, s );
                        } else {
                            System.out.println("Esta funcion esta reservada para usuarios registrados.");
                        }
                        break;
                    case 5:
                        if(s.isLogeado()){
                            s.logout();
                            System.out.println("Sesion cerrada");
                        }else{
                            System.out.println("No estaba iniciada la sesion");
                         }
                        break;
                    case 6:
                        if(!s.isLogeado()){
                            Cuenta cuentaIniciar = AccionesUsuario.iniciarSesion(lee,s);
                                if(cuentaIniciar==null){
                                    System.out.println("No existe ese correo, quiere registrarse?");
                                    String eleccion = lee.readLine();
                                    if(eleccion.equalsIgnoreCase("si")){
                                        cuentaIniciar = Altas.crearCuenta();
                                        s.logear(cuentaIniciar.getCorreo_electronico());    
                                    }}else{
                                    s.logear(cuentaIniciar.getCorreo_electronico());                      
                                }                    
                        }
                        break;
                    case 10:
                        HibernateUtil.cerrarSession();
                        System.exit(0);
                        break;
                }          
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=10);
    } 
  
 
    public static void menuCesta(Sesion s) throws IOException{
        
        byte op;
        
        do{
        
        System.out.println("\n\tMENÚ CESTA \n"
                + "1. Comprar \n"
                + "2. Visualizar cesta \n"
                + "3. Eliminar artículos \n"
                + "4. Vaciar cesta \n"
                + "5. Volver al menú \n");
        
        op = Byte.parseByte(lee.readLine());
        
            try{
                switch(op){
                    case 1:
                        AccionesUsuario.comprarCarro(s);
                        break;
                    case 2:
                        Visualizar.cesta(s);
                        break;    
                    case 3:
                        Visualizar.cesta(s);
                        AccionesUsuario.quitarCesta(s);
                        break;
                    case 4:
                        Visualizar.cesta(s);
                        AccionesUsuario.vaciarCesta(s);
                        break;
                    case 5:
                        Menu.menuPrincipal(s);
                        break;      
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=5);
    }    
    
    public static void menuModificar(BufferedReader lee, Sesion s) throws IOException{
        
        byte op;
        
        Session session = HibernateUtil.getSession();
        Cuenta cuenta=AccionesUsuario.getCuenta(s.getToken(), session);
        Cliente cliente = AccionesUsuario.getCliente(s.getToken(), session);    
        session.close();

        do{
            System.out.println("\n\tMENÚ MODIFICAR \n"
                    + "1. Modificar nombre \n"
                    + "2. Modificar apellidos \n"
                    + "3. Modificar correo \n"
                    + "4. Modificar dni \n"
                    + "5. Modificar fecha de nacimiento \n"
                    + "6. Modificar dirección \n"
                    + "7. Modificar telefono \n"
                    + "8. Modificar saldo \n"
                    + "9. Volver al menú \n");
            op = Byte.parseByte(lee.readLine());
            
            try{
                switch(op){
                    case 1:
                        Modificar.nombre(cuenta);
                        break;
                    case 2:
                        Modificar.apellidos(cuenta);
                        break;
                    case 3:
                        Modificar.correo(cuenta,s);
                        break;
                    case 4:
                        Modificar.dni(cuenta);
                        break;
                    case 5:
                        Modificar.fecha_nacimiento(cuenta);
                        break;
                    case 6:
                        Modificar.dirección(cuenta);
                        break;
                    case 7:
                        Modificar.telefono(cuenta);
                        break;
                    case 8:
                        Modificar.saldo(cuenta);
                        break;    
                    case 9:
                        Menu.menuPrincipal(s);
                        break;
                }    
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=9);
    }
    
public static void menuAdministrador(Sesion s) throws IOException{
        
        byte op;
           
        do{
            System.out.println("\n\tMENÚ ADMINISTRADOR \n"
                + "1. Añadir productos \n"
                + "2. Modificar productos \n"
                + "3. Ver productos \n"
                + "4. Volver al menú \n");
            op = Byte.parseByte(lee.readLine());
            try{
                switch(op){
                    case 1:
                        Altas.insertProducto();
                        break;
                    case 2:
                        System.out.println("Introduce el id del producto a modificar");
                        String id = lee.readLine();
                        Session session = HibernateUtil.getSession();
                        Producto producto = AccionesUsuario.getProducto(id, session);
                        Menu.modificarProductos(producto);
                        break;
                    case 3:
                          Visualizar.productos();
                        break;
                    case 4:
                          Menu.menuPrincipal(s);
                        break;   
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=4);
    }

    public static void modificarProductos(Producto producto) throws IOException{
        byte op;

        do{
            System.out.println(producto.toString());
            
             System.out.println("\n\tMENÚ ADMINISTRADOR \n"
                + "1. Modificar precio \n"
                + "2. Modificar stock \n"
                + "3. Modificar nombre \n"
                + "4. Modificar descripcion \n"
                + "5. Volver al menú \n");
        
        op = Byte.parseByte(lee.readLine());
            try{
                switch(op){
                    case 1:
                        Modificar.precio(producto);
                        break;
                    case 2:
                        Modificar.stock(producto);
                        break;
                    case 3:
                        Modificar.nombre(producto);
                        break;
                    case 4:
                        Modificar.descripcion(producto);
                        break;
                    case 5:
                        break;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=5);
    }
}
