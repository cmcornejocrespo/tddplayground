package com.tdd.playground.customlist;

public interface CustomList {

    boolean isEmpty();

    void add(Object element);

    void delete(Object element);

    int size();

    int indexOf(Object element);

    Object get(int position);

    boolean contains(Object element);

    void clear();

    void addAll(Object[] elements);
}
