package POJOS;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@Table (name = "Cuenta")
public class Cuenta implements Serializable {
    
    @Id
    @Column (name = "correo_electronico", length = 30)
    private String correo_electronico;
    
    @Column (name = "contraseña", length = 20)
    private String contraseña;
    
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
