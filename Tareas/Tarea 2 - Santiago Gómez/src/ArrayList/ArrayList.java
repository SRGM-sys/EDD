package ArrayList;

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
    
    // --------------------------------------------------------------------------

    /* ANÁLISIS DE COMPLEJIDAD
    - El primer ciclo recorre el arreglo 'n' veces para agrupar los datos válidos
    - El segundo ciclo recorre hasta 'n' veces para limpiar los espacios sobrantes
    n + n = 2n --> (Se omite la constante) O(n)
    */
    private void verificarNulos(){
        int indexValido = 0;
        
        // Voy a agrupar todos los elementos válidos a la izquierda
        for(int i = 0; i < size; i++){
            if(elements[i] != null){
                elements[indexValido] = elements[i];
                indexValido++;
            }
        }
        
        // Limpiamos lo que queda al final
        for(int i = indexValido; i < size; i++){
            elements[i] = null;
        }
        
        size = indexValido;
    }
    
    // Ahora voy a añadir los métodos de la actividad
    
    /* ANÁLISIS DE COMPLEJIDAD
    - Ambos remove implican recorrer el arreglo 'n' veces
    - addFirst implica recorrer el arreglo 'n' veces
    - addLast en el peor de los casos va a requerir crear otro arreglo 'n'
    n + n + n + n = 4n --> (Se onmite la constante) O(n)
    */
    public void moveLastToFirst(){
        verificarNulos();
        if(this.isEmpty()) return;
        
        if(size == 0){
            return;
        }
        
        E lastElement = this.removeLast();
        E firstElement = this.removeFirst();
        
        this.addFirst(lastElement);
        this.addLast(firstElement);
    }
    
    /* ANÁLISIS DE COMPLEJIDAD
    - verificarNulos() implica recorrer el arreglo 'n' veces.
    - El ciclo for principal recorre el arreglo 'n-1' veces.
    n + n = 2n --> (Se omite la constante) O(n)
    */
    public E findMin(){
        
        verificarNulos();
        if(this.isEmpty()) return null;
        
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
    
    /* ANÁLISIS DE COMPLEJIDAD
    - verificarNulos() implica recorrer el arreglo 'n' veces.
    - El ciclo externo (i) se ejecuta 'n' veces.
    - El ciclo interno (j) se ejecuta hasta 'n' veces por cada iteración del externo (n * n).
    n + (n * n) = n + n^2 --> (Se domina por el término mayor) O(n^2)
    */
    public void sortDescending(){
        verificarNulos();
        if(this.isEmpty()) return;
        
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
    

    /* ANÁLISIS DE COMPLEJIDAD
    - verificarNulos() implica recorrer el arreglo 'n' veces.
    - El ciclo for principal para buscar y reemplazar recorre el arreglo 'n' veces.
    n + n = 2n --> (Se omite la constante) O(n)
    */
    public void replace(E oldElement, E newElement){
        verificarNulos();
        
        if(oldElement == null || newElement == null) return;
        
        // Voy a ver si el oldElement se encuentra en la lista
        for(int i = 0; i < size; i++){
            if(elements[i].equals(oldElement)){
                elements[i] = newElement;
            }
        }
    }
    
    /* ANÁLISIS DE COMPLEJIDAD
    - El ciclo externo e interno combinados visitan cada elemento exactamente 1 vez ('n' veces en total).
    - addLast en la 'caja' se ejecuta 'n' veces a lo largo de toda la función.
    - addLast en la 'queue' se ejecuta 'n/groupSize' veces.
    n + n + (n/groupSize) = 2n + (n/groupSize) --> (Se omiten las constantes y divisiones) O(n)
    */
    public ArrayList<ArrayList<E>> splitQueue(int groupSize){
        if(groupSize <= 0 ) return null;
        if(this.isEmpty()) return new ArrayList<>();;

        // [1,2,3,4,5,6,7] ; groupSize = 3 -> [ [1,2,3,], [4,5,6], [7] ]
        // Tengo que retornar un Array de Arrays XD
        ArrayList<ArrayList<E>> queue = new ArrayList<>();
        
        // Ciclo externo, ira saltando el tamaño de groupSize
        for(int i = 0; i < size; i+=groupSize){
            // Aquí voy a crear mi caja pequeña
            ArrayList<E> caja = new ArrayList<>();
            // Ahora voy a crear u ciclo interno, que me va a ayudar a llenar la caja
            // Este va a empezar donde se quedo i
            for(int j = i; j < i + groupSize; j++){
                if(j < size){
                    caja.addLast(elements[j]);
                }
            }
            // Ahora que mi caja esta llena la pongo en mi queue
            queue.addLast(caja);
        }
        
        return queue;
    }
    
    
    /* ANÁLISIS DE COMPLEJIDAD
    - verificarNulos() implica recorrer el arreglo 'n' veces.
    - El ciclo for principal recorre el arreglo 'n' veces realizando comparaciones simples.
    n + n = 2n --> (Se omite la constante) O(n)
    */
    public int countAbove(E value){
        int contador = 0;
        verificarNulos();
        if(this.isEmpty()) return 0;
        
        for(int i = 0; i < size; i++){
            
            // Si el elemento actual es MAYOR que 'value', devuelve un positivo
            if(((Comparable<E>) elements[i]).compareTo(value) > 0){
                contador++;
            }
        }
        return contador;
    }
    
    /* ANÁLISIS DE COMPLEJIDAD
    - verificarNulos() implica recorrer el arreglo 'n' veces.
    - El ciclo for principal recorre exactamente la mitad del arreglo ('n/2' veces).
    - Los accesos elements[i] y elements[size - 1 - i] son directos O(1).
    n + (n/2) = 1.5n --> (Se omiten las constantes) O(n)
    */
    public boolean isPalindrome(){
        verificarNulos();
        
        if(this.isEmpty()) return false;
        
        for(int i = 0; i < size/2 ; i++){
            // Vamos a obtener ambos extremos en cada iteracion
            E izquierdo = elements[i];
            E derecho = elements[size-1-i];
            
            // Si los extremos no son iguales retornamos falso
            if(!izquierdo.equals(derecho)){
                return false;
            }
        }
        
        return true;
    }
    
}
