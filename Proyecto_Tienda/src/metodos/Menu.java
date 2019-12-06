/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.io.*;

/**
 *
 * @author Diego
 */
public class Menu {
    
    public static BufferedReader lee = new BufferedReader(new InputStreamReader(System.in)); 
    
    public static void menuInicial() throws IOException{
        
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
                        Altas.crearUsuario();
                        break;
                    case 2:
//                        Bajas.bajas(lee);
                        break;
                    case 3:
                        System.out.println("\n - FIN DEL PROGRAMA - \n");
                        System.exit(0);
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }   
        } while(op!=3);
    }
        
       
    
    
    public static void menuPrincipal() throws IOException{
        
        byte op;
        
        System.out.println("----MENÚ PRINCIPAL--- \n"
                + "1. Ver productos \n"
                + "2. Ver cesta y realizar compra \n"
                + "3. Modificar datos usuario \n"
                + "4. Cerrar sesión \n");
        
        op = Byte.parseByte(lee.readLine());
        
        do{
            try{
                switch(op){
                    case 1:
//                        Consultas.verProducto(lee);
                        break;
                    case 2:
//                        Consultas.verCesta(lee);
                        break;
                    case 3:
//                        Modificar.modificarUsuario();
                        break;
                    case 4:
                        Menu.menuPrincipal();
                        break;  
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=4);
    } 
  
    
    public static void menuProducto() throws IOException{
        
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
                        Menu.menuPrincipal();
                        break;
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=4);
    }
    
    public static void menuCesta() throws IOException{
        
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
                          Menu.menuPrincipal();
                          break;
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=3);
    }    
    
    public static void menuUsuario() throws IOException{
        
        byte op;
        
        System.out.println("----MENÚ USUARIO--- \n"
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
//                        Modificar.modificarUsuario();
                        break;
                    case 8:
//                        Modificar.modificarTelefono();
                        break;
                    case 9:
//                        Modificar.modificarTarjeta();
                        break;
                    case 10:
                          Menu.menuPrincipal();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=10);
    }
    
    public static void menuAdministrador() throws IOException{
        
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
                          Menu.menuPrincipal();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }        
        } while(op!=10);
    } 
}
