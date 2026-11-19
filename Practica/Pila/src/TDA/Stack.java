package TDA;

public interface Stack<E> extends Iterable<E>{
    public void push(E e);
    public E pop();
    public E peek();
    boolean isEmpty();
    int size();
}
