package main;

import java.time.LocalDateTime;
import java.util.Comparator;

public class PriorityDeadlineComparator implements Comparator<Task>{

    /* Criterios de ordenamiento
    1) Por prioridad (Descendente)
    2) Por deadline  (Ascendente)
    3) Por tiempo    (Ascendente)
    */
    @Override
    public int compare(Task o1, Task o2) {
        int bandera = Integer.compare(o2.getPrioridad(), o1.getPrioridad());
        if(bandera == 0) bandera = o1.getDeadline().compareTo(o2.getDeadline());
        if(bandera == 0) bandera = Integer.compare(o1.getTiempo(), o2.getTiempo());
        return bandera;
    }
    
}
