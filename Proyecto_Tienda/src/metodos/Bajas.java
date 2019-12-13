package metodos;

import POJOS.Cliente;
import POJOS.Producto;
import hibernate.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class Bajas {
 
    public static BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
    
     public static void bajaProducto () throws IOException {
        
        Producto producto;
        Session sesion;
        int idProducto;
        
        

        sesion = HibernateUtil.getSession();
        
        try{
            System.out.println("Introduzca el id del producto que desea eliminar");
            idProducto = Integer.parseInt(lee.readLine());
            
            producto=(Producto)sesion.get(Producto.class, idProducto);
            
            if(producto!=null){

                if(Menu.menuConfirmar(lee)==1)
                {
                    sesion.beginTransaction();
                    sesion.delete(producto);
                    sesion.getTransaction().commit();
                    System.out.println("\n Producto eliminado \n");
                }
            }else
                System.out.println("\n Producto no encontrado \n");

            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        sesion.close();  
    }
     
     public static void bajaCliente (BufferedReader lee) throws IOException {
        
        Cliente cliente;
        Session sesion;
        String correo;
        
        
        sesion = HibernateUtil.getSession();
        
        try{
            System.out.println("Introduzca correo del cliente a eliminar");
            correo = lee.readLine();
            
            cliente = (Cliente)sesion.get(Cliente.class, correo);
            
            if(cliente!=null){

                if(Menu.menuConfirmar(lee)==1)
                {
                    sesion.beginTransaction();
                    sesion.delete(cliente);
                    sesion.getTransaction().commit();
                    System.out.println("\n Cliente eliminado \n");
                }
            }else
                System.out.println("\n Cliente no encontrado \n");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }  
        sesion.close();
    }
}
