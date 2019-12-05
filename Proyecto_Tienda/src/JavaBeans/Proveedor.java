package JavaBeans;

import POJOS.Direccion;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@Table (name = "Proveedor")
public class Proveedor implements Serializable {
    
    @Id
    @Column (name = "nombre")
    private String nombre;
    
    @OneToOne (cascade = CascadeType.ALL)
    private Direccion direccion;
    
    @Column (name = "telefono")
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(String nombre, Direccion direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
