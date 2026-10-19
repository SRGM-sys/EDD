package ListaCircularDE;

import List.List;

public class LCDE<E> implements List<E> {
    private LCDENodo<E> last;
    private int size;
    // Atributo reincorporado para garantizar complejidad O(1) al consultar el tamaño
    
    public LCDE() {
        this.last = null;
        this.size = 0;
    }

    public LCDENodo<E> getLast() {
        return last;
    }

    public void setLast(LCDENodo<E> last) {
        this.last = last;
    }
    
    //------- METODOS PRIVADOS QUE AYUDAN A SIMPLIFICAR CODIGO ------------
    private LCDENodo<E> getNode(int index) {
        LCDENodo<E> pivot;
        
        // Si el indice esta en la primera mitad, avanzamos desde el "primero"
        if (index < size / 2) {
            pivot = last.getNext(); // El primero
            for (int i = 0; i < index; i++) {
                pivot = pivot.getNext();
            }
        } else { 
            // Si esta en la segunda mitad, retrocedemos desde el "ultimo"
            pivot = last; 
            for (int i = size - 1; i > index; i--) {
                pivot = pivot.getPrevious();
            }
        }
        return pivot;
    }

    // --- METODOS SOBRESCRITOS DE LA INTERFAZ ---

    @Override
    public boolean addFirst(E e) {
        if (e == null) return false;
        
        LCDENodo<E> newNode = new LCDENodo<>(e);
        
        if (last == null) {
            last = newNode;
        } else {
            LCDENodo<E> first = last.getNext();
            
            // Conectamos el nuevo nodo en medio de 'last' y 'first'
            newNode.setNext(first);
            newNode.setPrevious(last);
            
            // Actualizamos los extremos para que abracen al nuevo nodo
            first.setPrevious(newNode);
            last.setNext(newNode);
        }
        
        size++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) return false;
        
        // La conexion es EXACTAMENTE igual que addFirst
        LCDENodo<E> newNode = new LCDENodo<>(e);
        
        if (last == null) {
            last = newNode;
        } else {
            LCDENodo<E> first = last.getNext();
            
            newNode.setNext(first);
            newNode.setPrevious(last);
            
            first.setPrevious(newNode);
            last.setNext(newNode);
            
            // La unica diferencia: coronamos al nuevo nodo como el ultimo
            last = newNode; 
        }
        
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if (last == null) return null;
        
        LCDENodo<E> first = last.getNext();
        E element = first.getContent();
        
        if (last == first) { // Caso: solo queda 1 elemento
            last = null;
        } else {
            LCDENodo<E> newFirst = first.getNext(); // El segundo sera el nuevo primero
            
            // Reconectamos saltandonos el nodo 'first'
            last.setNext(newFirst);
            newFirst.setPrevious(last);
        }
        
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (last == null) return null;
        
        E element = last.getContent();
        
        if (last == last.getNext()) { // Caso: solo queda 1 elemento
            last = null;
        } else {
            LCDENodo<E> first = last.getNext();
            LCDENodo<E> newLast = last.getPrevious(); // El penultimo sera el nuevo ultimo
            
            // Reconectamos saltandonos el nodo 'last'
            newLast.setNext(first);
            first.setPrevious(newLast);
            
            // Actualizamos la etiqueta
            last = newLast;
        }
        
        size--;
        return element;
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > size || element == null) return false;
        
        if (index == 0) return addFirst(element);
        if (index == size) return addLast(element);
        
        // Obtenemos el nodo objetivo y su anterior de forma directa
        LCDENodo<E> target = getNode(index);
        LCDENodo<E> previous = target.getPrevious();
        LCDENodo<E> newNode = new LCDENodo<>(element);
        
        // Realizamos las 4 conexiones
        previous.setNext(newNode);
        newNode.setPrevious(previous);
        
        newNode.setNext(target);
        target.setPrevious(newNode);
        
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        
        LCDENodo<E> target = getNode(index);
        LCDENodo<E> previous = target.getPrevious();
        LCDENodo<E> next = target.getNext();
        
        // Puenteamos el nodo a eliminar (4 desconexiones en 2 lineas)
        previous.setNext(next);
        next.setPrevious(previous);
        
        size--;
        return target.getContent();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        return getNode(index).getContent();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size || element == null) return null;
        
        LCDENodo<E> target = getNode(index);
        E oldElement = target.getContent();
        target.setContent(element);
        
        return oldElement;
    }

    @Override
    public int size() {
        return size;
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
}
