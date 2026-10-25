package Main;

import LinkedList.LSE.LinkedList;
import LinkedList.List;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("========= PRUEBA 1: removeConsecutiveDuplicates =========");
        List<Integer> listaDuplicados = new LinkedList<>();
        int[] datosDuplicados = {1, 1, 2, 3, 3, 3, 1, 4, 4};
        for (int num : datosDuplicados) listaDuplicados.addLast(num);
        
        System.out.println("Original: [1, 1, 2, 3, 3, 3, 1, 4, 4]");
        Metodos_Tarea02.removeConsecutiveDuplicates(listaDuplicados);
        System.out.print("Obtenido: ");
        imprimirLista(listaDuplicados);
        System.out.println();
        
        
        System.out.println("========= PRUEBA 2: maximosPorSecuencia =========");
        java.util.List<Integer> iterableNumeros = java.util.List.of(2, 5, 7, 1, 4, 3, 6, 8);
        
        System.out.println("Entrada:  [2, 5, 7, 1, 4, 3, 6, 8]");
        List<Integer> maximos = Metodos_Tarea02.maximosPorSecuencia(iterableNumeros);
        System.out.print("Obtenido: ");
        imprimirLista(maximos);
        System.out.println();
        
        
        System.out.println("========= PRUEBA 3: intercalar =========");
        List<Integer> lista1 = new LinkedList<>();
        List<Integer> lista2 = new LinkedList<>();
        
        int[] datos1 = {1, 3, 5, 7};
        int[] datos2 = {2, 4};
        for (int num : datos1) lista1.addLast(num);
        for (int num : datos2) lista2.addLast(num);
        
        System.out.println("Lista 1: [1, 3, 5, 7]");
        System.out.println("Lista 2: [2, 4]");
        List<Integer> intercalada = Metodos_Tarea02.intercalar(lista1, lista2);
        System.out.print("Obtenido: ");
        imprimirLista(intercalada);
        System.out.println();
        
        
        System.out.println("========= PRUEBA 4: insertarOrdenado =========");
        List<Integer> numerosOrdenados = new LinkedList<>();
        int[] datos = {3, 5, 8, 10, 12}; 
        for (int num : datos) numerosOrdenados.addLast(num);

        System.out.println("Lista original: [3, 5, 8, 10, 12]");
        System.out.println("Elemento a insertar: 9");

        // Llamada al método con la expresión lambda como tercer parámetro
        Metodos_Tarea02.insertarOrdenado(numerosOrdenados, 9, (num1, num2) -> {
            return num1 - num2; // La resta matemática que define el orden ascendente
        });

        System.out.print("Obtenido: ");
        imprimirLista(numerosOrdenados);
        System.out.println();
        
        System.out.println("========= PRUEBA 5: ordenarEstudiantes =========");
        List<Student> estudiantes = new LinkedList<>();
        estudiantes.addLast(new Student(1, "Luis", 8.5f));
        estudiantes.addLast(new Student(2, "Ana", 9.5f));
        estudiantes.addLast(new Student(3, "Pedro", 8.5f));
        estudiantes.addLast(new Student(4, "Maria", 9.0f));

        System.out.println("Lista de estudiantes original:");
        System.out.println("[Luis (8.5), Ana (9.5), Pedro (8.5), Maria (9.0)]");

        // Llamada al método con la expresión lambda como segundo parámetro
        // NOTA: String implementa Comparable, por lo tanto, ya sabe como ordenarse
        // por defecto es alfabéticamente
        Metodos_Tarea02.ordenarEstudiantes(estudiantes, (Student s1, Student s2) -> {
            // Si las notas son iguales, comparamos por nombre
            if(s1.getNota() == s2.getNota()){
                return s1.getNombre().compareTo(s2.getNombre());
            }
            
            /* Explicación:
            Devolvemos positivo si: Realizo el intercambio
            Devolvemos negativo si: No realizo nada
            
            Se exige la mayor calificación primero
            Ana(9,5) - Luis(8.5) -> En este caso no intercambio
            */
            if((s1.getNota() - s2.getNota()) > 0){
                return -1;
            } else{
                return 1;
            }
        });

        System.out.print("Obtenido: [");
        java.util.Iterator<Student> itEst = estudiantes.iterator();
        while (itEst.hasNext()) {
            Student s = itEst.next();
            System.out.print(s.getNombre() + " (" + s.getNota() + ")");
            if (itEst.hasNext()) System.out.print(", ");
        }
        System.out.println("]\n");

        
        System.out.println("========= PRUEBA 6: mejorProducto =========");
        List<Product> productos = new LinkedList<>();
        productos.addLast(new Product(1, "Mouse A", 25.0f, 4.2f));
        productos.addLast(new Product(2, "Mouse B", 20.0f, 4.5f));
        productos.addLast(new Product(3, "Mouse C", 20.0f, 4.8f));
        productos.addLast(new Product(4, "Mouse D", 30.0f, 5.0f));

        System.out.println("Lista de productos original:");
        System.out.println("[Mouse A ($25.0, 4.2), Mouse B ($20.0, 4.5), Mouse C ($20.0, 4.8), Mouse D ($30.0, 5.0)]");

        
        Product mejor  = Metodos_Tarea02.mejorProducto(productos, (Product p1, Product p2) -> {
            /* Explicación:
            Devolvemos positivo si: El actual es mejor
            Devolvemos negativo si: El actual es peor
            */
            
            if(p1.getPrecio() == p2.getPrecio()){
                if((p1.getCalificacion() - p2.getCalificacion()) > 0){
                    return 1;
                } else return -1;
            }
            
            // Invertimos el precio porque se busca el más barato, no el más caro
            if((p1.getPrecio() - p2.getPrecio()) > 0){
                return -1;
            } else return 1;
        });

        
        System.out.print("Obtenido: ");
        if (mejor != null) {
            System.out.println(mejor.getNombre());
        } else {
            System.out.println("null");
        }
        System.out.println();
    }
    
    // Método auxiliar para imprimir los resultados
    private static <E> void imprimirLista(List<E> lista) {
        System.out.print("[");
        java.util.Iterator<E> it = lista.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) System.out.print(", ");
        }
        System.out.println("]");
    }
}
