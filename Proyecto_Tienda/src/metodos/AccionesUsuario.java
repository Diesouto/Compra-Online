/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.io.*;

/**
 *
 * @author a18diegoirs
 */
public class AccionesUsuario {
    
    public static void iniciarSesion(BufferedReader lee) throws IOException{
        
        System.out.println("--INICIAR SESIÓN---");
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        System.out.print("Contraseña: ");
        String contraseña = lee.readLine();
        
        
        
    }
}
