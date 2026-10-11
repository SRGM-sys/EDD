package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
Escriba una función recursiva que reciba una lista de Strings y un número k
que retorne una lista de Strings cuya longitud de de cada elemento sea menor 
al número k
*/

public class Ejercicio_4 {
    
    public static List<String> nuevaLista(List<String> lista, int k){
        // Primero validamos las entradas
        if(lista == null || k <= 0){
            return null;
        }
        
        // Necesito un caso base, que es cuando la lista ya se haya revisado
        // Es decir cuando queden cero elementos, tambiém cuando
        // El número k sea 1, es decir que se toman todos los de longitud cero
        if(k == 1 || lista.isEmpty()){
            return new ArrayList<>();
        }
        
        // Vamos a ir revisando elemento por elemento, así que tomamos el primero
        String elemento = lista.get(0);
        List<String> resultadoResto = nuevaLista(lista.subList(1, lista.size()), k);
        
        if(elemento != null && elemento.length() < k){
            List<String> resultado = new ArrayList<>();
            resultado.add(elemento);
            resultado.addAll(resultadoResto);
            return resultado;
        }
        
        return resultadoResto;
    }
}
