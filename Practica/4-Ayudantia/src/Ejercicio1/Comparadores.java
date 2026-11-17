package Ejercicio1;

// Esta clase va a implementar los comparadores de mi clase desarrollador

import java.util.Comparator;

public class Comparadores {
    
    // ========================================================
    // 1. POR PROBLEMAS RESUELTOS (Descendente: mayor a menor)
    // ========================================================
    public static final Comparator<Desarrollador> POR_PROBLEMAS_ANON = 
            new Comparator<Desarrollador>(){
                
        @Override
        public int compare(Desarrollador d1, Desarrollador d2){
            return Integer.compare(d2.getProblemasResueltos(), d1.getProblemasResueltos());
        }
    };
    
    public static final Comparator<Desarrollador> POR_PROBLEMAS_LAMBDA =
            (d1, d2) -> Integer.compare(d2.getProblemasResueltos(), d1.getProblemasResueltos());
    
    // Esa fue una comparación entre clase anónima y expresión lambda.
    // Las demás implementaciones seran hechas por expresión Lmabda
    
    // ========================================================
    // 2. POR NOMBRE (Alfabético A - Z)
    // ========================================================
    public static final Comparator<Desarrollador> POR_NOMBRE_LAMBDA =
            (d1, d2) -> d1.getNombre().compareTo(d2.getNombre());
    
    // ========================================================
    // (Desempate: primero por Problemas Desc, luego por Nombre A-Z)
    // ========================================================
    public static final Comparator<Desarrollador> COMPUESTO_LAMBDA = 
            (d1, d2) -> {
                int bandera = Integer.compare(d2.getProblemasResueltos(), d1.getProblemasResueltos());
                if(bandera == 0) return d1.getNombre().compareTo(d2.getNombre());
                return bandera;
            };
    
}
