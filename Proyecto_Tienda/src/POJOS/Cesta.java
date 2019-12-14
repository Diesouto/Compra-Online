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
    @OneToMany()
    private List<Producto> productos;

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
    
    public void calcularPrecio(List<Producto> productos){
        
        float precioTotal=0;
        
        for(int i=0; i< productos.size(); i++){
            precioTotal+=productos.get(i).getPrecio();
        }
        
        System.out.print("Precio de la cesta es: " +precioTotal);
    }

}
