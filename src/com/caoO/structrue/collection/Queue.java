package com.caoO.structrue.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * FIFO
 *
 * @param <E>
 */
public class Queue<E> implements Iterable<E> {

    private Object[] elements;

    private int beg;

    private int end;

    private int size;

    private int cap;

    private final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty Queue with an initial capacity of ten.
     */
    public Queue() {
        elements = new Object[DEFAULT_CAPACITY];
        cap = DEFAULT_CAPACITY;
    }

    /**
     * Constructs an empty Queue with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the Queue
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public Queue(int capacity) {
        cap = capacity;
        if (cap > 0)
            elements = new Object[capacity];
        else if (cap == 0)
            elements = new Object[0];
        else
            throw new IllegalArgumentException("Illegal Capacity: " + cap);
    }

    /**
     * Appends the specified element to the end of this Queue.
     *
     * @param element element to be appended to this Queue
     */
    public void enqueue(E element) {
        if (size == cap)
            reBuild(cap * 2 + 2);
        if (end == cap - 1)
            end = 0;
        else
            end++;
        elements[end] = element;
        size++;
    }

    /**
     * Pops the first element of this Queue.
     *
     * @return first element of this Queue
     * @throws NoSuchElementException if the size of this Queue
     *         is empty
     */
    public E dequeue() {
        if (size == 0)
            throw new NoSuchElementException("There is no such elements");
        E element = (E) elements[beg];
        size--;
        elements[beg] = null;
        if (beg == cap - 1)
            beg = 0;
        else
            beg++;
        if (!isEmpty() && size == (cap - 6) / 4)
            reBuild((cap - 2) / 2);
        return element;
    }

    private void reBuild(int newCap) {
        Object[] newElements = new Object[newCap];
        if (beg <= end)
            System.arraycopy(elements, beg, newElements, 0, size);
        else {
            System.arraycopy(elements, beg, newElements, 0, cap - beg);
            System.arraycopy(elements, beg, newElements, cap - beg, end + 1);
        }
        beg = 0;
        end = size - 1;
        cap = newCap;
        elements = newElements;
    }

    /**
     * Returns <tt>true</tt> if this Queue contains no elements.
     *
     * @return <tt>true</tt> if this Queue contains no elements
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns the amount of all elements.
     *
     * @return the amount of all elements
     */
    public int size() { return size; }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        throw new UnsupportedOperationException("This Method is not implemented");
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    private class ArrayIterator implements Iterator<E> {

        private int n = size;

        private int pos = beg;

        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public E next() {
            if (n == 0)
                throw new NoSuchElementException("There is no next element");
            E element = (E) elements[pos];
            if (pos == cap - 1)
                pos = 0;
            else
                pos++;
            n--;
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This Method is not implemented");
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            throw new UnsupportedOperationException("This Method is not implemented");
        }
    }
}
