package Listas;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("==================================================");
        System.out.println("          1. PRUEBAS DE findMin()                 ");
        System.out.println("==================================================");
        
        // Ejemplo 1: Lista normal de enteros positivos
        ArrayList<Integer> minEj1 = new ArrayList<>();
        minEj1.addLast(100); minEj1.addLast(250); minEj1.addLast(80); minEj1.addLast(400); minEj1.addLast(150);
        System.out.println("Ej 1 - Lista: " + minEj1.toString() + " -> Minimo: " + minEj1.findMin());
        
        // Ejemplo 2: Lista con numeros negativos
        ArrayList<Integer> minEj2 = new ArrayList<>();
        minEj2.addLast(-10); minEj2.addLast(5); minEj2.addLast(-50); minEj2.addLast(0); minEj2.addLast(20);
        System.out.println("Ej 2 - Lista: " + minEj2.toString() + " -> Minimo: " + minEj2.findMin());
        
        // Ejemplo 3: Lista con elementos repetidos
        ArrayList<Integer> minEj3 = new ArrayList<>();
        minEj3.addLast(5); minEj3.addLast(5); minEj3.addLast(5); minEj3.addLast(5); minEj3.addLast(5);
        System.out.println("Ej 3 - Lista: " + minEj3.toString() + " -> Minimo: " + minEj3.findMin());
        
        // Ejemplo 4: Lista de Strings (orden alfabetico)
        ArrayList<String> minEj4 = new ArrayList<>();
        minEj4.addLast("Zorro"); minEj4.addLast("Abeja"); minEj4.addLast("Gato"); minEj4.addLast("Perro"); minEj4.addLast("Burro");
        System.out.println("Ej 4 - Lista: " + minEj4.toString() + " -> Minimo: " + minEj4.findMin());
        
        // Ejemplo 5: Lista vacia
        ArrayList<Integer> minEj5 = new ArrayList<>();
        System.out.println("Ej 5 - Lista vacia: " + minEj5.toString() + " -> Minimo: " + minEj5.findMin());


        System.out.println("\n==================================================");
        System.out.println("          2. PRUEBAS DE countAbove()              ");
        System.out.println("==================================================");
        
        ArrayList<Integer> countLista = new ArrayList<>();
        countLista.addLast(10); countLista.addLast(20); countLista.addLast(30); countLista.addLast(40); countLista.addLast(50);
        System.out.println("Lista base: " + countLista.toString());
        
        // Ejemplo 1: Valor intermedio
        System.out.println("Ej 1 - Mayores a 25: " + countLista.countAbove(25));
        
        // Ejemplo 2: Valor superior al maximo (ninguno lo supera)
        System.out.println("Ej 2 - Mayores a 100: " + countLista.countAbove(100));
        
        // Ejemplo 3: Valor inferior al minimo (todos lo superan)
        System.out.println("Ej 3 - Mayores a 0: " + countLista.countAbove(0));
        
        // Ejemplo 4: Valor igual a un elemento (no lo debe contar porque es estrictamente mayor)
        System.out.println("Ej 4 - Mayores a 40: " + countLista.countAbove(40));
        
        // Ejemplo 5: Lista vacia
        ArrayList<Integer> countVacia = new ArrayList<>();
        System.out.println("Ej 5 - En lista vacia, mayores a 10: " + countVacia.countAbove(10));


        System.out.println("\n==================================================");
        System.out.println("          3. PRUEBAS DE sortDescending()          ");
        System.out.println("==================================================");
        
        // Ejemplo 1: Lista desordenada
        ArrayList<Integer> sortEj1 = new ArrayList<>();
        sortEj1.addLast(10); sortEj1.addLast(50); sortEj1.addLast(20); sortEj1.addLast(40); sortEj1.addLast(30);
        System.out.print("Ej 1 - Antes: " + sortEj1.toString()); sortEj1.sortDescending(); System.out.println(" -> Despues: " + sortEj1.toString());
        
        // Ejemplo 2: Lista ya ordenada descendentemente
        ArrayList<Integer> sortEj2 = new ArrayList<>();
        sortEj2.addLast(50); sortEj2.addLast(40); sortEj2.addLast(30); sortEj2.addLast(20); sortEj2.addLast(10);
        System.out.print("Ej 2 - Antes: " + sortEj2.toString()); sortEj2.sortDescending(); System.out.println(" -> Despues: " + sortEj2.toString());
        
        // Ejemplo 3: Lista ordenada ascendentemente (peor caso)
        ArrayList<Integer> sortEj3 = new ArrayList<>();
        sortEj3.addLast(1); sortEj3.addLast(2); sortEj3.addLast(3); sortEj3.addLast(4); sortEj3.addLast(5);
        System.out.print("Ej 3 - Antes: " + sortEj3.toString()); sortEj3.sortDescending(); System.out.println(" -> Despues: " + sortEj3.toString());
        
        // Ejemplo 4: Lista de Strings
        ArrayList<String> sortEj4 = new ArrayList<>();
        sortEj4.addLast("A"); sortEj4.addLast("Z"); sortEj4.addLast("M"); sortEj4.addLast("B"); sortEj4.addLast("Y");
        System.out.print("Ej 4 - Antes: " + sortEj4.toString()); sortEj4.sortDescending(); System.out.println(" -> Despues: " + sortEj4.toString());
        
        // Ejemplo 5: Lista vacia
        ArrayList<Integer> sortEj5 = new ArrayList<>();
        System.out.print("Ej 5 - Antes: " + sortEj5.toString()); sortEj5.sortDescending(); System.out.println(" -> Despues: " + sortEj5.toString());


        System.out.println("\n==================================================");
        System.out.println("          4. PRUEBAS DE splitQueue()              ");
        System.out.println("==================================================");
        
        ArrayList<Integer> splitLista = new ArrayList<>();
        splitLista.addLast(1); splitLista.addLast(2); splitLista.addLast(3); splitLista.addLast(4); splitLista.addLast(5); splitLista.addLast(6); splitLista.addLast(7);
        System.out.println("Lista base: " + splitLista.toString());
        
        // Ejemplo 1: Grupos exactos (tamaño 2, lista de 6 elementos si quitamos 1)
        ArrayList<Integer> splitListaPar = new ArrayList<>();
        splitListaPar.addLast(1); splitListaPar.addLast(2); splitListaPar.addLast(3); splitListaPar.addLast(4); splitListaPar.addLast(5); splitListaPar.addLast(6);
        System.out.println("Ej 1 - Grupos de 2 (Exactos): " + splitListaPar.splitQueue(2).toString());
        
        // Ejemplo 2: Grupos con sobrante (tamaño 3 en lista de 7 elementos)
        System.out.println("Ej 2 - Grupos de 3 (Sobra 1): " + splitLista.splitQueue(3).toString());
        
        // Ejemplo 3: groupSize mayor al tamaño total de la lista
        System.out.println("Ej 3 - Grupos de 10: " + splitLista.splitQueue(10).toString());
        
        // Ejemplo 4: Parametro invalido (negativo o cero)
        System.out.println("Ej 4 - Parametro invalido (-5): " + splitLista.splitQueue(-5));
        
        // Ejemplo 5: Lista vacia
        ArrayList<Integer> splitVacia = new ArrayList<>();
        System.out.println("Ej 5 - Lista vacia, grupos de 2: " + splitVacia.splitQueue(2).toString());


        System.out.println("\n==================================================");
        System.out.println("          5. PRUEBAS DE moveLastToFirst()         ");
        System.out.println("==================================================");
        
        // Ejemplo 1: Lista normal
        ArrayList<Integer> moveEj1 = new ArrayList<>();
        moveEj1.addLast(1); moveEj1.addLast(2); moveEj1.addLast(3); moveEj1.addLast(4); moveEj1.addLast(5);
        System.out.print("Ej 1 - Antes: " + moveEj1.toString()); moveEj1.moveLastToFirst(); System.out.println(" -> Despues: " + moveEj1.toString());
        
        // Ejemplo 2: Lista de dos elementos
        ArrayList<Integer> moveEj2 = new ArrayList<>();
        moveEj2.addLast(10); moveEj2.addLast(20);
        System.out.print("Ej 2 - Antes: " + moveEj2.toString()); moveEj2.moveLastToFirst(); System.out.println(" -> Despues: " + moveEj2.toString());
        
        // Ejemplo 3: Lista de un solo elemento (no debe alterarse)
        ArrayList<Integer> moveEj3 = new ArrayList<>();
        moveEj3.addLast(99);
        System.out.print("Ej 3 - Antes: " + moveEj3.toString()); moveEj3.moveLastToFirst(); System.out.println(" -> Despues: " + moveEj3.toString());
        
        // Ejemplo 4: Lista con elementos identicos
        ArrayList<Integer> moveEj4 = new ArrayList<>();
        moveEj4.addLast(5); moveEj4.addLast(5); moveEj4.addLast(5); moveEj4.addLast(5);
        System.out.print("Ej 4 - Antes: " + moveEj4.toString()); moveEj4.moveLastToFirst(); System.out.println(" -> Despues: " + moveEj4.toString());
        
        // Ejemplo 5: Lista vacia
        ArrayList<Integer> moveEj5 = new ArrayList<>();
        System.out.print("Ej 5 - Antes: " + moveEj5.toString()); moveEj5.moveLastToFirst(); System.out.println(" -> Despues: " + moveEj5.toString());


        System.out.println("\n==================================================");
        System.out.println("          6. PRUEBAS DE replace()                 ");
        System.out.println("==================================================");
        
        // Ejemplo 1: Reemplazar un elemento que aparece multiples veces
        ArrayList<String> repEj1 = new ArrayList<>();
        repEj1.addLast("A"); repEj1.addLast("B"); repEj1.addLast("A"); repEj1.addLast("C"); repEj1.addLast("A");
        System.out.print("Ej 1 - Antes: " + repEj1.toString()); repEj1.replace("A", "Z"); System.out.println(" -> Reemplazar 'A' con 'Z': " + repEj1.toString());
        
        // Ejemplo 2: Reemplazar todos los elementos de la lista
        ArrayList<String> repEj2 = new ArrayList<>();
        repEj2.addLast("X"); repEj2.addLast("X"); repEj2.addLast("X");
        System.out.print("Ej 2 - Antes: " + repEj2.toString()); repEj2.replace("X", "Y"); System.out.println(" -> Reemplazar 'X' con 'Y': " + repEj2.toString());
        
        // Ejemplo 3: Elemento a reemplazar no existe
        ArrayList<String> repEj3 = new ArrayList<>();
        repEj3.addLast("A"); repEj3.addLast("B"); repEj3.addLast("C");
        System.out.print("Ej 3 - Antes: " + repEj3.toString()); repEj3.replace("M", "Z"); System.out.println(" -> Reemplazar 'M' con 'Z': " + repEj3.toString());
        
        // Ejemplo 4: Intento de reemplazar con valor nulo (asumiendo que tu metodo lo valida)
        ArrayList<String> repEj4 = new ArrayList<>();
        repEj4.addLast("A"); repEj4.addLast("B"); repEj4.addLast("C");
        System.out.print("Ej 4 - Antes: " + repEj4.toString()); repEj4.replace(null, "Z"); System.out.println(" -> Reemplazar null con 'Z': " + repEj4.toString());
        
        // Ejemplo 5: Lista vacia
        ArrayList<String> repEj5 = new ArrayList<>();
        System.out.print("Ej 5 - Antes: " + repEj5.toString()); repEj5.replace("A", "B"); System.out.println(" -> Reemplazar en vacia: " + repEj5.toString());


        System.out.println("\n==================================================");
        System.out.println("          7. PRUEBAS DE isPalindrome()            ");
        System.out.println("==================================================");
        
        // Ejemplo 1: Palindromo impar
        ArrayList<String> palEj1 = new ArrayList<>();
        palEj1.addLast("A"); palEj1.addLast("B"); palEj1.addLast("C"); palEj1.addLast("B"); palEj1.addLast("A");
        System.out.println("Ej 1 - Lista: " + palEj1.toString() + " -> Es palindromo?: " + palEj1.isPalindrome());
        
        // Ejemplo 2: Palindromo par
        ArrayList<String> palEj2 = new ArrayList<>();
        palEj2.addLast("X"); palEj2.addLast("Y"); palEj2.addLast("Y"); palEj2.addLast("X");
        System.out.println("Ej 2 - Lista: " + palEj2.toString() + " -> Es palindromo?: " + palEj2.isPalindrome());
        
        // Ejemplo 3: No es palindromo
        ArrayList<String> palEj3 = new ArrayList<>();
        palEj3.addLast("A"); palEj3.addLast("B"); palEj3.addLast("C"); palEj3.addLast("D"); palEj3.addLast("E");
        System.out.println("Ej 3 - Lista: " + palEj3.toString() + " -> Es palindromo?: " + palEj3.isPalindrome());
        
        // Ejemplo 4: Lista de un solo elemento (tecnicamente es palindromo)
        ArrayList<String> palEj4 = new ArrayList<>();
        palEj4.addLast("Unico");
        System.out.println("Ej 4 - Lista: " + palEj4.toString() + " -> Es palindromo?: " + palEj4.isPalindrome());
        
        // Ejemplo 5: Lista vacia (tecnicamente es palindromo)
        ArrayList<String> palEj5 = new ArrayList<>();
        System.out.println("Ej 5 - Lista: " + palEj5.toString() + " -> Es palindromo?: " + palEj5.isPalindrome());
        
    }
}