/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.Date;
import java.io.Serializable;
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
    
    @Id
    @Column (name = "dni", unique = true)
    private String dni;
    
    @Column (name = "correo_electronico", unique = true)
    private String correo_electronico;
    
    @Column (name = "direccion")
    private Direccion direccion;
    
    @Column (name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
    @Column (name = "telefono", unique = true)
    private String telefono;
    
    @Column (name = "tarjeta")
    private Tarjeta tarjeta;

    public Cliente() {
    }

    
    public Cliente(String nombre, String apellidos, String dni, String correo_electronico, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo_electronico = correo_electronico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }
    // Este es de prueba
    public Cliente(String nombre, String apellidos, String dni, String correo_electronico, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
}
