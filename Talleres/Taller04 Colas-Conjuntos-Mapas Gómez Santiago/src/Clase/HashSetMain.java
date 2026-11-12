
package clase;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class HashSetMain {
    public static void main(String[] args) {

        // Set de cadena de caracteres
        // Test 1
        // Set<String> set1 = new HashSet<>(); // la clase HashSet tiene un orden aleatorio (no tiene orden)

        // Test 2
        // Set<String> set1 = new LinkedHashSet<>(); // LinkedHashSet muestra los elementos como estos fueron insertados

        // Test 3
        Set<String> set1 = new TreeSet<>(); // La clase TreeSet muestra los elementos en orden natural

        String s = "A esta Cadena cadena es una cadena que tiene palabras repetidas es la en la misma cadena tiene palabras repetidas";
        String[] split = s.split(" ");

        System.out.println("Total palabras (con repetición): " + split.length);

        for (int i=0; i < split.length; i++){
            String palabra = split[i];
            set1.add(palabra);
            
            // Test 1
            // boolean b = set1.add(palabra);
            // System.out.println("Al insertar " + palabra + " se obtuvo: " + b);
        }

        System.out.println("Palabras en el set (únicas): " + set1.size());

        // Test 2
        // Iterar en el Set
        Iterator<String> iterator = set1.iterator();
        
        while (iterator.hasNext()){
            String e = iterator.next();
            System.out.println(e);
        }
    }
}