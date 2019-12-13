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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
                if(contraseña.equalsIgnoreCase(cuenta.getContraseña())){
                    Menu.menuPrincipal();
                }
                else{
                    System.out.print("La contraseña introducida es incorrecta");
                }
            }
            else {
                System.out.print("El correo introducido es incorrecto");
            }
        }
        HibernateUtil.cerrarSession();
        
    }
    
    public static void pruebaSesion(BufferedReader lee, Session sesion) throws IOException{
        
        System.out.println("--INICIAR SESIÓN---");
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        System.out.print("Contraseña: ");
        String contraseña = lee.readLine();
        
        Cuenta iniciarSesion = AccionesUsuario.getCorreo(correo, sesion);
        
        if(iniciarSesion != null){
            
            if(contraseña.equals(iniciarSesion.getContraseña())){
                System.out.println("Sesión iniciada");
            }
            else{
                System.out.println("La contraseña introducida es incorrecta");
            }
        }
        else {
            System.out.println("No existe este correo");
        }
        
        HibernateUtil.cerrarSession();
        
    }
    
    public static Cuenta getCorreo(String correo, Session sesion) {

        Criteria c = sesion.createCriteria(Cuenta.class);
        c.add(Restrictions.eq("correo_electronico", correo));

        Cuenta cls = (Cuenta) c.uniqueResult();

        return cls;
    }
}
