package metodos;

import POJOS.Cliente;
import hibernate.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class Modificar {
 
    public static BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
    
    public static void modificar () throws IOException {
        
        String correo, nombre, apellidos, correo_nuevo, dni, telefono;
        Date fecha_nacimiento = null;
        Cliente cliente;
        Session sesion;
        
        
        sesion = HibernateUtil.getSession();
        
        try{
            System.out.println("Introduzca el correo del cliente a modificar");
            correo = lee.readLine();
            
            cliente =(Cliente)sesion.get(Cliente.class, correo);
            
            if(cliente!=null){
                
                sesion.beginTransaction();
                
                switch(Menu.menuUsuario(lee)){
                    case 1:
                        System.out.println("Introducir nuevo nombre:");
                        nombre = lee.readLine();
                        cliente.setNombre(nombre);
                        break;
                    case 2:
                        System.out.println("Introducir nuevos apellidos");
                        apellidos = lee.readLine();
                        cliente.setApellidos(apellidos);
                        break;
                    case 3:
                        System.out.println("Introducir nuevo correo");
                        correo_nuevo = lee.readLine();
                        cliente.setCorreo_electronico(correo_nuevo);
                        break;
                    case 4:
                        System.out.println("Introduce nuevo dni");
                        dni = Validar.dni();
                        cliente.setDni(dni);
                        break;
                    case 5:
                        //Incompleto
                        System.out.println("Introduce nueva fecha de nacimiento")
                        cliente.setFecha_nacimiento(fecha_nacimiento);
                        break;
                    case 6:
                        System.out.println("Introduce nueva dirección");
                        //Incompleto
                        break;
                    case 7:
                        System.out.println("Introduce nuevo usuario");
                        //Incompleto
                        break;
                    case 8:
                        System.out.println("Introduce nuevo telefono");
                        telefono = Validar.telefono();
                        cliente.setTelefono(telefono);
                        break;
                    case 9:
                        System.out.println("Introduce nueva tarjeta");
                        //Incompleto
                        break;
                    case 10:
                        Menu.menuPrincipal();
                }
                sesion.getTransaction().commit();
                System.out.println("Cliente actualizado");
            }else
                System.out.println("\n No se ha encontrado ningun cliente con ese correo electronico \n");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        sesion.close();
    }
}
