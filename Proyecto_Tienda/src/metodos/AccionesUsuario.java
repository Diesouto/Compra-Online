/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.Cliente;
import POJOS.Cuenta;
import POJOS.Producto;
import hibernate.HibernateUtil;
import java.io.*;
import java.util.Scanner;
import org.hibernate.Criteria;
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
    
    public static void concretarPedido(){
        System.out.println("Introduce el id del producto deseado");
        Scanner teclado = new Scanner(System.in);
        String  pedido = teclado.nextLine();
        Session sesion = HibernateUtil.getSession();
        Producto producto = getProducto(pedido, sesion);
        sesion.close();
        if(producto!=null){
            System.out.println(producto.toString());
            System.out.println("Meter en cesta?");
            String eleccion = "";
            do{
                eleccion = teclado.nextLine();
                if(eleccion.equalsIgnoreCase("si")){
                    //Sin finalizar

                }
            }while(eleccion.equalsIgnoreCase("No"));
            
            
        }else{
            System.out.println("No existe tal producto, intentelo de nuevo...");
        }
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
    
    public static Producto getProducto(String searchProducto, Session sesion){
        
        Criteria c = sesion.createCriteria(Producto.class);
        c.add(Restrictions.eq("idProducto", searchProducto));

        Producto cls = (Producto) c.uniqueResult();

        return cls;
    }
}
