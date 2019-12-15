/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author Xacobe
 * 
 * Esta clase maneja la sesion. Por defecto aparecemos como no logeados.
 * token es un identificador para la sesion (se piensa en usar el mail) para poder
 * reconocer al usuario.
 */
public class Sesion {
    private boolean logeado;
    private String token;
    
    public Sesion() {
        this.logeado = false;
        this.token = "guest";
    }
    
    public Sesion(String token){
        this.logeado = true;
        this.token = token;
    }
    
    

    public boolean isLogeado() {
        return logeado;
    }


    public String getToken() {
        return token;
    }

    public void logear(String token) {
        this.token = token;
        this.logeado = true;
        
    }
    
    public void logout(){
        this.token = "guest";
        this.logeado = false;  
    }
    
    
}
