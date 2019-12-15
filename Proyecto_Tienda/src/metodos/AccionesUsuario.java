/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.Cliente;
import POJOS.Cuenta;
import POJOS.Producto;
import POJOS.Sesion;
import hibernate.HibernateUtil;
import java.io.*;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    
    public static void concretarProducto(Sesion sesion){
        System.out.println("Introduce el id del producto deseado");
        Scanner teclado = new Scanner(System.in);
        String  pedido = teclado.nextLine();
        Session session = HibernateUtil.getSession();
        Producto producto = getProducto(pedido, session);
        session.close();
        if(producto!=null){
            System.out.println(producto.toString());
           
            String eleccion = "";
            do{
                System.out.println("Meter en cesta?");
                eleccion = teclado.nextLine();
                if(eleccion.equalsIgnoreCase("si")){
                    if(sesion.isLogeado()){
                        session = HibernateUtil.getSession();
                        Cuenta cuenta = getCuenta(sesion.getToken(),session);
                        Transaction tx = session.beginTransaction();
                        cuenta.getCesta().getProductos().add(producto); 
                        session.update(cuenta);
                        session.flush();
                        tx.commit();
                        System.out.println("Se ha añadido a tu cesta");
                        session.close();
                        break;
                    }else{
                        System.out.println("Debes tener una sesion iniciada para usar esta funcion.");
                        break;
                    }
                }else{
                    System.out.println("No has introducido una eleccion valida");
                }
                
            }while(!eleccion.equalsIgnoreCase("No"));
            
            
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
        c.add(Restrictions.eq("idProducto", Integer.parseInt(searchProducto)));

        Producto cls = (Producto) c.uniqueResult();

        return cls;
    }
}
