package main;

import java.time.LocalDateTime;

public class Task implements Comparable<Task>{
    private int id;
    private String descripcion;
    private LocalDateTime deadline; //Ya implementa comapareTo
    private int prioridad; // Esta entre [1-5]
    private int tiempo;
    private Estado estado;

    public Task(int id, String descripcion, LocalDateTime deadline, int prioridad, int tiempo) {
        this.id = id;
        this.descripcion = descripcion;
        this.deadline = deadline;
        this.prioridad = prioridad;
        this.tiempo = tiempo;
        this.estado = Estado.PENDIENTE;
    }
    
    // Aquí voy a implementar el orden natural que va a seguir la clase
    // (-1) This es menor que O
    // (1) This es mayor que O
    // El documento especifica que el orden natural es por el tiempo (Ascendente)
    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.tiempo, o.tiempo);   // Ascendente
        //return Integer.compare(o.tiempo, this.tiempo); (Descendente)
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    // TODOS LOS GETTERS:

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public Estado getEstado() {
        return estado;
    }
    
}
