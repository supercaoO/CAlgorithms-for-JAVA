package com.caoO.structrue.collection;

import java.util.Iterator;

public class CLinkedList<E> implements CList<E> {

    private Node first;

    private Node last;

    private int size;

    public CLinkedList() {
    }

    @Override
    public boolean add() {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
    public Iterator<E> iterator() {
        return null;
    }

    private class Node {
        Node previous;
        E element;
        Node next;
    }
}
