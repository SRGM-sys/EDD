package List;

public class LinkedList<E> implements List<E>{
    private NodeList<E> header;
    private NodeList<E> last;
    //private int size = 0; //Tamaño de nodos
    
    public LinkedList(){
        this.header = null;
        this.last = null;
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
    
    // Paso un elemento
    @Override
    public boolean addFirst(E e){
        if(e == null){
            return false;
        } else{
            NodeList<E> newNode = new NodeList<>(e); // 1) Crear el nodo
            newNode.setNext(header); // 2) Conectar el nodo
            this.setHeader(newNode); // 3) Actualizar conexiones
            
            if(last == null){
                last = newNode;
            }
            return true;
        }
    }
    
    @Override
    public boolean addLast(E e){
        if(e == null){
            return false;
        } else{
            NodeList<E> newNode = new NodeList<>(e);
            if(last != null){
                last.setNext(newNode);
            }
            last = newNode;
            
            if(header == null){
                header = newNode;
            }
            return true;
        }
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        int size = 0;
        NodeList<E> n; // Mi pivote que se irá moviendo
        
        for(n = header; n!= null; n = n.getNext()){
            size++;
        }
        
        return size();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    private void recorridoReverso(){
        // Necesito un pivote que se irá moviendo
        NodeList<E> n;
        
        for(n = last; n != header; n = this.getPrevius(n)){
            System.out.println(n);
        }
    }
    
    // Este método me sirve para obtener el anterior al que se pase 
    private NodeList<E> getPrevius(NodeList<E> node){
        NodeList<E> previous = null;
        NodeList<E> n;
        
        for(n = header; n != node; n = n.getNext()){
            previous = n;
        }
        
        return previous;
    }
}
