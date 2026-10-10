
package Recursion;

/* VER SI UN NUMERO ES POTENCIA DE 2
Un numero entero n es potencia de dos si existe un entero x tal
n == 2 elevado a x. Por ejemplo, para n = 16 debe retornar true
(2 sobre 4 = 16)
*/

public class Ejercicio_2 {
    
    public static boolean esPotencia2(int n){
        
        // Tomamos en cuenta la validación, que no debe ser un numero negativo o 0
        if(n <= 0){
            return false;
        }
        
        // Caso base, el resultado que me da el menor 'x' es 0, dando n = 1
        if(n == 1){
            return true;
        }
        
        // Si el módulo 0 entonces el número es par
        // Caso 6 -> 3 -> False 
        // Caso 16 -> 8 -> 4 -> 2 -> 1 -> True
        if(n % 2 == 0){
            // Si esto llega a 1 entonces si es potencia
            return esPotencia2(n/2);
        }
        
        return false;
    }
    
}
