package Recursion;


public class Main {
    
    public static void main(String[] args){
        
        // ========== PRUEBAS EJERCICIO 1 ================
        System.out.println("Prueba 1: " + Ejercicio_1.ordenadoAlf("   "));      // False (No hay nada)       
        System.out.println("Prueba 2: " + Ejercicio_1.ordenadoAlf("azb"));      // False
        System.out.println("Prueba 3: " + Ejercicio_1.ordenadoAlf("pqrst"));    // True
        
        // ========== PRUEBAS EJERCICIO 2 ================
        System.out.println("\nPrueba 1: " + Ejercicio_2.esPotencia2(-5));       // False
        System.out.println("Prueba 2: " + Ejercicio_2.esPotencia2(256));        // True
        System.out.println("Prueba 3: " + Ejercicio_2.esPotencia2(10));         // False
        
    }
}
