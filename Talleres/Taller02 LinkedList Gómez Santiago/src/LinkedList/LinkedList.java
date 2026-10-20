package LinkedList;

import Clases.Pedido;

public class LinkedList<E> implements List<E>{
    private NodeList<E> header;
    private NodeList<E> last;
    private int size;
    // Voy a manejar size manualmente para tener una complejidad de O(1)
    
    public LinkedList(){
        this.header = null;
        this.last = null;
        this.size = 0;
    }
    
    public NodeList<E> getHeader(){
        return header;
    }
    
    public NodeList<E> getLast(){
        return last;
    }
    
    public void setHeader(NodeList<E> header){
        this.header = header;
    }
    
    public void setLast(NodeList<E> last){
        this.last = last;
    }
    
    //------- MÉTODOS PRIVADOS QUE AYUDAN A SIMPLIFICAR CÓDIGO ------------
    private boolean configurarVacio(NodeList<E> newNode){
        if(header == null){
            setHeader(newNode);
            setLast(newNode);
            return true;
        }
        return false;
    }
    
    // Este método me sirve para obtener el anterior al que se pase 
    private NodeList<E> getPrevious(NodeList<E> node){
        NodeList<E> previous = null;
        NodeList<E> n;
        
        for(n = header; n != node; n = n.getNext()){
            previous = n;
        }
        
        return previous;
    }
    
    // Con este método obtengo el nodo de la posición i exacto
    private NodeList<E> getNode(int i){
        int j = 0;
        NodeList<E> pivote = header;
        while(j != i){
            pivote = pivote.getNext();
            j++;
        }
        
        return pivote;
    }
    
    //--------- MÉTODOS SOBRESCRITOS ---------------
    
    @Override
    public boolean addFirst(E e){
        if(e == null) return false;
        
        NodeList<E> newNode = new NodeList<>(e); // 1) Crear el nodo
        if(!configurarVacio(newNode)){
            newNode.setNext(header); // 2) Conectar el nodo
            setHeader(newNode); // 3) Actualizar conexiones
        }
        
        size++;
        return true;
    }
    
    @Override
    public boolean addLast(E e){
        if(e == null) return false;
        
        NodeList<E> newNode = new NodeList<>(e);
        if(!configurarVacio(newNode)){
            last.setNext(newNode);
            setLast(newNode);
        }
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        // Garantizamos que al menos exista un elemento
        if(header == null) return null;
        
        E element = header.getContent();
        setHeader(header.getNext());
        
        // Es probable que solo tenga un elemento y se haya quedado vacio
        if(header == null) setLast(null);
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        // Garantizamos que al menos exista un elemento
        if(header == null) return null;
        
        E element = last.getContent();
       
        if(header == last){
            header = null;
            last = null;
            size--;
            return element;
        }
        
        // Solo hay puntero next, necesito avanzar desde el inicio hasta
        // el penúltimo nodo
        NodeList<E> pivote = header;
        while(pivote.getNext() != last){
            pivote = pivote.getNext();
        }
        
        pivote.setNext(null); // Desconectamos el ultimo nodo
        last = pivote;        // El último nodo será nuestro pivote
        
        size--;
        return element;
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
    public boolean add(int index, E element) {
        if(index < 0 || element == null || index > size) return false;
        
        if(index == 0) return addFirst(element);
        if(index == size) return addLast(element);
        
        // 1) Voy a obtener el nodo que esta en esa posición
        NodeList<E> nodeIndex = getNode(index);
        // 2) Voy a obtener el nodo anterior a ese
        NodeList<E> previousNode = getPrevious(nodeIndex);
        // 3) Creamos un nuevo nodo
        NodeList<E> newNode = new NodeList<>(element);
        
        // Ahora vamos modificando las referencias
        previousNode.setNext(newNode);
        newNode.setNext(nodeIndex);
        
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size) return null;
        
        if(index == 0) return removeFirst();
        if(index == size-1) return removeLast();
        
        // Obtenemos el nodo a remover y el anterior a ese
        NodeList<E> removeNode = getNode(index);
        NodeList<E> previousNode = getPrevious(removeNode);
        
        // Actualizamos conexiones
        previousNode.setNext(removeNode.getNext());
        
        size--;
        return removeNode.getContent();
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size) return null;
        
        return getNode(index).getContent();
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size) return null;
        
        NodeList<E> targetNode = getNode(index);
        E oldElement = targetNode.getContent();
        targetNode.setContent(element);
        
        return oldElement;
    }
    
    
    public void recorridoReverso(){
        // Necesito un pivote que se irá moviendo
        NodeList<E> n;
        
        for(n = last; n != null; n = this.getPrevious(n)){
            System.out.println(n);
        }
    }
    
    
    //------------------- MÉTODOS DE LA ACTIVIDAD --------------------
    
    public static LinkedList<Integer>[] dividirLanzamientos(List<Integer> lista){
        if(lista == null) return new LinkedList[]{};
        
        LinkedList<Integer> ld1 = new LinkedList<>();
        LinkedList<Integer> ld2 = new LinkedList<>();
        LinkedList<Integer> ld3 = new LinkedList<>();
       
        int contador = 1;
        int total = lista.size();
        
        for(int i = 0; i < total; i++){
            switch(contador){
                // Si tuviese un getFirst, la lista original no se modificaría
                case 1: ld1.addLast(lista.removeFirst()); contador++; break;
                case 2: ld2.addLast(lista.removeFirst()); contador++; break;
                case 3: ld3.addLast(lista.removeFirst()); contador = 1; break;
            }
        }
        
        LinkedList<Integer>[] lanzamientos = new LinkedList[]{ld1,ld2,ld3}; 
        return lanzamientos;
    }
    
    public static List<String> getPedidosPorCliente(List<Pedido> listaPedidos, String cliente){
        if(listaPedidos == null || cliente == null) return new LinkedList<>();
        
        // Este va a ser la caja general, la final a presentar
        List<String> productosFinales = new LinkedList<>();
        
        // Recorremos todos los nodos
        for(int i = 0; i < listaPedidos.size(); i++){
            // Instancio el pedido de todos los nodos
            Pedido pedidoActual = listaPedidos.get(i);
            
            // Verificamos si los clientes hacen match
            if(pedidoActual.getCliente().equals(cliente)){
                
                // Obtenemos todos los pedidos de ese cliente
                List<String> productosDelPedido = pedidoActual.getProductos();
                
                // Vamos a separar pedido por pedido
                for(int j = 0; j < productosDelPedido.size(); j++){
                    productosFinales.addLast(productosDelPedido.get(j));
                }
                
            }
        }
        
        return productosFinales;
    }
    
    public static LinkedList<Integer> sumarMenores(LinkedList<Integer> listaA,
            LinkedList<Integer> listaB){
        if(listaA == null || listaB == null) return new LinkedList<Integer>();
        
        LinkedList<Integer> sumas = new LinkedList<>();
        
        for(int i = 0; i < listaA.size(); i++){
            Integer limite = listaA.get(i);
            Integer suma = 0;
            for(int j = 0; j < listaB.size(); j++){
                Integer valorB = listaB.get(j);
                
                if(valorB < limite){
                    suma += valorB;
                }
            }
            sumas.addLast(suma);
        }
        
        return sumas;
    }
    
    public static List<String> getStringShorterThan(List<String> inputList, int k){
        if(inputList == null || k < 0) return new LinkedList<>();
        
        List<String> palabras = new LinkedList<>();
        
        filtrarRecursivo(inputList, k, 0, palabras);
        
        return palabras;
    }
    
    private static void filtrarRecursivo(List<String> inputList, int k, int index, List<String> palabras){
        if(index >= inputList.size()){
            return;
        }
        
        String palabra = inputList.get(index);
        if(palabra.length() < k){
            palabras.addLast(palabra);
        }
        
        filtrarRecursivo(inputList, k, index + 1, palabras);
    }
    
    
    
    @Override
    public String toString() {
        if (header == null) return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        NodeList<E> pivot = header;
        while (pivot != null) {
            sb.append(pivot.getContent());
            if (pivot.getNext() != null) {
                sb.append(", ");
            }
            pivot = pivot.getNext();
        }
        
        sb.append("]");
        return sb.toString();
    }
    
}
