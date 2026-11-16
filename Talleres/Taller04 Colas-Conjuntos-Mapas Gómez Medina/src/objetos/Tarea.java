package objetos;

public class Tarea {
    private int id;
    private int prioridad;
    private int costo;

    public Tarea(int id, int prioridad, int costo) {
        this.id = id;
        this.prioridad = prioridad;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getCosto() {
        return costo;
    }

}
