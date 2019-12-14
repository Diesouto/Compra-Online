/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.Sesion;
import java.io.*;

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
                        AccionesUsuario.iniciarSesion(lee);
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
            System.out.println("----MENÚ PRINCIPAL--- \n"
                + "1. Ver productos \n"
                + "2. Seleccionar producto"
                + "3. Ver cesta y realizar compra \n"
                + "4. Modificar datos usuario \n"
                + "5. Cerrar sesión \n");
            
            op = Byte.parseByte(lee.readLine());
            try{
                switch(op){
                    case 1:
                        Visualizar.productos();
                        break;
                        
                    case 2:
                        //TODO: preguntar por un ID de un producto. Mostrar ese producto en detalle y
                        // mostrar opciones: meter en cesta, o salir.
                    case 3:
                        if(s.isLogeado() == true){
                            //Consultas.verCesta(lee);
                            //TODO: visualizar cesta
                        } else {
                            System.out.println("Esta funcion esta reservada para usuarios registrados.");
                        }
                        break;
                    case 4:
                        if(s.isLogeado() == true){
                            Menu.menuModificar(lee, s);
                        } else {
                            System.out.println("Esta funcion esta reservada para usuarios registrados.");
                        }
                        break;
                    case 5:
                        Menu.menuPrincipal(s);
                        //TODO: cerrar sesion
                        break;  
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=4);
    } 
  
    //TODO: arreglar
    public static void menuProducto(Sesion s) throws IOException{
        
        byte op;
        
        System.out.println("----MENÚ PRODUCTO--- \n"
                + "1. Añadir a la cesta \n"
                + "2. Ver descripción \n"
                + "3. Buscar producto \n"
                + "4. Volver al menú \n");
        
       op = Byte.parseByte(lee.readLine());
        
        do{
            try{
                switch(op){
                    case 1:
                        break;
                    case 2:
//                        Consultas.verDescripcion();
                        break;
                    case 3:
//                        Consultas.buscarProducto();
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
    
    public static void menuCesta(Sesion s) throws IOException{
        
        byte op;
        
        System.out.println("----MENÚ CESTA--- \n"
                + "1. Comprar \n"
                + "2. Eliminar artículos \n"
                + "3. Volver al menú \n");
        
        op = Byte.parseByte(lee.readLine());
        
        do{
            try{
                switch(op){
                    case 1:
                        
                        break;
                    case 2:
//                        Bajas.borrarArticulo();
                        break;
                    case 3:
                          Menu.menuPrincipal(s);
                          break;
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=3);
    }    
    
    public static void menuModificar(BufferedReader lee, Sesion s) throws IOException{
        
        byte op;
        
        System.out.println("----MENÚ MODIFICAR--- \n"
                + "1. Modificar nombre \n"
                + "2. Modificar apellidos \n"
                + "3. Modificar correo \n"
                + "4. Modificar dni \n"
                + "5. Modificar fecha de nacimiento \n"
                + "6. Modificar dirección \n"
                + "7. Modificar usuario \n"
                + "8. Modificar telefono \n"
                + "9. Modificar tarjeta \n"
                + "10. Volver al menú \n");
        
//        do{
//            op = Byte.parseByte(lee.readLine());
//            try{
//                switch(op){
//                    case 1:
//                        Modificar.nombre(cliente);
//                        break;
//                    case 2:
//                        Modificar.apellidos(cliente);
//                        break;
//                    case 3:
//                        Modificar.correo(cliente);
//                        break;
//                    case 4:
//                        Modificar.dni(cliente);
//                        break;
//                    case 5:
//                        Modificar.fecha_nacimiento(cliente);
//                        break;
//                    case 6:
//                        Modificar.dirección(cliente);
//                        break;
//                    case 7:
//                        Modificar.usuario(cliente);
//                        break;
//                    case 8:
//                        Modificar.telefono(cliente);
//                        break;
//                    case 9:
//                        Modificar.tarjeta(cliente);
//                        break;
//                    case 10:
//                          Menu.menuPrincipal();
//                }
//            }catch(Exception e){
//                System.out.println(e.getMessage());
//            }        
//        } while(op!=10);
    }
    
public static void menuAdministrador(Sesion s) throws IOException{
        
        byte op;
        
        System.out.println("----MENÚ ADMINISTRADOR--- \n"
                + "1. Añadir productos \n"
                + "2. Añadir proveedores \n"
                + "3. Modificar productos \n"
                + "4. Modificar proveedores \n"
                + "5. Ver productos \n"
                + "6. Ver proveedores \n"
                + "7. Volver al menú \n");
        
        op = Byte.parseByte(lee.readLine());
        
        do{
            try{
                switch(op){
                    case 1:
//                        Modificar.modificarNombre();
                        break;
                    case 2:
//                        Modificar.modificarApellidos();
                        break;
                    case 3:
//                        Modificar.modificarCorreo();
                        break;
                    case 4:
//                        Modificar.modificarDNI();
                        break;
                    case 5:
//                        Modificar.modificarFechaNacimiento();
                        break;
                    case 6:
//                        Modificar.modificarDireccion();
                        break;
                    case 7:
                          Menu.menuPrincipal(s);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=10);
    }
    
    public static byte menuConfirmar (BufferedReader lee) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este producto?"
                + "\n1.SI"
                + "\n2.NO");
        
        op = Byte.parseByte(lee.readLine());
        
        return op;
    }
}
