package Taller;

public class Turno {
    
    private int numero;
    private String nombre;
    private int prioridad;

    public Turno(int numero, String nombre, int prioridad) {
        this.numero = numero;
        this.nombre = nombre;
        
        // Validación para asegurar que la prioridad esté en el rango permitido
        if (prioridad < 1 || prioridad > 5) {
            throw new IllegalArgumentException("La prioridad debe ser un valor entre 1 y 5.");
        }
        this.prioridad = prioridad;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Método para facilitar la impresión y visualizar la cola resultante
    @Override
    public String toString() {
        return "Turno{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}
