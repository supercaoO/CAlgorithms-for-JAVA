package com.caoO.structrue.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * FIFO Queue by LinkedList
 *
 * @param <E>
 */
public class CLinkedQueue<E> implements CQueue<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;

    /**
     * Constructs an empty CLinkedQueue.
     */
    public CLinkedQueue() {
    }

    /**
     * Pushes the specified element to the top of this CLinkedQueue.
     *
     * @param e element to be appended to this CLinkedQueue
     */
    @Override
    public void push(E e) {
        Node<E> node = new Node<>(last, null, e);
        if (last != null)
            last.next = node;
        last = node;
        size++;
        if (size == 1)
            first = last;
    }

    /**
     * Pops the top element of this CLinkedQueue.
     *
     * @return top element of this CLinkedQueue
     * @throws NoSuchElementException if the size of this CLinkedQueue
     *         is empty
     */
    @Override
    public E pop() {
        if (size == 0)
            throw new NoSuchElementException("There is no such elements");
        E e = first.e;

        first = first.next;
        if (first != null)
            first.previous = null;
        size--;
        return e;
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
     * Returns <tt>true</tt> if this CLinkedQueue contains no elements.
     *
     * @return <tt>true</tt> if this CLinkedQueue contains no elements
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

        private Node<E> previous;

        private Node<E> next;

        private E e;

        public Node() {
        }

        public Node(Node<E> previous, Node<E> next, E e) {
            this.previous = previous;
            this.next = next;
            this.e = e;
        }
    }
}
