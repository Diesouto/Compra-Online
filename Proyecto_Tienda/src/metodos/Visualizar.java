/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.*;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author a18diegoirs
 */
public class Visualizar {
    
    public static void productos(){
        Query query = HibernateUtil.getSession().createQuery("SELECT p FROM Producto p");
        List<Producto> productos = query.list();
        for(Producto producto : productos){
            System.out.println(producto.toString());
        }
        HibernateUtil.cerrarSession();
    }
    
    public static void clientes(){
        Query query = HibernateUtil.getSession().createQuery("SELECT p FROM Cliente p");
        List<Cliente> clientes = query.list();
        for(Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }
        HibernateUtil.cerrarSession();
    }
}
