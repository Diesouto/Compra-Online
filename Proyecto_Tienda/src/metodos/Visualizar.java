/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.Producto;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author a18diegoirs
 */
public class Visualizar {
    
    public static void objeto(String consulta){
        Query query = HibernateUtil.getSession().createQuery("SELECT p FROM " +consulta +"p");
        List<Object> objeto = query.list();
        for(Object aux : objeto){
            System.out.println(objeto.toString());
        }
    }
}
