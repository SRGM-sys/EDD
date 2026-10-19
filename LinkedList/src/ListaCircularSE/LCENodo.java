package ListaCircularSE;

public class LCENodo<E> {
    private E content;
    private LCENodo<E> next;
    
    public LCENodo(E content){
        this.content = content;
        this.next = this; 
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public LCENodo<E> getNext() {
        return next;
    }

    public void setNext(LCENodo<E> next) {
        this.next = next;
    }
}
