package taller;

// Esta clase va a servir para poner todos los comparadores
import java.util.Comparator;
import objetos.*;

public class Comparadores {
    
    /* Lambda trabaja con interfaces funcionales, al trabajar usarla
    estamos devolviendo al objeto de la interfaz con la implementación de su
    único método
    */
    
    // Truco visual (Ascendente)  compare(e1, e2)
    // Truco visual (Descendente) compare(e2, e1)
    
    public static Comparator<TrabajoImpresion> ordenImpresion(){
        return (t1,t2) -> {
            // 1) Prioridad: Cantidad de páginas (Ascendente)
            int cmp = Integer.compare(t1.getPaginas(), t2.getPaginas());

            // 2) Prioridad: Orden de llegada (Ascendente)
            if(cmp == 0){
                cmp = Integer.compare(t1.getOrdenLlegada(), t2.getOrdenLlegada());
            }
            return cmp;
        };
    }
    
    public static Comparator<Tarea> ordenTarea(){
        return (t1, t2) ->{
            // 1) Prioridad: Por prioridad (Descendente)
            int cmp = Integer.compare(t2.getPrioridad(), t1.getPrioridad());
            
            // 2) Prioridad: Por costo (Ascendente)
            if(cmp == 0) cmp = Integer.compare(t1.getCosto(), t2.getCosto());
            
            // 3) Prioridad: Por id (Ascendente)
            else if(cmp == 0) cmp = Integer.compare(t1.getId(), t2.getId());
            
            return cmp;
        };
    }
    
}
