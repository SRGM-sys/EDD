package objetos;

public class Transferencia {
    
    private String codigo;
    private String origen;
    private String destino;
    private int monto;

    public Transferencia(String codigo, String origen, String destino, int monto) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getMonto() {
        return monto;
    }
    
    
    
}
