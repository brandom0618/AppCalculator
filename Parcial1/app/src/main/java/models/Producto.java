package models;

public class Producto implements Comparable<Producto>{

    private String codigoProducto;
    private String nombreProducto;
    private Integer valorProducto;
    private Boolean exentoIVA;
    private String descripcionProducto;

    public Producto() {
    }

    public Producto(String codigoProducto, String nombreProducto, Integer valorProducto, Boolean exentoIVA, String descripcionProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.valorProducto = valorProducto;
        this.exentoIVA = exentoIVA;
        this.descripcionProducto = descripcionProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(Integer valorProducto) {
        this.valorProducto = valorProducto;
    }

    public Boolean getExentoIVA() {
        return exentoIVA;
    }

    public void setExentoIVA(Boolean exentoIVA) {
        this.exentoIVA = exentoIVA;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }


    @Override
    public int compareTo(Producto o) {
        if(o.getValorProducto()>valorProducto){
            return 1;
        }else if(o.getValorProducto() > valorProducto){
            return 0;
        }else{
            return -1;
        }

    }
}
