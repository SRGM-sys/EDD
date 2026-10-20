package Clases;

import LinkedList.List; // Ojo: Asegúrate de que este import coincida con la ruta de tu propia interfaz List

public class Pedido {
    private static int contador = 1;
    
    private int numero;
    private String cliente;
    private List<String> productos;

    // Constructor vacío
    public Pedido() {
    }

    // Constructor con parámetros
    public Pedido(String cliente, List<String> productos) {
        this.numero = contador++;
        this.cliente = cliente;
        this.productos = productos;
    }

    // --- GETTERS ---
    
    public int getNumero() { 
        return numero; 
    }
    
    public String getCliente() { 
        return cliente; 
    }
    
    public List<String> getProductos() { 
        return productos; 
    }

    // --- SETTERS ---
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }
}