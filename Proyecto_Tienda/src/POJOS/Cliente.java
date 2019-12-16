/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author a18oscarbg
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
    
    @Column (name = "nombre")
    private String nombre;
    
    @Column (name = "apellidos")
    private String apellidos;
    
    @Column (name = "dni", unique = true)
    private String dni;
    
    @Id
    @Column (name = "correo_electronico", length = 50)
    private String correo_electronico;
    
    @Column (name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
    @Column (name = "telefono", unique = true)
    private String telefono;
    
    @Column (name = "direccion")
    private String direccion;
    
    @Column (name = "saldo")
    private float saldo;
    
    @ManyToMany
    private List<Factura> facturas;
    
  

    public Cliente() {
    }

    
    public Cliente(String nombre, String apellidos, String dni, String correo_electronico, Date fecha_nacimiento, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo_electronico = correo_electronico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.saldo = 0;
        this.facturas = new ArrayList<>();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public boolean gastarDinero(float gasto){
        
        boolean comprarlo = false;
        
        if((this.saldo-gasto)<0){
            System.out.println("No puedes permitirtelo.");
        }else{
            this.saldo = this.saldo-gasto;
                comprarlo = true;
        }
        
        return comprarlo;
    }
    
    public void añadirFondos(float fondos){
        this.saldo += fondos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", correo_electronico=" + correo_electronico + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", direccion=" + direccion + ", saldo=" + saldo + '}';
    } 
}