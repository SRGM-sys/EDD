/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Usuario
 */
public class Product {
    private int indice;
    private String nombre;
    private float precio;
    private float calificacion;

    public Product(int indice, String nombre, float precio, float calificacion) {
        this.indice = indice;
        this.nombre = nombre;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public int getIndice() {
        return indice;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public float getCalificacion() {
        return calificacion;
    }
    
    
}
