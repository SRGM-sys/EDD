
package Recursion;

/* CONTAR VOCALES
Función que recibe un String y retorna un int contando la cantidad de caracteres
*/

public class Ejercicio_3 {
    
    public static int contarVocales(String texto){
        
        if(texto == null || texto.isBlank()) return 0;
        
        char letra = Character.toLowerCase(texto.charAt(0));
        if(letra == 'a'  || letra == 'e'  || letra == 'i'  ||letra == 'o'  ||letra == 'u'){
            return 1 + contarVocales(texto.substring(1));
        }
        
        return contarVocales(texto.substring(1));
    }
    
    
    
}
