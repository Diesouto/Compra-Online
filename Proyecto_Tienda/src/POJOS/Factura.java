package POJOS;

import java.io.Serializable;
import java.util.Date;
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
    
    @Column (name = "fechaCompra")
    private Date fechaCompra; 
    
    @Column (name = "precio")
    private float precio; 
    
    @OneToMany ()
    private List<Producto> productos;
    
}
