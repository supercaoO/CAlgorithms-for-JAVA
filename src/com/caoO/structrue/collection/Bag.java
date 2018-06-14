package com.caoO.structrue.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<E> implements Iterable<E> {

    private Object[] elements;

    private int size;

    private int cap;

    private final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty Bag with an initial capacity of ten.
     */
    public Bag() {
        elements = new Object[DEFAULT_CAPACITY];
        cap = DEFAULT_CAPACITY;
    }

    /**
     * Constructs an empty Bag with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the Bag
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public Bag(int capacity) {
        cap = capacity;
        if (cap > 0)
            elements = new Object[capacity];
        else if (cap == 0)
            elements = new Object[0];
        else
            throw new IllegalArgumentException("Illegal Capacity: " + cap);
    }

    /**
     * Appends the specified element to the end of this Bag.
     *
     * @param element element to be appended to this Bag
     */
    public void add(E element) {
        if (size == cap)
            reBuild();
    }

    private void reBuild() {
        cap = cap * 2 + 2;
        elements = Arrays.copyOf(elements, cap);
    }

    /**
     * Returns <tt>true</tt> if this Bag contains no elements.
     *
     * @return <tt>true</tt> if this Bag contains no elements
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
        throw new UnsupportedOperationException("This method is not implemented");
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
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
