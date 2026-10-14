package Listas;

public class DoublyNodeList<E> {
    private E content;
    private DoublyNodeList<E> next;
    private DoublyNodeList<E> previus;
    
    public DoublyNodeList(E content){
        this.content = content;
        this.next = null;
        this.previus = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public DoublyNodeList<E> getNext() {
        return next;
    }

    public void setNext(DoublyNodeList<E> next) {
        this.next = next;
    }

    public DoublyNodeList<E> getPrevius() {
        return previus;
    }

    public void setPrevius(DoublyNodeList<E> previus) {
        this.previus = previus;
    }
    
    
}
