/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.*;
import hibernate.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import static metodos.AccionesUsuario.getCuenta;
import static metodos.AccionesUsuario.getProducto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author a18diegoirs
 */
public class Visualizar {
    
    public static void productos(){
        Session sesion = HibernateUtil.getSession();
        Query query = sesion.createQuery("SELECT p FROM Producto p");
        List<Producto> productos = query.list();
        for(Producto producto : productos){
            System.out.println(producto.toString());
        }
        sesion.close();
        //HibernateUtil.cerrarSession();
    }
   
    
    public static void clientes(){
        Query query = HibernateUtil.getSession().createQuery("SELECT p FROM Cliente p");
        List<Cliente> clientes = query.list();
        for(Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }
        HibernateUtil.cerrarSession();
    }
    
    public static void cesta(Sesion sesion){
        Session session = HibernateUtil.getSession();
        Cuenta cuenta = getCuenta(sesion.getToken(),session);
        cuenta.getCesta().verProductos();
        System.out.println("Precio final: " +cuenta.getCesta().calcularPrecio() +"€ \n");
        session.close();
    }
}
