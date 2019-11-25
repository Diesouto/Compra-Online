package POJOS;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Cuenta implements Serializable {
    
    private String contraseña;
    private String correo_electronico;
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(String contraseña, String correo_electronico, Cliente cliente) {
        this.contraseña = contraseña;
        this.correo_electronico = correo_electronico;
        this.cliente= cliente;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
    
}
