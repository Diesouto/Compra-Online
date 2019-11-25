/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class Cesta {
    
    private int id_cesta;
    private Date fechaAñadido;
    private int contadorProductos;
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
        for(int i: productos){
            
        }
    }
    
}
