package fmrt.modelo;

/**
 *
 * @author rodrigo
 */
public class Ticket {
    private Long id;
    private Long numero;
    private Producto producto;
    private Empresa cliente;
    private Empresa transportista;
    private String patenteChasis;
    private String patenteSemi;
    private int tara;
    private int bruto;
    private String ingreso;
    private String egreso;
    private String observaciones;

    public Ticket() {
    }

    public Ticket(Long id, Long numero, Producto producto, Empresa cliente, 
            Empresa transportista, int tara, int bruto, String ingreso, 
            String egreso, String observaciones) {
        this.id = id;
        this.numero = numero;
        this.producto = producto;
        this.cliente = cliente;
        this.transportista = transportista;
        this.tara = tara;
        this.bruto = bruto;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Empresa getCliente() {
        return cliente;
    }

    public void setCliente(Empresa cliente) {
        this.cliente = cliente;
    }

    public Empresa getTransportista() {
        return transportista;
    }

    public void setTransportista(Empresa transportista) {
        this.transportista = transportista;
    }

    public String getPatenteChasis() {
        return patenteChasis;
    }

    public void setPatenteChasis(String patenteChasis) {
        this.patenteChasis = patenteChasis;
    }

    public String getPatenteSemi() {
        return patenteSemi;
    }

    public void setPatenteSemi(String patenteSemi) {
        this.patenteSemi = patenteSemi;
    }   

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getBruto() {
        return bruto;
    }

    public void setBruto(int bruto) {
        this.bruto = bruto;
    }
    
    public int getNeto() {
        return bruto - tara;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", numero=" + numero + ", producto=" + producto + ", cliente=" + cliente + ", transportista=" + transportista + ", tara=" + tara + ", bruto=" + bruto + ", ingreso=" + ingreso + ", egreso=" + egreso + ", observaciones=" + observaciones + '}';
    }   
}
