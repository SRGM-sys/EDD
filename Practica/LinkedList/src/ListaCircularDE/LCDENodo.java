package ListaCircularDE;


public class LCDENodo<E> {
    private E content;
    private LCDENodo<E> next;
    private LCDENodo<E> previous;
    
    public LCDENodo(E content){
        this.content = content;
        this.next = this;
        this.previous = this;
    }

    public E getContent(){ 
        return content; 
    }
    
    public void setContent(E content){ 
        this.content = content; 
    }
    
    public LCDENodo<E> getNext(){ 
        return next; 
    }
    public void setNext(LCDENodo<E> next){ 
        this.next = next; 
    }
    
    public LCDENodo<E> getPrevious(){ 
        return previous; 
    }
    
    public void setPrevious(LCDENodo<E> previous){ 
        this.previous = previous; 
    }
}
