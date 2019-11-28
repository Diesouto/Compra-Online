/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tienda;

import POJOS.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author a18oscarbg
 */
public class PruebaGuardado {
    public static void guardarObjeto(){
      Session sesion =  HibernateUtil.getSession();
      
      Cliente javi = new Cliente("javi", "lorenzo", "77701083R", "javilorenzo@gmail.com","666666666");
      Transaction tr = sesion.beginTransaction();
      sesion.save(javi);
      tr.commit();
    }
}
