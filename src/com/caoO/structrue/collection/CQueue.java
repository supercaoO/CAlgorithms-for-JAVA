package com.caoO.structrue.collection;

public interface CQueue<E> extends CCollection<E> {
    void push(E e);
    E pop();
}
