package TDA;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>{
    private E[] datos;
    private int size;
    private static final int CAPACIDAD = 10;
    
    public ArrayStack(){
        this.datos = (E[]) new Object[CAPACIDAD];
        this.size = 0;
    }
    
    @Override
    public void push(E e){
        if(e == null) return;
        if(size == datos.length) redimensionar(datos.length * 2);
        datos[size++] = e;
        
    }
    
    @Override
    public E pop(){
        if(isEmpty()) return null;
        E e = datos[--size];
        datos[size] = null;
        return e;
    }
    
    @Override
    public E peek(){
        if(isEmpty()) return null;
        return datos[size-1];
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    private void redimensionar(int capacity){
        E[] newArray = (E[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            newArray[i] = datos[i];
        }
        datos = newArray;
    }
    
    // Un iterador desde la cima hacia la base (orden LIFO)
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            private int i = size - 1;
            
            @Override
            public boolean hasNext(){
                return i >= 0;
            }
            
            @Override
            public E next(){
                if(!hasNext()) return null;
                return datos[i--];
            }
            
            
            
        }
    }
}
