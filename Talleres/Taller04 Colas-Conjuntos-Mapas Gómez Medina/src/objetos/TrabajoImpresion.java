package objetos;

public class TrabajoImpresion {
    private String codigo;
    private int paginas;
    private int ordenLlegada;

    public TrabajoImpresion(String codigo, int paginas, int ordenLlegada) {
        this.codigo = codigo;
        this.paginas = paginas;
        this.ordenLlegada = ordenLlegada;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getOrdenLlegada() {
        return ordenLlegada;
    }

    
    
}
