package fmrt.modelo;

/**
 *
 * @author rodrigo
 */
public class Producto {
    
    private Long idProducto;
    private Long idCategoria;
    private String nombre;

    public Producto() {
    }

    public Producto(Long idProducto, Long idCategoria, String nombre) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }   
    
}
