package POJOS;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author a16f.jls
 */
public class Tarjeta implements Serializable {
    
    private String num_tarjeta;
    private int clave;
    private Date fecha_vencimiento;
    private String nombre_propiet;

    public Tarjeta() {
    }

    public Tarjeta(String num_tarjeta, int clave, Date fecha_vencimiento, String nombre_propiet) {
        this.num_tarjeta = num_tarjeta;
        this.clave = clave;
        this.fecha_vencimiento = fecha_vencimiento;
        this.nombre_propiet = nombre_propiet;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getNombre_propiet() {
        return nombre_propiet;
    }

    public void setNombre_propiet(String nombre_propiet) {
        this.nombre_propiet = nombre_propiet;
    }
    
    
    
}
