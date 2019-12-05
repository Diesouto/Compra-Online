/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tienda;

import POJOS.Producto;
import java.io.IOException;
import hibernate.HibernateUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import metodos.Altas;
import metodos.Visualizar;
import org.hibernate.Query;
/**
 *
 * @author a18oscarbg
 */
public class Proyecto_Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String eleccion = "";
        
        Altas.crearCuenta();
        Visualizar.objeto("Cuenta");
        
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
        
        /*switch(Menu.menuInicial()){
            case 1:
                break;
        
        try{
            Connection con = DriverManager.getConnection(url);
            Statement stm = con.createStatement();

            do{
                switch(Menu.menuInicial()){
                    case 1:
                        Altas.crearCuenta();
                        break;

                    case 2:
                        break;

                    case 3:
                        salir = true;
                        break;    

                }
            }while(salir!=true);
        }catch(Exception e){
            System.out.println(e);
        }*/
    }
}
