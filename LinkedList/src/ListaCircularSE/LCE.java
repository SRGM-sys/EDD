
package ListaCircularSE;

import List.List;

public class LCE<E> implements List<E>{
    private LCENodo<E> last;
    private int size;
    // Atributo reincorporado para garantizar complejidad O(1) al consultar el tamaño
    

    public LCE() {
        this.last = null;
        this.size = 0;
    }

    public LCENodo<E> getLast() {
        return last;
    }

    public void setLast(LCENodo<E> last) {
        this.last = last;
    }

    // ---------- METODOS PRIVADOS QUE AYUDAN A SIMPLIFICAR CODIGO ----------

    private LCENodo<E> getNode(int index) {
        LCENodo<E> pivot = last.getNext(); // Empezamos desde el "header" invisible
        for (int i = 0; i < index; i++) {
            pivot = pivot.getNext();
        }
        return pivot;
    }

    private LCENodo<E> getPrevious(LCENodo<E> node) {
        LCENodo<E> pivot = last.getNext();
        while (pivot.getNext() != node) {
            pivot = pivot.getNext();
        }
        return pivot;
    }

    // --- METODOS SOBRESCRITOS DE LA INTERFAZ ---

    @Override
    public boolean addFirst(E e) {
        if (e == null) return false;

        LCENodo<E> newNode = new LCENodo<>(e); // El constructor ya hace newNode.next = newNode

        if (last == null) {
            last = newNode;
        } else {
            newNode.setNext(last.getNext()); // El nuevo apunta al actual primero
            last.setNext(newNode);           // El ultimo apunta al nuevo primero
        }

        size++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) return false;

        LCENodo<E> newNode = new LCENodo<>(e);

        if (last == null) {
            last = newNode;
        } else {
            newNode.setNext(last.getNext()); 
            last.setNext(newNode);
            last = newNode; // La unica diferencia con addFirst: movemos la etiqueta last al nuevo
        }

        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if (last == null) return null;

        LCENodo<E> first = last.getNext();
        E element = first.getContent();

        if (last == first) { // Caso: solo queda un elemento en el circulo
            last = null;
        } else {
            last.setNext(first.getNext()); // El ultimo salta al segundo, desconectando el primero
        }

        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (last == null) return null;

        E element = last.getContent();

        if (last == last.getNext()) { // Caso: solo queda un elemento
            last = null;
        } else {
            LCENodo<E> prev = getPrevious(last);
            prev.setNext(last.getNext()); // El penultimo se conecta al primero
            last = prev;                  // El penultimo se corona como el nuevo last
        }

        size--;
        return element;
    }

    @Override
    public int size() {
        return size; // Complejidad O(1) mantenida manualmente
    }

    @Override
    public boolean isEmpty() {
        return size == 0; 
    }

    @Override
    public void clear() {
        last = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > size || element == null) return false;

        if (index == 0) return addFirst(element);
        if (index == size) return addLast(element);

        LCENodo<E> targetNode = getNode(index);
        LCENodo<E> prevNode = getPrevious(targetNode);
        LCENodo<E> newNode = new LCENodo<>(element);

        prevNode.setNext(newNode);
        newNode.setNext(targetNode);

        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        LCENodo<E> targetNode = getNode(index);
        LCENodo<E> prevNode = getPrevious(targetNode);

        prevNode.setNext(targetNode.getNext()); // Saltamos el nodo intermedio

        size--;
        return targetNode.getContent();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        return getNode(index).getContent();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size || element == null) return null;

        LCENodo<E> targetNode = getNode(index);
        E oldElement = targetNode.getContent();
        targetNode.setContent(element);

        return oldElement;
    }
}
