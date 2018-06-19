package com.caoO.structrue.collection;

import java.util.*;
import java.util.function.Consumer;

/**
 * LIFO
 *
 * @param <E>
 */
public class CArrayStack<E> implements CQueue<E> {

    private Object[] elements;

    private int size;

    private int cap;

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty CArrayStack with an initial capacity of ten.
     */
    public CArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
        cap = DEFAULT_CAPACITY;
    }

    /**
     * Constructs an empty CArrayStack with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the CArrayStack
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public CArrayStack(int capacity) {
        cap = capacity;
        if (cap > 0)
            elements = new Object[capacity];
        else if (cap == 0)
            elements = new Object[0];
        else
            throw new IllegalArgumentException("Illegal Capacity: " + cap);
    }

    /**
     * Pushes the specified element to the end of this CArrayStack.
     *
     * @param element element to be appended to this CArrayStack
     */
    @Override
    public void push(E element) {
        if (size == cap)
            reBuild(cap * 2 + 2);
        elements[size++] = element;
    }

    /**
     * Pops the last element of this CArrayStack.
     *
     * @return last element of this CArrayStack
     * @throws NoSuchElementException if the size of this CArrayStack
     *         is empty
     */
    @Override
    public E pop() {
        if (size == 0)
            throw new NoSuchElementException("There is no such elements");
        E element = (E) elements[--size];
        elements[size] = null;
        if (!isEmpty() && size == (cap - 6) / 4)
            reBuild((cap - 2) / 2);
        return element;
    }

    /**
     * Returns <tt>true</tt> if this CArrayStack contains no elements.
     *
     * @return <tt>true</tt> if this CArrayStack contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the amount of all elements.
     *
     * @return the amount of all elements
     */
    @Override
    public int size() {
        return size;
    }

    private void reBuild(int newCap) {
        elements = Arrays.copyOf(elements, newCap);
        cap = newCap;
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {

        private int n = size;

        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public E next() {
            if (n == 0) {
                throw new NoSuchElementException("There is no next element");
            }
            return (E) elements[--n];
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
