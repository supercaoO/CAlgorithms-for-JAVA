package com.caoO.structrue.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LIFO Stack by LinkedList
 *
 * @param <E>
 */
public class CLinkedStack<E> implements CQueue<E> {

    private Node<E> first;

    private int size;

    /**
     * Constructs an empty CLinkedStack.
     */
    public CLinkedStack() {
    }

    /**
     * Pushes the specified element to the top of this CLinkedStack.
     *
     * @param e element to be appended to this CLinkedStack
     */
    @Override
    public void push(E e) {
        Node<E> node = new Node<>(first, e);
        first = node;
        size++;
    }

    /**
     * Pops the top element of this CLinkedStack.
     *
     * @return top element of this CLinkedStack
     * @throws NoSuchElementException if the size of this CLinkedStack
     *         is empty
     */
    @Override
    public E pop() {
        if (size == 0)
            throw new NoSuchElementException("There is no such elements");
        Node<E> node = first;
        first = first.next;
        size--;
        return node.e;
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

    /**
     * Returns <tt>true</tt> if this CLinkedStack contains no elements.
     *
     * @return <tt>true</tt> if this CLinkedStack contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            if (node == null)
                throw new NoSuchElementException("There is no next element");
            E e = node.e;
            node = node.next;
            return e;
        }
    }

    private class Node<E> {

        private Node<E> next;

        private E e;

        public Node() {}

        public Node(Node<E> node, E e) {
            this.next = node;
            this.e = e;
        }
    }
}
