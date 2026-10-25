package Main;

import LinkedList.LSE.LinkedList;
import LinkedList.List;
import java.util.Comparator;
import java.util.Iterator;

// Debe modificar la lista original, no devolver una nueva
public class Metodos_Tarea02<E> {
    
    
    /* ANALISIS DE COMPLEJIDAD: EJERICIO 1
       - La validación inicial y creación de variables toman O(1).
       - El While se ejecuta 'n' veces
       - Añadir al final de una LinkedList es complejidad O(1)
       - Fuera del while existe un bucle for, en el peor de los casos
       no hay duplicados y tiene que recorrer 'n' veces
    CONCLUSIÓN: 1 + n + 1 + n = 2n + 2 ---> O(n)
    */
    public static <E> List<E> removeConsecutiveDuplicates(List<E> list) {
        // Validaciones iniciales
        if( list == null) return new LinkedList<>();
        if( list.size() <= 1) return list;
        
        // Voy a obtener la manera en que se itera esa lista
        Iterator<E> it = list.iterator();
        
        // Obtenemos el elemento de la posición [0]
        List<E> aux = new LinkedList<>(); 
        E anterior = it.next();
        aux.addLast(anterior);
        
        // Mientras pueda seguir recorriendolo
        while(it.hasNext()){
            // Obtenemos el elemento de la posición [1]
            E actual = it.next();
            
            // Si no son iguales
            if(!(actual.equals(anterior) || actual == anterior)){
                // 1) Añadimos el actual a la lista
                // 2) El anterior reemplazada el actual
                aux.addLast(actual);
            } 
            // Si no son iguales no sucede nada, solo avanzamos
            anterior = actual;
        }
        
        // Una vez terminada la revisión hacemos la limpieza de la lista orginal
        list.clear();
        for(E element: aux){
            list.addLast(element);
        }
        
        return list;
    }
    
    
    /* ANALISIS DE COMPLEJIDAD: EJERCICIO 2
        - La validación inicial y creación de variables toman O(1).
        - El bucle 'while' recorre la colección entera mediante el iterador, ejecutándose 'n' veces
        - Las operaciones internas (it.next(), la comparación <=, y maximos.addLast()) son de complejidad O(1)
        - La adición del último elemento fuera del bucle con addLast() es O(1)
    CONCLUSIÓN: 1 + n(1) + 1 = n + 2 ---> O(n)
     */
    public static List<Integer> maximosPorSecuencia(Iterable<Integer> numeros){
        // Validaciones 
        if( numeros == null) return new LinkedList<>();
        
        // Guardamos la lista asociada a ese iterable y obtenemos su iterator()
        Iterator<Integer> it = numeros.iterator();
        // Si la lista asociada esta vacia retornamos una lista vacía
        if (!it.hasNext()) return new LinkedList<>();

        Integer anterior = it.next();
        List<Integer> maximos = new LinkedList<>();
        
        while(it.hasNext()){
            Integer actual = it.next();
            // Si el número actual es menor o igual al anterior entonces termina
            // la secuencia y se añade 'anterior' a la lista.
            if(actual <= anterior){
                maximos.addLast(anterior);
            }
            // Si es el último elemento entonces
            
            // Si no se cumple entonces la secuencia sigue su camino
            anterior = actual;
        }
        
        // Aquí añadimos el último número de la lista que quedo pendiente
        maximos.addLast(anterior);
        
        return maximos;
    }
    
    
    /* ANALISIS DE COMPLEJIDAD: EJERCICIO 3
        - La validación inicial y creación de variables toman O(1).
        - El while se va a ejecutar 'n' veces, siendo 'n' la lista con tamaño mayor
        - Dentro del cilo las operaciones (hasNext(), next() y addLast()) toman O(1)
    CONCLUSIÓN: 1 + n + 1 = n + 2 ---> O(n) 
    */
    public static <E> List<E> intercalar(List<E> lista1, List<E> lista2){
        // Validaciones
        if(lista1 == null || lista2 == null || (lista1.isEmpty() && lista2.isEmpty())) return new LinkedList<>();
        
        // Creamos la lista vacía
        List<E> intercalo = new LinkedList<>();
        
        // Obtenemos la manera en que se itera la lista más grande
        Iterator<E> it1 = lista1.iterator();
        Iterator<E> it2 = lista2.iterator();
        
        // Mientras la lista más grande tenga elementos que recorrer
        while(it1.hasNext() || it2.hasNext()){
            if(it1.hasNext()) intercalo.addLast(it1.next());
            if(it2.hasNext()) intercalo.addLast(it2.next());
        }
       
        return intercalo;
    }
    
    
    
    
    /*=========================== COMPARADORES =================================
    Para trabajar con los comparadores, enviare mi parámetro Comparator desde 
    el main usando una expresión lambda
    */
    
    
    /* ANALISIS DE COMPLEJIDAD: EJERCICIO 4
    IMPORTANTE: size() es de complejidad O(1), ya que se manejo manualmente en la implementación
        - La validación inicial y creación de variables toman O(1).
        - El ciclo for se va a ejecutar 'n' veces
        - Dentro del ciclo se ejecuta el list.get(i), por si solo es O(n)
        pero se encuentra dentro de un ciclo es O(n^2)
        - Dentro del ciclo se ejecuta el list.add(i,e), por si solo es O(n)
        pero se encuentra dentro de un ciclo es O(n^2) 
    CONCLUSIÓN: 1 + n^2 + n^2 = 2n^2 + 1 ---> O(n^2) 
    */
    public static <E> void insertarOrdenado(List<E> list, E e, Comparator<E> cmp){
        // Validaciones
        if(list == null || cmp == null || e == null) return;
        
        // Vamos a recorrer la lista para ver donde podemos agregar el elemento
        // Es necesario trabajar con el índice para facilitar la añadidura
        for(int i = 0; i < list.size(); i++){
            // Obtenemos el elemento actual
            E element = list.get(i);
            
            // Si 'e' es menor que el elemento actual
            if(cmp.compare(e,element) < 0){
                list.add(i, e); 
                // Luego de añadirlo nos vamos
                return;
            }
        }
        
        // Si temrina el ciclo y no encuentra uno mayor, entonces se agrega al final
        list.addLast(e);
    }
    
    
    /* ANALISIS DE COMPLEJIDAD: EJERCICIO 5
        - La validación inicial y creación de variables toman O(1).
        - Un for dentro de otro for nos da una complejidad O(n^2)
        - Dentro del for aninado tenemos lista.get(), que también es de complejidad n
    CONCLUSIÓN: 1 + (n^2 * n) = 1 + n^3 ---> O(n^3) 
    */
    public static void ordenarEstudiantes(List<Student> list, Comparator<Student> cmp){
        // Validamos las entradas
        if(list == null || list.size() <= 1 || cmp == null) return;
        
        // Vamos a ordenar, usaré Bubble Sort
        for(int i = 0; i < list.size() - 1; i++){
            
            for(int j = 0; j < list.size() - i - 1; j++){
                Student actual = list.get(j);
                Student siguiente = list.get(j+1);
                
                if(cmp.compare(actual, siguiente) > 0){
                    // Hago el intercambio
                    list.set(j, siguiente);
                    list.set(j + 1, actual);
                }
            }
        }
    }
    
    
    /* ANALISIS DE COMPLEJIDAD: EJERCICIO 6
        - La validación inicial y creación de variables toman O(1).
        - El while se ejecuta 'n' veces
        - Dentro del while las operaciones tienen complejidad O(1)
    CONCLUSIÓN: 1 + (n*1) = 1 + n ---> O(n) 
    */
    public static Product mejorProducto(List<Product> list, Comparator<Product> cmp){
        // Validaciones
        if(list == null || cmp == null || list.isEmpty()) return null;
        
        
        // Asumire que el primero es el mayor e ire verificando con los que siguen
        Iterator<Product> it = list.iterator();
        Product mejor = it.next();
        
        while(it.hasNext()){
            Product actual = it.next();
            
            if(cmp.compare(actual, mejor) > 0){
                mejor = actual; 
            }
            
        }
        
        return mejor;
    }
    
}
