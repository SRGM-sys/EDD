package taller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import objetos.*;

public class Metodos {
    
    public static List<TrabajoImpresion> procesarImpresiones(
            PriorityQueue<TrabajoImpresion> pendientes, int cantidad){
        
        if(pendientes == null || pendientes.isEmpty() || cantidad <= 0){
            return new ArrayList<>();
        }
        
        ArrayList<TrabajoImpresion> lista = new ArrayList<>();
        
        // Aquí agregare una condición adicional al for
        // Se va a detener cuando ya no existan mas trabajos en los pendientes
        for(int i = 0; i < cantidad && !pendientes.isEmpty(); i++){
            lista.add(pendientes.poll());
        }
    
        return lista;
    }
    
    public static List<Tarea> seleccionarTareas(PriorityQueue<Tarea> pendientes,
            int presupuesto){
        
        if(pendientes == null || pendientes.isEmpty() || presupuesto <= 0){
            return new ArrayList<>();
        }
        
        PriorityQueue<Tarea> aux = new PriorityQueue<>(Comparadores.ordenTarea());
        List<Tarea> seleccionadas = new ArrayList<>();
        int bandera;
        
        while(!pendientes.isEmpty()){
            Tarea t = pendientes.poll();
            bandera = presupuesto - t.getCosto();
            if(bandera < 0){
                aux.offer(t);
            }
            else{
                seleccionadas.add(t);
                presupuesto -= t.getCosto();
            }
        }
        
        pendientes.addAll(aux);
        
        return seleccionadas;
    }
    
    public static Map<String, Integer> procesarPedidos(
            Map<String, Integer> inventario, Map<String, Integer> pedidos){
        
        // El programa debe funcionar incluso si el inventario esta vacío
        if(inventario == null || pedidos == null || pedidos.isEmpty()){
            return new HashMap<>();
        }    
        
        Map<String, Integer> faltantes = new HashMap<>();
        int cantidadPedida;
        int stock;
        int restante;
        
        for(String codigo: pedidos.keySet()){
            cantidadPedida = pedidos.get(codigo);
            
            // Asumimos que el stock es 0, por si el producto pedido no existe en el inventario
            stock = 0;
            if(inventario.containsKey(codigo)){
                stock = inventario.get(codigo);
            }
            
            restante = stock - cantidadPedida;
            
            if(restante >= 0){
                // Se sobreescribe, porque es la misma clave
                inventario.put(codigo, restante);
            } else{
                faltantes.put(codigo, Math.abs(restante));
                if (inventario.containsKey(codigo)) {
                    inventario.put(codigo, 0);
                }
            }
        }
        
        return faltantes;
    } 
    
    public static List<String> procesarTransferencias(
            Map<String, Integer> cuentas, List<Transferencia> transferencias) {
        
        // Validación de seguridad inicial
        if (cuentas == null || transferencias == null) {
            return new ArrayList<>();
        }
        
        List<String> rechazadas = new ArrayList<>();
        
        for (Transferencia t : transferencias) {
            String origen = t.getOrigen();
            String destino = t.getDestino();
            int monto = t.getMonto();
            
            // 1. Verificamos que AMBAS cuentas existan antes de intentar sacarles el saldo
            if (cuentas.containsKey(origen) && cuentas.containsKey(destino)) {
                
                int saldoOrigen = cuentas.get(origen);
                
                // 2. Evaluamos todas las reglas del negocio juntas
                if (!origen.equals(destino) && monto > 0 && saldoOrigen >= monto) {
                    
                    // ¡Transferencia Válida! Actualizamos el mapa
                    cuentas.put(origen, saldoOrigen - monto);
                    cuentas.put(destino, cuentas.get(destino) + monto);
                    
                    // Usamos 'continue' para saltar a la siguiente vuelta del bucle sin rechazarla
                    continue; 
                }
            }
            
            // Si falta una cuenta, o si rompe cualquier regla del if interior, cae directo aquí
            rechazadas.add(t.getCodigo());
        }
        
        return rechazadas;
    }
    
   
    public static Set<String> obtenerHabilitados(
            Set<String> inscritos, Set<String> asistieron, Set<String> sancionados) {
        
        if (inscritos == null || asistieron == null || sancionados == null || inscritos.isEmpty()) {
            return new HashSet<>();
        }
        
        // Se crea un clon para no modificar el original
        Set<String> habilitados = new HashSet<>(inscritos);
        
        // Nos quedamos solo con los que SI asistieron
        habilitados.retainAll(asistieron);
        
        // Eliminamos a los que estan sancionados
        habilitados.removeAll(sancionados);
        
        return habilitados;
    }
    
    public static Set<String> diferenciasCatalogos(
            Set<String> servidorA, Set<String> servidorB) {
        
        if (servidorA == null || servidorB == null) {
            return new HashSet<>();
        }
        
        // Calculamos la INTERSECCION en un set temporal
        Set<String> enComun = new HashSet<>(servidorA);
        enComun.retainAll(servidorB);
        
        // Calculamos la UNION en el set final
        Set<String> diferencias = new HashSet<>(servidorA);
        diferencias.addAll(servidorB);
        
        // A la union total le restamos lo que tienen en comun (Diferencia Simetrica)
        diferencias.removeAll(enComun);
        
        return diferencias;
    }
}
    
   
