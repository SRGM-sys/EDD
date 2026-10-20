
package LinkedList;


public class NodeList<E> {
    private E content;
    private NodeList<E> next;

    // Cuando se crea un nuevo nodo, siempre apunta a null
    // OJO: Esto es para las simplemente enlazadas
    public NodeList(E content){
        this.content = content;
        this.next = null;
    }
    
    public E getContent(){
        return content;
    }
    
    public void setContent(E content){
        this.content = content;
    }
    
    public NodeList<E> getNext(){
        return next;
    }
    
    public void setNext(NodeList<E> next){
        this.next = next;
    }
    
}
