package POJOS;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table (name = "Pedido")
public class Pedido implements Serializable, PropertyChangeListener {
    
    @Id
    @GeneratedValue
    @Column (name = "idPedido")
    private int id;
    
    @Column (name = "cantidad")
    private int cantidad;
    
    @Column (name = "fechaPedido")
    private Date fechaPedido;
    
    @OneToOne ()
    private Producto producto;
    
    private boolean pedir = false;
    
    public Pedido () {}
    
    public Pedido (int cantidad, Date fechaPedido, Producto producto) {
        
        this.cantidad=cantidad;
        this.fechaPedido=fechaPedido;
        this.producto=producto;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public boolean isPedir() {
        return pedir;
    }

    public void setPedir(boolean pedir) {
        this.pedir = pedir;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Stock Anterior:"+evt.getOldValue());
        System.out.println("Stock Nuevo:"+evt.getNewValue());
        setPedir(true);
    }
    
    

}
