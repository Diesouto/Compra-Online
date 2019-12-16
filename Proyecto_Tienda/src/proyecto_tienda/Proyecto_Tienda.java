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
import metodos.Menu;

/**
 *
 * @author Oscar
 */
public class Proyecto_Tienda {
    public static Sesion sesion;

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        sesion = new Sesion(); //Se crea una sesion vacia (no logeado)
   
        Menu.menuPrincipal(sesion);   

        
        
    }
}
