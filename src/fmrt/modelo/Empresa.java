/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmrt.modelo;

/**
 *
 * @author rodrigo
 */
public class Empresa {
    
    private Long id;
    private String nombre;
    private String cuil;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private String codigoPostal;

    public Empresa() {
    }

    public Empresa(Long id, String nombre, String cuil, String direccion, String localidad, String provincia, String pais, String codigoPostal) {
        this.id = id;
        this.nombre = nombre;
        this.cuil = cuil;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa{id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", cuil=").append(cuil);
        sb.append(", direccion=").append(direccion);
        sb.append(", localidad=").append(localidad);
        sb.append(", provincia=").append(provincia);
        sb.append(", pais=").append(pais);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
