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
public class Chofer {
    
    private Long id_chofer;
    private String apellido;
    private String nombre;
    private String dni;

    public Chofer() {
    }    

    public Chofer(Long id_chofer, String apellido, String nombre, String dni) {
        this.id_chofer = id_chofer;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }    

    public long getId_chofer() {
        return id_chofer;
    }

    public void setId_chofer(Long id_chofer) {
        this.id_chofer = id_chofer;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Chofer{" + "id_chofer=" + id_chofer + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + '}';
    }   
    
}
