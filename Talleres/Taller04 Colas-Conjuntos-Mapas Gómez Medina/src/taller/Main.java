package taller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import objetos.Tarea;
import objetos.TrabajoImpresion;
import objetos.Transferencia;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("==================================================");
        System.out.println("              INICIO DE PRUEBAS                   ");
        System.out.println("==================================================\n");

        // ---------------------------------------------------------
        // EJERCICIO 1
        // ---------------------------------------------------------
        System.out.println("--- EJERCICIO 1: Trabajos de Impresion ---");
        PriorityQueue<TrabajoImpresion> pendientes1 = new PriorityQueue<>(Comparadores.ordenImpresion());
        pendientes1.offer(new TrabajoImpresion("DOC-01", 10, 1));
        pendientes1.offer(new TrabajoImpresion("DOC-02", 3, 2));
        pendientes1.offer(new TrabajoImpresion("DOC-03", 5, 3));
        pendientes1.offer(new TrabajoImpresion("DOC-04", 3, 4));
        int cantidad = 3;
        
        System.out.println("[DATOS DE ENTRADA]");
        System.out.println("Cantidad de impresiones solicitadas: " + cantidad);
        System.out.println("Cola inicial (Codigo, Paginas, Llegada): [DOC-01(10,1), DOC-02(3,2), DOC-03(5,3), DOC-04(3,4)]\n");
        
        System.out.println("[RESULTADOS]");
        List<TrabajoImpresion> procesados = Metodos.procesarImpresiones(pendientes1, cantidad);
        
        List<String> nombresProcesados = new ArrayList<>();
        for(TrabajoImpresion t : procesados) nombresProcesados.add(t.getCodigo());
        
        List<String> nombresPendientes = new ArrayList<>();
        for(TrabajoImpresion t : pendientes1) nombresPendientes.add(t.getCodigo());
        
        System.out.println("Trabajos procesados:\n" + nombresProcesados);
        System.out.println("Trabajos pendientes:\n" + nombresPendientes + "\n");


        // ---------------------------------------------------------
        // EJERCICIO 2
        // ---------------------------------------------------------
        System.out.println("--- EJERCICIO 2: Seleccion de Tareas ---");
        PriorityQueue<Tarea> pendientes2 = new PriorityQueue<>(Comparadores.ordenTarea());
        pendientes2.offer(new Tarea(1, 5, 6));
        pendientes2.offer(new Tarea(2, 4, 5));
        pendientes2.offer(new Tarea(3, 3, 3));
        pendientes2.offer(new Tarea(4, 2, 8));
        int presupuesto = 9;
        
        System.out.println("[DATOS DE ENTRADA]");
        System.out.println("Presupuesto inicial: " + presupuesto);
        System.out.println("Tareas en cola (ID, Prioridad, Costo): [T1(5,6), T2(4,5), T3(3,3), T4(2,8)]\n");
        
        System.out.println("[RESULTADOS]");
        List<Tarea> seleccionadas = Metodos.seleccionarTareas(pendientes2, presupuesto);
        
        List<Integer> idsSeleccionadas = new ArrayList<>();
        int costoTotal = 0;
        for(Tarea t : seleccionadas) {
            idsSeleccionadas.add(t.getId());
            costoTotal += t.getCosto();
        }
        
        List<Integer> idsPendientes = new ArrayList<>();
        for(Tarea t : pendientes2) idsPendientes.add(t.getId());
        
        System.out.println("Tareas seleccionadas: " + idsSeleccionadas);
        System.out.println("Presupuesto utilizado: " + costoTotal);
        System.out.println("Presupuesto restante: " + (presupuesto - costoTotal));
        System.out.println("Tareas pendientes: " + idsPendientes + "\n");


        // ---------------------------------------------------------
        // EJERCICIO 3
        // ---------------------------------------------------------
        System.out.println("--- EJERCICIO 3: Solicitudes de Inventario ---");
        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("P01", 5);
        inventario.put("P02", 2);
        inventario.put("P03", 0);
        
        Map<String, Integer> pedidos = new HashMap<>();
        pedidos.put("P01", 3);
        pedidos.put("P02", 4);
        pedidos.put("P04", 2);
        
        System.out.println("[DATOS DE ENTRADA]");
        System.out.println("Inventario inicial: " + inventario);
        System.out.println("Pedidos solicitados: " + pedidos + "\n");
        
        System.out.println("[RESULTADOS]");
        Map<String, Integer> faltantes = Metodos.procesarPedidos(inventario, pedidos);
        
        System.out.println("Inventario actualizado:\n" + inventario);
        System.out.println("Productos faltantes:\n" + faltantes + "\n");


        // ---------------------------------------------------------
        // EJERCICIO 4
        // ---------------------------------------------------------
        System.out.println("--- EJERCICIO 4: Transferencias ---");
        Map<String, Integer> cuentas = new HashMap<>();
        cuentas.put("Ana", 100);
        cuentas.put("Beto", 20);
        cuentas.put("Carla", 10);
        
        List<Transferencia> transferencias = List.of(
            new Transferencia("T01", "Ana", "Beto", 30),
            new Transferencia("T02", "Carla", "Ana", 20),
            new Transferencia("T03", "Beto", "Carla", 15)
        );
        
        System.out.println("[DATOS DE ENTRADA]");
        System.out.println("Saldos iniciales: " + cuentas);
        System.out.println("Movimientos a procesar: [T01(Ana->Beto:30), T02(Carla->Ana:20), T03(Beto->Carla:15)]\n");
        
        System.out.println("[RESULTADOS]");
        List<String> rechazadas = Metodos.procesarTransferencias(cuentas, transferencias);
        
        System.out.println("Transferencias rechazadas: " + rechazadas);
        System.out.println("Saldos finales:\n" + cuentas + "\n");


        // ---------------------------------------------------------
        // EJERCICIO 5
        // ---------------------------------------------------------
        System.out.println("--- EJERCICIO 5: Participantes Habilitados ---");
        Set<String> inscritos = Set.of("Ana", "Luis", "Pedro", "Maria");
        Set<String> asistieron = Set.of("Luis", "Pedro", "Maria", "Sofia");
        Set<String> sancionados = Set.of("Maria");
        
        System.out.println("[DATOS DE ENTRADA]");
        System.out.println("Inscritos: " + inscritos);
        System.out.println("Asistieron: " + asistieron);
        System.out.println("Sancionados: " + sancionados + "\n");
        
        System.out.println("[RESULTADOS]");
        Set<String> habilitados = Metodos.obtenerHabilitados(inscritos, asistieron, sancionados);
        System.out.println("Estudiantes habilitados:\n" + habilitados + "\n");


        // ---------------------------------------------------------
        // EJERCICIO 6
        // ---------------------------------------------------------
        System.out.println("--- EJERCICIO 6: Diferencias entre Catalogos ---");
        Set<String> servidorA = Set.of("P01", "P02", "P03", "P04");
        Set<String> servidorB = Set.of("P02", "P03", "P05", "P06");
        
        System.out.println("[DATOS DE ENTRADA]");
        System.out.println("Servidor A: " + servidorA);
        System.out.println("Servidor B: " + servidorB + "\n");
        
        System.out.println("[RESULTADOS]");
        Set<String> diferencias = Metodos.diferenciasCatalogos(servidorA, servidorB);
        System.out.println("Productos con diferencias:\n" + diferencias + "\n");
        
        System.out.println("==================================================");
        System.out.println("           TALLER FINALIZADO CON EXITO            ");
        System.out.println("==================================================");
    }
}