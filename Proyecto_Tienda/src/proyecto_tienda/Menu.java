/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tienda;

import java.io.*;

/**
 *
 * @author Diego
 */
public class Menu {
    
    public BufferedReader lee = new BufferedReader(new InputStreamReader(System.in)); 
    
    public int menuInicial() throws IOException{
        
        System.out.println("----JAVIEXPRESS SHOP--- \n"
                + "1. Crear usuario \n"
                + "2. Iniciar sesión \n"
                + "3. Salir del programa\n");
        
        int seleccion = Integer.parseInt(lee.readLine());
        
        return seleccion;
    }
    
    public int menuPrincipal() throws IOException{
        
        System.out.println("----MENÚ PRINCIPAL--- \n"
                + "1. Ver productos \n"
                + "2. Ver cesta \n"
                + "3. Modificar usuario \n"
                + "4. Cerrar sesión\n");
        
        int seleccion = Integer.parseInt(lee.readLine());
        
        return seleccion;
    }
    
    public int menuProducto() throws IOException{
        
        System.out.println("----MENÚ PRODUCTO--- \n"
                + "1. Añadir al carro \n"
                + "2. Ver descripción \n"
                + "3. Buscar producto \n"
                + "4. Volver al menú \n");
        
        int seleccion = Integer.parseInt(lee.readLine());
        
        return seleccion;
    }
    
    public int menuCesta() throws IOException{
        
        System.out.println("----MENÚ CESTA--- \n"
                + "1. Comprar \n"
                + "2. Eliminar artículos \n"
                + "3. Volver al menú \n");
        
        int seleccion = Integer.parseInt(lee.readLine());
        
        return seleccion;
    }
    
    public int menuUsuario() throws IOException{
        
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
        
        int seleccion = Integer.parseInt(lee.readLine());
        
        return seleccion;
    }
}
