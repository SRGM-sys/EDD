package LinkedList;

import Clases.Pedido;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 1. PRUEBA: DIVIDIR LANZAMIENTOS ===");
        LinkedList<Integer> lanzamientos = new LinkedList<>();
        int[] datosLanzamientos = {3, 5, 2, 6, 1, 4, 3, 3, 3};
        for (int num : datosLanzamientos) lanzamientos.addLast(num);
        
        System.out.println("Lista Original: " + lanzamientos);
        LinkedList<Integer>[] resultadoLanzamientos = LinkedList.dividirLanzamientos(lanzamientos);
        System.out.println("Jugador 1: " + resultadoLanzamientos[0]);
        System.out.println("Jugador 2: " + resultadoLanzamientos[1]);
        System.out.println("Jugador 3: " + resultadoLanzamientos[2]);


        System.out.println("\n=== 2. PRUEBA: PEDIDOS POR CLIENTE ===");
        LinkedList<Pedido> historialPedidos = new LinkedList<>();
        
        LinkedList<String> prod1 = new LinkedList<>();
        prod1.addLast("P1"); prod1.addLast("P2");
        
        LinkedList<String> prod2 = new LinkedList<>();
        prod2.addLast("P3"); prod2.addLast("P4"); prod2.addLast("P11");
        
        LinkedList<String> prod3 = new LinkedList<>();
        prod3.addLast("P5"); prod3.addLast("P6");
        
        historialPedidos.addLast(new Pedido("Cliente1", prod1));
        historialPedidos.addLast(new Pedido("Cliente2", prod2));
        historialPedidos.addLast(new Pedido("Cliente1", prod3));
        
        System.out.println("Buscando a Cliente1...");
        System.out.println("Productos: " + LinkedList.getPedidosPorCliente(historialPedidos, "Cliente1"));


        System.out.println("\n=== 3. PRUEBA: SUMAR MENORES ===");
        LinkedList<Integer> listaA = new LinkedList<>();
        for (int num : new int[]{2, 3, 8, 4, 1}) listaA.addLast(num);
        
        LinkedList<Integer> listaB = new LinkedList<>();
        for (int num : new int[]{1, 1, 3, 2, 5, 6}) listaB.addLast(num);
        
        System.out.println("Lista A (Umbrales): " + listaA);
        System.out.println("Lista B (Valores) : " + listaB);
        System.out.println("Resultado Sumas   : " + LinkedList.sumarMenores(listaA, listaB));


        System.out.println("\n=== 4. PRUEBA: FILTRADO RECURSIVO (k=3) ===");
        LinkedList<String> palabras = new LinkedList<>();
        palabras.addLast("123");
        palabras.addLast("12");
        palabras.addLast("1234");
        palabras.addLast("1");
        
        System.out.println("Lista Original: " + palabras);
        System.out.println("Lista Filtrada: " + LinkedList.getStringShorterThan(palabras, 3));
    }
}