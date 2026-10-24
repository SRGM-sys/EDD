package LinkedList.LDE;

import LinkedList.List;
import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;
    private int size;
    
    public DoublyLinkedList(){
        this.header = null;
        this.last = null;
        this.size = 0;
    }

    public DoublyNodeList<E> getHeader() {
        return header;
    }

    public void setHeader(DoublyNodeList<E> header) {
        this.header = header;
    }

    public DoublyNodeList<E> getLast() {
        return last;
    }

    public void setLast(DoublyNodeList<E> last) {
        this.last = last;
    }
    
    //------- METODOS PRIVADOS QUE AYUDAN A SIMPLIFICAR CODIGO ------------
    
    private boolean configurarVacio(DoublyNodeList<E> newNode){
        if(header == null){
            setHeader(newNode);
            setLast(newNode);
            return true;
        }
        return false;
    }
    
    // Busca desde el inicio o desde el fin dependiendo de que tan
    // cerca este el indice.
    private DoublyNodeList<E> getNode(int index) {
        DoublyNodeList<E> pivot;
        
        if (index < size / 2) { 
            // Si esta en la primera mitad, avanzamos desde el header
            pivot = header;
            for (int i = 0; i < index; i++) {
                pivot = pivot.getNext();
            }
        } else {
            // Si esta en la segunda mitad, retrocedemos desde el last
            pivot = last;
            for (int i = size - 1; i > index; i--) {
                pivot = pivot.getPrevious();
            }
        }
        return pivot;
    }

    //--------- METODOS SOBRESCRITOS ---------------
    
    @Override
    public boolean addFirst(E e) {
        if(e == null) return false;
        
        DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
        
        if(!configurarVacio(newNode)){
            newNode.setNext(header);     // El nuevo apunta al actual primero
            header.setPrevius(newNode);  // El actual primero apunta hacia atras al nuevo
            setHeader(newNode);          // El nuevo es el nuevo header
        }
        
        size++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if(e == null) return false;
        
        DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
        
        if(!configurarVacio(newNode)){
            last.setNext(newNode);       // El actual ultimo apunta al nuevo
            newNode.setPrevius(last);    // El nuevo apunta hacia atras al actual ultimo
            setLast(newNode);            // El nuevo es el nuevo last
        }
        
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if(header == null) return null;
        
        E element = header.getContent();
        setHeader(header.getNext());
        
        if(header == null){ // Si la lista quedo vacia
            setLast(null);
        } else {
            header.setPrevius(null); // Desconectamos la flecha hacia atras del nuevo primero
        }
        
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if(last == null) return null;
        
        E element = last.getContent();
        setLast(last.getPrevious()); // Magia de O(1): saltamos al anterior instantaneamente
        
        if(last == null){ // Si la lista quedo vacia
            setHeader(null);
        } else {
            last.setNext(null); // Desconectamos la flecha hacia adelante del nuevo ultimo
        }
        
        size--;
        return element;
    }

    @Override
    public boolean add(int index, E element) {
        if(index < 0 || index > size || element == null) return false;
        
        if(index == 0) return addFirst(element);
        if(index == size) return addLast(element);
        
        // Obtenemos el nodo de la posicion actual y su anterior directamente
        DoublyNodeList<E> current = getNode(index);
        DoublyNodeList<E> previous = current.getPrevious();
        DoublyNodeList<E> newNode = new DoublyNodeList<>(element);
        
        // Hacemos las 4 conexiones (2 hacia adelante, 2 hacia atras)
        previous.setNext(newNode);
        newNode.setPrevius(previous);
        
        newNode.setNext(current);
        current.setPrevius(newNode);
        
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size) return null;
        
        if(index == 0) return removeFirst();
        if(index == size - 1) return removeLast();
        
        // Obtenemos el nodo a borrar
        DoublyNodeList<E> target = getNode(index);
        DoublyNodeList<E> previous = target.getPrevious();
        DoublyNodeList<E> next = target.getNext();
        
        // Puenteamos el nodo objetivo (lo desconectamos)
        previous.setNext(next);
        next.setPrevius(previous);
        
        size--;
        return target.getContent();
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size) return null;
        return getNode(index).getContent();
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size || element == null) return null;
        
        DoublyNodeList<E> target = getNode(index);
        E oldElement = target.getContent();
        target.setContent(element);
        
        return oldElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

    @Override
    public void clear() {
        header = null;
        last = null;
        size = 0;
    }
    
    @Override
    public Iterator<E> iterator(){
        
        Iterator<E> it = new Iterator(){
            private DoublyNodeList<E> current = header;
            
            @Override
            public boolean hasNext(){
                return current != null;
            }
            
            @Override
            public E next(){
                E element = current.getContent();
                current = current.getNext();
                return element;
            }
            
        };
        
        return it;
    }
}