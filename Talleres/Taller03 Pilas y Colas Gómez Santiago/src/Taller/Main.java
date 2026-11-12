package Taller;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("=== PRUEBAS DEL TALLER 03 ===");
        
        // ---------------------------------------------------------
        // PRUEBA EJERCICIO 1: moverTopeAlFondo
        // ---------------------------------------------------------
        System.out.println("\n--- EJERCICIO 1 ---");
        Deque<Integer> pila1 = new ArrayDeque<>();
        pila1.push(50);
        pila1.push(40);
        pila1.push(30);
        pila1.push(20);
        pila1.push(10);
        
        System.out.println("Pila original (Tope a la izquierda): " + pila1);
        Actividad.moverTopeAlFondo(pila1, 2);
        System.out.println("Pila luego de moverTopeAlFondo(k=2): " + pila1);
        // Salida esperada: [30, 40, 50, 10, 20]

        // ---------------------------------------------------------
        // PRUEBA EJERCICIO 2: eliminarMenores
        // ---------------------------------------------------------
        System.out.println("\n--- EJERCICIO 2 ---");
        Deque<Integer> pila2 = new ArrayDeque<>();
        pila2.push(10);
        pila2.push(2);
        pila2.push(5);
        pila2.push(12);
        pila2.push(3);
        pila2.push(8); 
        
        System.out.println("Pila original (Tope a la izquierda): " + pila2);
        
        // Crearé un comparador simple para enteros
        Comparator<Integer> compEnteros = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };
        
        int eliminados = Actividad.eliminarMenores(pila2, 6, compEnteros);
        System.out.println("Elementos eliminados (esperado 3): " + eliminados); 
        System.out.println("Pila luego de eliminar menores a 6: " + pila2);
        // Salida esperada: [8, 12, 10]

        // ---------------------------------------------------------
        // PRUEBA EJERCICIO 3: eliminarEnesimoMenor
        // ---------------------------------------------------------
        System.out.println("\n--- EJERCICIO 3 ---");
        Queue<Integer> cola3 = new LinkedList<>();
        // Orden de llegada: [7, 3, 5, 2, 5, 9, 4]
        cola3.offer(7);
        cola3.offer(3);
        cola3.offer(5);
        cola3.offer(2);
        cola3.offer(5);
        cola3.offer(9);
        cola3.offer(4);
        
        System.out.println("Cola original: " + cola3);
        Actividad.eliminarEnesimoMenor(cola3, 4, compEnteros); // n = 4, debe eliminar el primer 5
        System.out.println("Cola luego de eliminar el 4to menor: " + cola3);
        // Salida esperada: [7, 3, 2, 5, 9, 4]

        // ---------------------------------------------------------
        // PRUEBA EJERCICIO 4: reorganizarTurnos
        // ---------------------------------------------------------
        System.out.println("\n--- EJERCICIO 4 ---");
        Queue<Turno> colaTurnos = new LinkedList<>();
        colaTurnos.offer(new Turno(1, "Ana", 2));
        colaTurnos.offer(new Turno(2, "Luis", 5));
        colaTurnos.offer(new Turno(3, "Marta", 3));
        colaTurnos.offer(new Turno(4, "Pedro", 5));
        colaTurnos.offer(new Turno(5, "Sofia", 1));
        
        System.out.println("Cola de turnos original (Llegada):");
        for (Turno t : colaTurnos) {
            System.out.println(t.getNumero() + " | " + t.getNombre() + " | " + t.getPrioridad());
        }
        
        Actividad.reorganizarTurnos(colaTurnos);
        
        System.out.println("\nCola de turnos reorganizada (Atencion):");
        for (Turno t : colaTurnos) {
            System.out.println(t.getNombre() + " | Prioridad: " + t.getPrioridad());
        }
        // Salida esperada: Luis, Pedro, Marta, Ana, Sofia
    }

}