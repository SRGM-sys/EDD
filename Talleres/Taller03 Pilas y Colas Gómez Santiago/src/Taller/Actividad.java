package Taller;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Actividad {
    
    
    public static <T> void moverTopeAlFondo(Deque<T> pila, int k){
        
        // Validaciones
        if(pila == null) return;
        
        if(k < 0 || k > pila.size()){
            throw new IllegalArgumentException("El valor de k no es válido.");
        }
        
        if(k == 0 || k == pila.size()){
            return;
        }
        
        // 
        Deque<T> aux1 = new ArrayDeque<>();
        Deque<T> aux2 = new ArrayDeque<>();
        
        // Extraemos los primeros "k" elementos
        for(int i = 0; i < k; i++){
            aux1.push(pila.pop());
        }
        
        // Extraer los elementos restantes de la pila original
        while(!pila.isEmpty()){
            aux2.push(pila.pop());
        }
        
        // Los primeros elementos estarán al inicio
        while(!aux1.isEmpty()){
            pila.push(aux1.pop());
        }
        
        // Regresar los elementos restantes a la pila original
        while(!aux2.isEmpty()){
            pila.push(aux2.pop());
        }
    }
    
    
    public static <T> int eliminarMenores(Deque<T> pila, T referencia, Comparator<T> comparador){
        if(pila == null || referencia == null || comparador == null) return 0;
        
        int eliminados = 0;
        
        Deque<T> aux = new ArrayDeque<>();

        // Vaciamos la pila original evaluando cada elemento y añadir los restantes
        // a la pila auxiliar
        while(!pila.isEmpty()){
            T actual = pila.pop();
            
            // Devuelve negativo si el actual es menor
            if(comparador.compare(actual, referencia) < 0){
                eliminados++;
            } else{
                aux.push(actual);
            }
        }
        
        // Regresamos los elementos a la pila original
        while(!aux.isEmpty()){
            pila.push(aux.pop());
        }
        
        return eliminados;
    }
    
    
    public static <T> void eliminarEnesimoMenor(Queue<T> cola, int n,
            Comparator<T> comparador){
        
            if(cola == null || cola.isEmpty() || n <= 0 || comparador == null){
                return;
            }
            
            T anterior = null;
            T objetivo = null;
            
            Queue<T> aux = new ArrayDeque<>();
            
            // Ciclo para encontrar el n-ésimo menor
            for(int i=0; i < n; i++){
                objetivo = null;
                
                // Pasamos todos los elementos a la cola auxiliar buscando el mínimo valor
                while(!cola.isEmpty()){
                    // Recuperamos y eliminamos el primer elemento
                    T elemento = cola.poll();
                    
                    boolean esMayor = true;
                    // Si el elmento actual es menor que el anterior entonces cambiamos el bool
                    if(anterior != null && comparador.compare(elemento, anterior)<=0){
                        esMayor = false;
                    }
                    
                    // Si es un candidato válido, actualizamos nuestro objetivo
                    if(esMayor){
                        if(objetivo == null || comparador.compare(elemento, objetivo) < 0){
                            objetivo = elemento;
                        }
                    }
                    
                    // Insertamos el elemento al final de la cola
                    aux.offer(elemento);
                }
                
                while(!aux.isEmpty()){
                    cola.offer(aux.poll());
                }
                
                anterior = objetivo;
            }
            
            // Una vez temrinado el ciclo, 'objetivo' tiene el enésimo menor.
            // Ahora, lo buscamos y eliminamos SOLO la primera aparición
            boolean eliminado = false;
            
            while(!cola.isEmpty()){
                T elemento = cola.poll();
                
                // Si encontramos el objetivo y no lo hemos eliminado aún
                if(!eliminado && comparador.compare(elemento, objetivo) == 0){
                    eliminado = true;
                } else{
                    aux.offer(elemento);
                }
            }
            
            // Regresamos los elementos restantes a la cola original
            while(!aux.isEmpty()){
                cola.offer(aux.poll());
            }
    }
    
    public static void reorganizarTurnos(Queue<Turno> turnos){
        // Validacion
        if(turnos == null) return;
        
        // Configuramos nuestro comparador para manejar las dos reglas
        Comparator<Turno> comparadorTurnos = new Comparator<Turno>() {
            @Override
            public int compare(Turno t1, Turno t2) {
                // Comparamos de forma descendente (t2 vs t1) ya que 5 es la prioridad más alta.
                int comparacionPrioridad = Integer.compare(t2.getPrioridad(), t1.getPrioridad());

                if (comparacionPrioridad != 0) {
                    return comparacionPrioridad;
                }
                // Utilizamos el número identificador (que refleja el orden de llegada) para desempatar de forma ascendente
                return Integer.compare(t1.getNumero(), t2.getNumero());
            }
        };
        
        PriorityQueue<Turno> colaPrioridad = new PriorityQueue<>(comparadorTurnos);

        // Vaciamos la cola original y pasamos todos los elementos a la PriorityQueue
        while (!turnos.isEmpty()) {
            colaPrioridad.offer(turnos.poll());
        }

        // Regresamos los elementos ya reorganizados a la cola original
        while (!colaPrioridad.isEmpty()) {
            turnos.offer(colaPrioridad.poll());
        }
    }
    
    
}
