package Listas;


public class ArrayList<E> implements List<E> {
    
    /* La clase ArrayList trabaja con 3 cosas
    - Un arreglo
    - El tamaño efectivo
    - La capacidad 
   */
    private E[] elements;
    private int size;
    private int capacity;
    
    public ArrayList(){
        this.capacity = 10;
        this.elements = (E[]) new Object[capacity];
        this.size = 0;
    }
    
    // Este método me sirve para aumentar la capacidad cuando se llena
    private void verificarCapacidad(){
        /*
        1) Aumentamos la capacidad *2
        2) Creamos un nuevo arreglo más grande
        3) Metemos todo al nuevo array
        */
        if(size == capacity){
            capacity = capacity * 2;
            E[] newElements = (E[]) new Object[capacity];
            for(int i = 0; i < size; i++){
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
    
    // Método que me sirve para validad que el índice esté dentro de los límites
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice: " + index + ", Tamaño efectivo: " + size);
        }
    }
    
    
    // --------------------------------------------------------------------------
    
    
    @Override
    public boolean addFirst(E e){
        if(e == null) return false;
        
        verificarCapacidad();
        
        // Desplazamos hacia la derecha todos los elementos
        for(int i = size; i > 0; i--){
            elements[i] = elements[i-1];
        }
        
        elements[0] = e;
        size++;
        return true;
    }
    
    @Override
    public boolean addLast(E e){
        if(e == null) return false;
        
        verificarCapacidad();
        elements[size] = e;
        size++;
        return true;
    }
    
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E e = elements[0]; 
        elements[0] = null;
        
        // Todos se desplazan a la izquierda
        for(int i=0; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        return e;
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    
    
}
