package Ejercicio2;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Task implements Comparable<Task>{
    private int ID;
    private String descripcion;
    private LocalDateTime deadline;
    private int prioridad;
    private int horas;
    private Estado estado;

    public Task(int ID, String descripcion, LocalDateTime deadline, int prioridad, int horas) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.deadline = deadline;
        this.prioridad = prioridad;
        this.horas = horas;
        this.estado = Estado.PENDIENTE;
    }
    
    
    // Vamos a implmentar una clase anónima 
    public static final Comparator<Task> priorityDeadLineComparator = new Comparator<>(){
        @Override
        public int compare(Task t1, Task t2) {
            int bandera = Integer.compare(t2.prioridad, t1.prioridad);
            if(bandera == 0) bandera = t1.deadline.compareTo(t2.deadline);
            if(bandera == 0) bandera = Integer.compare(t1.horas, t2.horas);
            return bandera;
        }
    };

    @Override
    public int compareTo(Task o) {
            return Integer.compare(this.ID, o.ID);
    }
}
