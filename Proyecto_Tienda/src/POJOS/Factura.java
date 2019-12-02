package POJOS;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author Usuario
 */


@Entity
@Table (name = "Factura")

public class Factura implements Serializable{
    
    
    @Id @GeneratedValue
    @Column (name = "idFactura")
    private int idFactura; 
    
    @Column (name = "precio")
    private float precio; 
    
    @OneToMany (mappedBy = "Factura")
    private List<Producto> productos;
    
}
