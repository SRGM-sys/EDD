package Recursion;

/* VER SI UNA PALABRA ESTA ORDENADA ALFABETICAMENTE
Cree una función que verifique si una palabra esta ordenada alfabéticamente
*/

public class Ejercicio_1 {
    
    public static boolean ordenadoAlf(String texto){
        
        // Primera verificación importante, SI ES NULO o la cadena esta en blanco
        if(texto == null || texto.isBlank()) return false;
        
        // Caso base (Creo que es cuando ya revise toda la cadena y me queda un caracter
        if(texto.length() == 1) return true;
        
        // Verificamos si la primera letra es menor que la siguiente
        if(texto.charAt(0) < texto.charAt(1)){
            return ordenadoAlf(texto.substring(1));
        }

        return false;
    }
}
