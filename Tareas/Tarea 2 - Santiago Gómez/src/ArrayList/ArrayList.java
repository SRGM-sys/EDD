package ArrayList;

import java.util.Iterator;

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
    private void addCapacity(){
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
        
        addCapacity();
        
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
        
        addCapacity();
        elements[size] = e;
        size++;
        return true;
    }
    
    @Override
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        return this.remove(0);
    }
    
    @Override
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return this.remove(size-1);
       
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public void clear(){
        for(int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }
    
    @Override
    public boolean add(int index, E element){
        if(index > size || index < 0){
            return false;
        }
        
        addCapacity();
        
        // Aquí desplazamos a la derecha todos los elementos
        // desde el índice
        for(int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
        return true;
    }
    
    @Override
    public E remove(int index){
        if(index >= size || index < 0){
            return null;
        }
        
        E removedElement = elements[index];
        
        // Desplazamos a la izquierda desde el valor dado
        // dejando al elemento a remover en la última posición
        for(int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        
        elements[size-1] = null;
        size--;
        return removedElement;
    }
    
    @Override
    public E get(int index){
        if(index >= size || index < 0){
            return null;
        }
        return elements[index];
    }
    
    @Override
    public E set(int index, E element){
        if(index >= size || index < 0){
            return null;
        }
        
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }
    
    @Override
    public String toString(){
        String resultado = "[";
        
        for(int i = 0; i < size; i++){
            resultado += elements[i];
            
            // Si no es el último elemento agregamos una coma de separador
            if(i < size-1){
                resultado += ", ";
            }
        }
        
        resultado += "]";
        
        return resultado;
    }
    
    
    // Vamos a implementar manualmente el método iterator()
    @Override
    public Iterator<E> iterator(){
        
        // Creo mi clase anónima
        Iterator<E> it = new Iterator<E>(){
            int cont = 0;
            
            @Override
            public boolean hasNext(){
                return cont < size;
            }
            
            @Override
            public E next(){
                return elements[cont++];
            }
        };
        
        return it;
    }
    
}
