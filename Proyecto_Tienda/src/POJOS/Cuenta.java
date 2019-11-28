package POJOS;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Usuario
 */
@Entity
public class Cuenta implements Serializable {
    private String contraseña;
    
    @Id
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
