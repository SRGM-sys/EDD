package paquete;

// Aqupi voy a tener mis 4 métodos estáticos 
public class Recursion {
    
    // Ejercicio 1: Buscar el valor máximo de un arreglo desde el índice dado
    public static int buscarMaximo(int arr[], int indice){
        
        // 1) Vamos a validad las entradas
        if(arr == null || arr.length == 0 || indice < 0 || indice >= arr.length){
            return Integer.MIN_VALUE;
        }
        
        // 2) El caso base: Si estoy viendo elemento por elemento, mi busqueda  
        // terminada cuando llegue al final del array
        if(indice == (arr.length-1)){
            return arr[indice];
        }
        
        int maximoResto = buscarMaximo(arr, indice+1);     
        
        if(arr[indice] > maximoResto) return arr[indice];
        else return maximoResto;
        
        /* ¿Cómo funciona? Usaremos como ejemplo {4,23,15,2} con i = 0
            - Salta las validaciones
        Con E1, E2, E3..., me iré refiriendo a las entradas. Vamos hacia 
        al fondo de este algoritmo usando la recursividad. "maximoResto 
        sera interpretado como MR"
            - E1(4)    -> MR1([1])
            - E2(23)   -> MR2([2])
            - E3(15)   -> MR3([3])
            - E4(2)    || RETORNA: 2
        Empezamos a retornar. Se comparará el último con su anterior
            - MR3 = 2  -> (15 > 2)  || RETORNA: 15
            - MR2 = 15 -> (23 > 15) || RETORNA: 23
            - MR1 = 23 -> (4 > 23)  || RETORNA: 23
        Aquí terminan los retornos, el último en salir es el 23
        */
        
        // ====================================================================
        
        /* ANÁLISIS DE COMPLEJIDAD
        Todos los pasos tienen complejidad constante excepto uno, que es cuando
        se llama a la función "buscarMaximo(arr, indice+1)". En el peor de los 
        casos el índice va a ser 0 y debemos recorrer todo el array. Siendo
        'n' la cantidad de elementos, entonces puede repetirse 'n' veces
        COMPLEJIDAD: O(n)
        */
    }
    
    
    // Ejercicio 2: Contar dígitos de un número entero
    public static int contarDigitos(int n){
        // No es posible validar el límite del número int, ya que lo que pasará
        // es un error de compilación, ya que esta función solo permita entradas
        // que pueda soportar int
        
        // Validación negativo
        // Si se evalia Integer.MIN_VALUE en un absoluto, se devuelve con el signo negativo
        if(n < 0){
            n = Math.abs(n);
        }
        
        // Caso base
        if(n > -10 && n < 10){
            return 1;
        }

        // Paso recursivo, se va sumando 1 en cada iteración
        return 1 + contarDigitos(n/10);
        
        
        /* ANÁLISIS DE COMPLEJIDAD
        Teniendo en cuenta que el valor int tiene un límite de 10 dígitos
        se podría creer que esto tiene complejidad constante, pero la complejidad
        O grande ignora estos límites, suponiendo que se ingresa un número con
        'n' dígitos, el problema se va dividiendo, y esto caracteriza a una
        complejidad logaritmica
        COMPLEJIDAD: O(log(n))
        */
    } 
    
    
    // Ejercicio 3: Generar una cadena con los caracteres en mayúscula
    public static String aMayusculas(String s){
        
        // Validaciones
        if(s == null){
            return new String();
        }
        
        // Caso base
        if(s.length() == 0){
            return s;
        }
        
        // Convertimos la primera letra a mayuscula y la concatenamos con lo
        // que resta
        char first = Character.toUpperCase(s.charAt(0));
        return first + aMayusculas(s.substring(1));
        
        /* ANÁLISIS DE COMPLEJIDAD
        Esto depende de la cantidad de caracteres, es decir 'n'. Pero también
        hay que tener en cuenta las operaciones entre Strings, concatenar y usar
        substring crea una nueva cadena, copiando y pegando cada elemento a un 
        String completamente nuevo caracter por caracter, llamando a esta variable
        'k'. Al analizar complejidad O grande nos vamos hacia el límite infinito
        donde k se repite n cantidad de veces, se un crecimiento cuadrático.
        COMPLEJIDAD: O(n^2)
        */
        
    }
}
