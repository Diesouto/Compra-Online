/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.Cuenta;
import hibernate.HibernateUtil;
import java.io.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author a18diegoirs
 */
public class AccionesUsuario {
    
    public static void iniciarSesion(BufferedReader lee) throws IOException{
        
        boolean aimIn = false;
        int comparar = 0;
        
        System.out.println("--INICIAR SESIÓN---");
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        System.out.print("Contraseña: ");
        String contraseña = lee.readLine();
        
        Session sesion =  HibernateUtil.getSession();
        Query query = HibernateUtil.getSession().createQuery("SELECT p FROM Producto p");
        List<Cuenta> cuentas = query.list();
        for(Cuenta cuenta : cuentas){
            if(correo.equalsIgnoreCase(cuenta.getCorreo_electronico())){
                
            }
        }
        HibernateUtil.cerrarSession();
        
    }
}
