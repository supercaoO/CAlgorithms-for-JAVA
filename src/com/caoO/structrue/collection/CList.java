package com.caoO.structrue.collection;

public interface CList<E> extends CCollection<E> {
    boolean add();
    E remove(int index);
    boolean remove(Object o);
}
