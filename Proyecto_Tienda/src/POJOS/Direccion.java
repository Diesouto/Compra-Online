package POJOS;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Direccion implements Serializable{
    
    private String calle;
    private int num_calle;
    private int cod_postal;
    private String ciudad;
    private String pais;

    public Direccion() {
    }

    public Direccion(String calle, int num_calle, int cod_postal, String ciudad, String pais) {
        this.calle = calle;
        this.num_calle = num_calle;
        this.cod_postal = cod_postal;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNum_calle() {
        return num_calle;
    }

    public void setNum_calle(int num_calle) {
        this.num_calle = num_calle;
    }

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
