package com.caoO.structrue.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CBag<E> implements CCollection<E> {

    private Object[] elements;

    private int size;

    private int cap;

    private final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty CBag with an initial capacity of ten.
     */
    public CBag() {
        elements = new Object[DEFAULT_CAPACITY];
        cap = DEFAULT_CAPACITY;
    }

    /**
     * Constructs an empty CBag with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the CBag
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public CBag(int capacity) {
        cap = capacity;
        if (cap > 0)
            elements = new Object[capacity];
        else if (cap == 0)
            elements = new Object[0];
        else
            throw new IllegalArgumentException("Illegal Capacity: " + cap);
    }

    /**
     * Appends the specified element to the end of this CBag.
     *
     * @param element element to be appended to this CBag
     */
    public void add(E element) {
        if (size == cap)
            reBuild();
        elements[size++] = element;
    }

    private void reBuild() {
        cap = cap * 2 + 2;
        elements = Arrays.copyOf(elements, cap);
    }

    /**
     * Returns <tt>true</tt> if this CBag contains no elements.
     *
     * @return <tt>true</tt> if this CBag contains no elements
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

    private class ArrayIterator implements Iterator<E> {

        private int n = 0;

        @Override
        public boolean hasNext() {
            return n < size;
        }

        @Override
        public E next() {
            if (n == size)
                throw new NoSuchElementException("There is no next element");
            return (E) elements[n++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This method is not implemented");
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            throw new UnsupportedOperationException("This method is not implemented");
        }
    }
}
