/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tienda;

import POJOS.*;
import java.io.IOException;
import hibernate.HibernateUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import metodos.AccionesUsuario;
import metodos.Altas;
import metodos.Menu;
import metodos.Modificar;
import metodos.Visualizar;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author a18oscarbg
 */
public class Proyecto_Tienda {
    public static Sesion sesion;

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        sesion = new Sesion(); //Se crea una sesion vacia (no logeado)
        
        //Se muestra el menu principal
        Menu.menuPrincipal(sesion);
        
        
        
        Cuenta cuenta = AccionesUsuario.iniciarSesion(lee);
        if( cuenta != null){
            sesion = new Sesion(cuenta.getCorreo_electronico());
        }
        
        //Altas.crearCuenta();
        HibernateUtil.cerrarSession();
        /*
        Query query = HibernateUtil.getSession().createQuery("SELECT p FROM Producto p");
        List<Producto> productos = query.list();
        for(Producto producto : productos){
            System.out.println(producto.toString());
        }
        
        /*do{
        //int id;
        
        float precio = Float.parseFloat(lee.readLine());
        int stock = Integer.parseInt(lee.readLine());
        String nombre = lee.readLine();
        String descripcion = lee.readLine();
        
        Producto nuevo = new Producto(precio, stock, nombre, descripcion);
        PruebaGuardado.guardarObjeto(nuevo);
        eleccion = lee.readLine();
        }while(eleccion.equalsIgnoreCase("si"));
        HibernateUtil.cerrarSession();*/
        
        
        
        
        /*Tarjeta tarjeta_javi = new Tarjeta("7845894598947584", 764, null, "Javier Lorenzo");
        Cliente javi = new Cliente("javi", "lorenzo", "77701083R", "javilorenzo@gmail.com","666666666");
        ArrayList<Tarjeta> tarjeta = new ArrayList<>();
        //PruebaGuardado.guardarObjeto(tarjeta_javi);
        javi.setTarjetas(tarjeta);
        javi.getTarjetas().add(tarjeta_javi);
        PruebaGuardado.guardarObjeto(javi);*/
        
        
    }
}
