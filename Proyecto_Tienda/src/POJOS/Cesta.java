/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Diego
 */
@Entity
@Table (name = "Cesta")
public class Cesta implements Serializable{
    
    @Id
    @GeneratedValue
    @Column (name = "id_cesta")
    private int id_cesta;
    
    @Column (name = "fechaAñadido")
    private Date fechaAñadido;
    
    /*No se pueden usar ArrayList en los mapeos*/
    @ManyToMany()
    private List<Producto> productos;

    public Cesta() {
    }    

    public Cesta(int id_cesta, Date fechaAñadido, List<Producto> productos) {
        this.id_cesta = id_cesta;
        this.fechaAñadido = fechaAñadido;
        this.productos = new ArrayList <>();
    }
    
    public Cesta( Date fechaAñadido, List<Producto> productos) {
        this.fechaAñadido = fechaAñadido;
        this.productos = new ArrayList <>();
    }

    public int getId_cesta() {
        return id_cesta;
    }

    public void setId_cesta(int id_cesta) {
        this.id_cesta = id_cesta;
    }

    public Date getFechaAñadido() {
        return fechaAñadido;
    }

    public void setFechaAñadido(Date fechaAñadido) {
        this.fechaAñadido = fechaAñadido;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public float calcularPrecio(){
        
        float precioTotal=0;
        
        for(int i=0; i< productos.size(); i++){
            precioTotal+=productos.get(i).getPrecio();
        }
        
        return precioTotal;
    }
    
    public void verProductos() {
        System.out.println("--TU CESTA--");
        for(int i=0; i< productos.size(); i++){
            System.out.println(i +": " +productos.get(i).toStringLite());
        }
    }
    
    public void añadirProducto(Producto producto){
        productos.add(producto);
    }
    
    public void quitarProducto(int posicion){
        productos.remove(posicion);
    }
    
    public void vaciarCesta() {
        productos.clear();
    }
}
