/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
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
    
    @Column (name = "contadorProductos")
    private int contadorProductos;
    
    @Column (name = "productos")
    private ArrayList <Producto> productos;

    public Cesta(int id_cesta, Date fechaAñadido, int contadorProductos, ArrayList<Producto> productos) {
        this.id_cesta = id_cesta;
        this.fechaAñadido = fechaAñadido;
        this.contadorProductos = contadorProductos;
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

    public int getContadorProductos() {
        return contadorProductos;
    }

    public void setContadorProductos(int contadorProductos) {
        this.contadorProductos = contadorProductos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    public void calcularPrecio(ArrayList<Producto> productos){
        
        float precioTotal=0;
        
        for(int i=0; i< productos.size(); i++){
            precioTotal+=productos.get(i).getPrecio();
        }
        
        System.out.print("Precio de la cesta es: " +precioTotal);
    }
    
}
