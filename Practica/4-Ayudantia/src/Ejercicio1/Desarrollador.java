package Ejercicio1;

public class Desarrollador {
    private String nombre;
    private String lenguajeFavorito;
    private int problemasResueltos;
    private int scoreCSSBattle;
    private int edad;

    public Desarrollador(String nombre, String lenguajeFavorito, int problemasResueltos, int scoreCSSBattle, int edad) {
        this.nombre = nombre;
        this.lenguajeFavorito = lenguajeFavorito;
        this.problemasResueltos = problemasResueltos;
        this.scoreCSSBattle = scoreCSSBattle;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLenguajeFavorito() {
        return lenguajeFavorito;
    }

    public int getProblemasResueltos() {
        return problemasResueltos;
    }

    public int getScoreCSSBattle() {
        return scoreCSSBattle;
    }

    public int getEdad() {
        return edad;
    }
    
    
}
