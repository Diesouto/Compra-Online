package POJOS;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
    
    @Column (name = "nombre", length = 30)
    private String nombre;
    
    @Column (name = "descripcion")
    private String descripcion;
    
    private PropertyChangeSupport propertySupport;
    private int stockMinimo = 0;

    public Producto() {
    }

    public Producto(float precio, int stock, String nombre, String descripcion) {
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.propertySupport = new PropertyChangeSupport(this);
        this.stockMinimo = 0;
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
    
    public void setStock(int valorNuevo) {
        
        if(valorNuevo<stockMinimo)
            propertySupport.firePropertyChange("stockActual",stock,valorNuevo);
        else 
            stock=valorNuevo;
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

    
    public String toStringLite() {
        return "\n\tNombre: " + nombre + 
               "\n\tPrecio: " +precio;
    }

    @Override
    public String toString() {
        return "Producto de Id: " + idProducto 
                + "\n\tPrecio: " + precio 
                + "\n\tStock: " + stock 
                + "\n\tNombre: " + nombre 
                + "\n\tDescripcion: " + descripcion+"\n";
    }
    
    public void addListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
