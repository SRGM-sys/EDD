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
        E e = elements[0]; 
        elements[0] = null;
        
        // Todos se desplazan a la izquierda
        for(int i=0; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        return e;
    }
    
    @Override
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return elements[size-1];
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
        for(int i = size; i > index; i++){
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
    
    // --------------------------------------------------------------------------

    // Métodos privados que me van a ayudar
    private void verificarVacios(){
        // Esto me ayuda a quitar todos los elementos nulos de mi arreglo
        
        for(int i = size-1; i >= 0; i--){
            if(elements[i] == null){
                this.remove(i);
            }
        }
    }
    
    // Ahora voy a añadir los métodos de la actividad
    
    // Intercambia el primer y último elemento
    public void moveLastToFirst(){
        if(size == 0){
            return;
        }
        
        E lastElement = this.removeLast();
        E firstElement = this.removeFirst();
        
        this.addFirst(lastElement);
        this.addLast(firstElement);
    }
    
    // Permite identificar el número menor
    public E findMin(){
        if(size == 0){
            return null;
        }
        
        verificarVacios();
        
        E menor = elements[0];
        
        for(int i = 1; i < size; i++){
            /* COMPARABLE
            Al hacer el casting prometemos que que los elementos de la lista
            son capaces de compararse con otros, y por lo tanto tiene el método 
            compareTo
            
            Devolvera un número negativo si el elemento actual es más pequeño
            que el considerado menor
            */
            
            if(((Comparable<E>) elements[i]).compareTo(menor) < 0){
                menor = elements[i];
            }
        }
        
        return menor;
    }
    
    public void sortDescending(){
        verificarVacios();
        
        // Para el ordenamiento usaré el Bubble Sort
        for(int i = 0; i < size-1; i++){
            for(int j=0; j < size - i - 1; j++){
                
                // Se va a comparar el elemento actual con el siguiente.
                // Si el actual es menor que el siguiente, se intercambian
                // de tal manera que los más grandes vayan quedando al incio
                
                if( ((Comparable<E>) elements[j]).compareTo(elements[j+1]) < 0){
                    E temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
            }
        }
    }
    
    // Esto es para reemplazar instancias, pero es para todas las repetidas,
    // es decir, que debo reemplazar en todas las que se repiten
    public void replace(E oldElement, E newElement){
        verificarVacios();
        
        if(oldElement == null || newElement == null) return;
        
        // Voy a ver si el oldElement se encuentra en la lista
        for(int i = 0; i < size; i++){
            if(elements[i].equals(oldElement)){
                elements[i] = newElement;
            }
        }
    }
    
    public ArrayList<ArrayList<E>> splitQueue(int groupSize){
        
    }
    
    
    
}
