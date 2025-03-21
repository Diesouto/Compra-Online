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
    
    @ManyToMany ()
    private List<Producto> productos;

    public Factura() {
    }
    
    public Factura(Date fechaCompra, float precio, List<Producto> productos) {
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.productos = productos;
    }
    
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
