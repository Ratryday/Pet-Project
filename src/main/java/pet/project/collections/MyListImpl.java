package pet.project.collections;

import java.io.Serial;
import java.util.*;

public class MyListImpl<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    @Serial
    private static final long serialVersionUID = -118178500107573998L;

    private Object[] elements;

    private final static Object[] EMPTY_ELEMENTS = {};

    private int size;

    public MyListImpl() {
        this.elements = EMPTY_ELEMENTS;
    }

    public MyListImpl(int size) {
        if (size == 0) {
            this.elements = EMPTY_ELEMENTS;
        } else if (size > 0) {
            this.elements = new Object[size];
        } else {
            throw new IllegalArgumentException("Illegal array size " + size);
        }
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
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = increaseCapacity();
        }
        elements[size] = e;
        size++;
        return true;
    }

    private Object[] increaseCapacity() {
        return elements = Arrays.copyOf(elements, size + 1);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        elements = EMPTY_ELEMENTS;
        size = 0;
    }

    @Override
    public E get(int index) {
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        if (index > elements.length || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.length);
        }
        return (E) (elements[index] = element);
    }

    @Override
    public void add(int index, E element) {
        if (index > elements.length || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.length);
        }
        elements[index] = element;

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
