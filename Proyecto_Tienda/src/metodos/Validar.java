/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;
import MisExcepciones.MisExcepciones;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static metodos.Altas.lee;
/**
 *
 * @author Diego
 */
public class Validar {
    
    public static String dni() throws IOException{
        
        int d = 1;
        String dni ="";
        
        do{
            try {
        
                System.out.print("DNI: ");
                dni = lee.readLine();

                if(dni.length()!=9){
                    d=1;
                    throw new MisExcepciones("Longitud Erronea");
                }

                if(dni.substring(0, 8).matches("[0-9]*")){
                    d=0;
                }else{
                    throw new MisExcepciones("Número erróneo");
                }

                if(dni.substring(8).matches("[A-Za-z]")){
                    d=0;
                }else{
                    throw new MisExcepciones("Letra errónea");
                }

            } 

            catch(MisExcepciones e){
                System.out.println(e.getError());
            }
        }while (d==1);
        
        return dni;
    }
    
    public static String telefono() throws IOException{
        
        int d = 1;
        String telefono ="";
        
        do{
            try {
                
                System.out.print("Telefono (Opcional):");
                telefono = lee.readLine();
        
                if(telefono.length()!=9){
                    d=1;
                    throw new MisExcepciones("Longitud Erronea");
                }

                if(telefono.substring(0, 9).matches("[0-9]*")){
                    d=0;
                }else{
                    throw new MisExcepciones("Número erróneo");
                }

            } 

            catch(MisExcepciones e){
                System.out.println(e.getError());
            }
        }while (d==1);
        
        return telefono;
    }
    
    public static boolean validarFechaJavi(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
          return false;
        }
        return true;
    }
    
    public static Date validarFecha() throws IOException {
        
        Date fechaVencimiento = null;
        
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            fechaVencimiento = formatoFecha.parse(lee.readLine());
            //setLenient false se usa para evitar que se puedan poner fechas incorrectas
            formatoFecha.setLenient(false);
        } catch (ParseException e) {
          System.out.println(e);
        }
        return fechaVencimiento;
    }
}


