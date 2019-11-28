/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tienda;

import hibernate.PruebaGuardado;
import metodos.Menu;
import java.io.IOException;
import java.sql.*;
import metodos.*;
import MisExcepciones.*;
/**
 *
 * @author a18oscarbg
 */
public class Proyecto_Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        PruebaGuardado.guardarObjeto();
        
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
