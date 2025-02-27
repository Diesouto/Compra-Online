/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import POJOS.*;
import hibernate.HibernateUtil;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    public static Cuenta iniciarSesion(BufferedReader lee,Sesion s) throws IOException{
        
        Session sesion =  HibernateUtil.getSession();
        Cuenta cuentaIniciada = null;
        
        System.out.println("--INICIAR SESIÓN---");
        System.out.print("Correo electrónico: ");
        String correo = lee.readLine();
        System.out.print("Contraseña: ");
        String contraseña = lee.readLine();
        
        if(correo.equalsIgnoreCase("admin") && contraseña.equalsIgnoreCase(contraseña)){
            Menu.menuAdministrador(s);
        }
        
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
    
    public static void añadirProducto(Sesion sesion){
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
    
    public static void quitarCesta(Sesion sesion) {
        
        Session session = HibernateUtil.getSession();
        Cuenta cuenta = getCuenta(sesion.getToken(),session);
        
        System.out.print("Posición del producto a eliminar: ");
        Scanner teclado = new Scanner(System.in);
        int  borrar = Integer.parseInt(teclado.nextLine());
        
        try {
            System.out.print(cuenta.getCesta().getProductos().get(borrar).toString());
            
            System.out.println("Desea eliminar este producto de la cesta?");
            String eleccion = teclado.nextLine();
            
            if(eleccion.equalsIgnoreCase("si")){
                cuenta.getCesta().quitarProducto(borrar);
                Transaction tx = session.beginTransaction();
                session.update(cuenta);
                session.flush();
                tx.commit();
                System.out.println("Se ha eliminado el producto de la cesta");
            }
            else{
                System.out.println("Borrado cancelado");
            }
        } catch(Exception e) {
            System.out.print("No hay producto en esa posición");
        }    
    }
    
    public static void vaciarCesta(Sesion sesion) {
        
        Scanner teclado = new Scanner(System.in);
        
        Session session = HibernateUtil.getSession();
        Cuenta cuenta = getCuenta(sesion.getToken(),session);
            
        System.out.println("Desea vaciar la cesta?");
        String eleccion = teclado.nextLine();
            
        if(eleccion.equalsIgnoreCase("si")){
            cuenta.getCesta().vaciarCesta();
            Transaction tx = session.beginTransaction();
            session.update(cuenta);
            session.flush();
            tx.commit();
            System.out.println("Se ha vaciado la cesta");
        }
        else{
            System.out.println("Borrado cancelado");
        }
            
    }
    
    
    public static void reducirStockCesta(Sesion sesion) throws IOException {
        
        BufferedReader lee = new BufferedReader (new InputStreamReader (System.in));
        Session session = HibernateUtil.getSession();
        Cuenta cuenta = getCuenta(sesion.getToken(),session);
        Pedido pedido = new Pedido();
        
        for(int i=0; i< cuenta.getCesta().getProductos().size(); i++){
            
            Producto producto = cuenta.getCesta().getProductos().get(i);
            producto.addListener(pedido);
            int stockPreVenta = producto.getStock();
            int stockPostVenta = stockPreVenta -1;
            
            if(pedido.isPedir()){
                    System.out.println("No hay Stock Suficiente, ¿desea realizar un pedido ahora?"
                            + "\n1.Si"
                            + "\n0.No");
                    byte op=Byte.parseByte(lee.readLine());
                    if(op==1){
                        pedido=Altas.nuevoPedido(lee, producto);
                        producto.addListener(pedido);
                        session.beginTransaction();
                        session.save(pedido);
                        session.getTransaction().commit();
                        System.out.println("\n - Pedido Registrado - \n");
                    }else
                        System.out.println("\n - Operación cancelada - \n");
                }else{
                    cuenta.getCesta().getProductos().get(i).setStock(stockPostVenta);
                }    
        }
        Transaction tx = session.beginTransaction();
        session.update(cuenta);
        session.flush();
        tx.commit();
        
    }
    
    public static void comprarCarro(Sesion sesion) throws IOException {
        
        Session session = HibernateUtil.getSession();
        Cuenta cuenta = getCuenta(sesion.getToken(),session);
        Date fecha = new Date();
        List <Producto> productosComprados = new ArrayList(cuenta.getCesta().getProductos());
        float precioTotal = cuenta.getCesta().calcularPrecio();
        
        if(cuenta.getCliente().gastarDinero(precioTotal)==true){
            Factura factura = new Factura(fecha, precioTotal, productosComprados);
            System.out.println("Comprado");
            cuenta.getCliente().getFacturas().add(factura);
            //reducirStockCesta(sesion);
            //vaciarCesta(sesion);
            Transaction tx = session.beginTransaction();
            session.save(factura);
            session.update(cuenta);
            session.flush();
            tx.commit();
        }
        else{
            System.out.println("No puedes permitirtelo.");
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
