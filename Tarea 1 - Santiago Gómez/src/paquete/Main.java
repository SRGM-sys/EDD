package paquete;

public class Main {
    
    public static void main(String[] args){
        int[] prueba1 = {3,9,1,7,4};
        int[] prueba2 = {15,8,23,4,16,2};
        int[] prueba3 = {2};
        
        // Ejemplo 1
        System.out.println("El valor maximo del arreglo {3,9,1,7,4} desde el indice 0 es => "
                + Recursion.buscarMaximo(prueba1, 0));
        System.out.println("El valor maximo del arreglo {15,8,23,4,16,2} desde el indice 2 es => "
                + Recursion.buscarMaximo(prueba2, 2));
        System.out.println("El valor maximo del arreglo {2} desde el indice 0 es => "
                + Recursion.buscarMaximo(prueba3, 0)+"\n");
        
        
        // Ejemplo 2
        System.out.println("La cantidad de digitos del numero 345 es => "+Recursion.contarDigitos(345));
        System.out.println("La cantidad de digitos del numero 7 es => "+Recursion.contarDigitos(7));
        System.out.println("La cantidad de digitos del numero -12048 es => "+Recursion.contarDigitos(-12048) + "\n");
        
        
        // Ejemplo 3
        System.out.println("La palabra \"Estructura\" en mayusculas es => "+Recursion.aMayusculas("Estructura"));
        System.out.println("La palabra \"recursividad\" en mayusculas es => "+Recursion.aMayusculas("recursividad"));
        System.out.println("La palabra \"Hola Mundo 123\" en mayusculas es => "+Recursion.aMayusculas("Hola Mundo 123"));
    }
}