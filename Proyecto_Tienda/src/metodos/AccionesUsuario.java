/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.Cliente;
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
    
    public static Cuenta iniciarSesion(BufferedReader lee) throws IOException{
        
        Session sesion =  HibernateUtil.getSession();
        Cuenta cuentaIniciada = null;
        
        System.out.println("--INICIAR SESIÓN---");
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        System.out.print("Contraseña: ");
        String contraseña = lee.readLine();
        
        Cuenta iniciarSesion = AccionesUsuario.getCuenta(correo, sesion);
        
        if(iniciarSesion != null){
            
            if(contraseña.equals(iniciarSesion.getContraseña())){
                System.out.println("Sesión iniciada");
                cuentaIniciada = iniciarSesion;
            }
            else{
                System.out.println("La contraseña introducida es incorrecta");
            }
        }
        else {
            System.out.println("No existe este correo");
        }
        return cuentaIniciada;
    }
    
    public static Cuenta getCuenta(String correo, Session sesion) {

        Criteria c = sesion.createCriteria(Cuenta.class);
        c.add(Restrictions.eq("correo_electronico", correo));

        Cuenta cls = (Cuenta) c.uniqueResult();

        return cls;
    }
    
    public static Cliente getCliente(String correo, Session sesion) {

        Criteria c = sesion.createCriteria(Cliente.class);
        c.add(Restrictions.eq("correo_electronico", correo));

        Cliente cls = (Cliente) c.uniqueResult();

        return cls;
    }
}
