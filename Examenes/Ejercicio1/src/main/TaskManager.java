package main;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskManager {
    /* Teoría: Tipos de Mapas
    - HashMap: Excelente en búsquedas por clave (O(1)), pero tiene orden caótico
    - LinkedHashMap: Excelentes en búsquedas por clave, pero sigue el orden de llegada
    - TreeMap: Su búsqueda es O(log(n)), le damos el orden que queramos (Comparator)
    */

    //Nos pide acceso rápido a las tareas por ID
    Map<Integer, Task> mapaTask;
    
    // La prioridad la define el compareTo o un Comparator
    PriorityQueue<Task> colaTask;
    
    // Aquí defino cual será el criterio de orden de mi cola
    public TaskManager(OrderCriteria oc){
        this.mapaTask = new HashMap<>();
        
        if(oc == OrderCriteria.NATURAL) this.colaTask = new PriorityQueue<>();
        else this.colaTask = new PriorityQueue<>(new PriorityDeadlineComparator());
    }
    
    public void addTask(Task task){
        mapaTask.put(task.getId(), task);
        colaTask.add(task);
    }
    
    // 1) Obtener la siguiente tarea de la cola y eliminarla
    // 2) Cambiar su estado a EN_PROGRESO
    // 3) Retorno esa tarea
    public Task getNextTask(){
        Task next = colaTask.poll();
        if(next != null) next.setEstado(Estado.EN_PROGRESO);
        return next;
    }
    
    // Asignamos como completado la tarea con el respectivo ID
    public void completeTask(int taskId){
        Task tarea = mapaTask.get(taskId);
        if(tarea != null) tarea.setEstado(Estado.COMPLETADA);
    }
    
}
