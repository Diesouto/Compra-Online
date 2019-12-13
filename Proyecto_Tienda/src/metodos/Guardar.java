/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import hibernate.HibernateUtil;
import POJOS.Cliente;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author a18oscarbg
 */
public class Guardar {
    public static void guardarObjeto(Object objeto){
      Session sesion =  HibernateUtil.getSession();
     
      Transaction tr = sesion.beginTransaction();
      sesion.save(objeto);
      tr.commit();
      sesion.close();
    }
}
