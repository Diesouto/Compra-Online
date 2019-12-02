package POJOS;

import JavaBeans.Proveedor;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Diego
 */
@Entity
@Table (name = "Producto")
public class Producto implements Serializable{
    @Id
    @GeneratedValue
    @Column (name = "idProducto")
    private int idProducto;
    
    @Column (name = "precio", length = 5)
    private float precio;
    
    @Column (name = "stock", length = 5)
    private int stock;
    
    @Column (name = "nombre", length = 15)
    private String nombre;
    
    @Column (name = "descripcion")
    private String descripcion;
    
    @Column (name = "proveedor")
    private Proveedor proveedor;

    public Producto(int idProducto, float precio, int stock, String nombre, String descripcion, Proveedor proveedor) {
        this.idProducto = idProducto;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
