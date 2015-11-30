package com.tdd.playground.customlist;

public class CustomArrayList implements CustomList {

    private Object[] elements;
    private int size;

    public CustomArrayList() {

        elements = new Object[]{};
        size = 0;
    }

    public CustomArrayList(int initialCapacity) {

        if (initialCapacity < 1)
            throw new IllegalArgumentException("Initial size must be > 0");

        elements = new Object[initialCapacity];

        size = initialCapacity;
    }


    public int size() {
        return elements.length;
    }

    public void add(Object element) {

        increaseSize();

        elements[elements.length - 1] = element;

        size++;
    }

    public void delete(Object element) {

        boolean deleted = deleteElementIfFound(element);

        if (deleted) {

            decreaseAndAssignElementsToNewSize();

            size--;
        }
    }

    public Object get(int position) {

        if (position < 0 || position > size + 1)
            throw new IndexOutOfBoundsException("Position doesn't exist ::" + position);

        return elements[position];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object element) {

        if (element == null)
            return false;

        boolean found = false;

        for (int i = 0; i < size && !found; i++) {

            if (elements[i] == element)
                found = true;
        }

        return found;
    }

    public int indexOf(Object element) {

        if (!contains(element))
            return -1;

        int position = 0;
        boolean found = false;

        for (int i = 0; i < size && !found; i++) {

            if (elements[i] == element) {
                found = true;
                position = i;
            }
        }

        return position;

    }

    private void decreaseAndAssignElementsToNewSize() {

        int newSize = size > 0 ? size - 1 : 0;

        Object[] newElements = new Object[newSize];

        for (int i = 0; i < size; i++) {

            if (elements[i] != null)
                newElements[i] = elements[i];
        }

        elements = newElements;
    }

    private boolean deleteElementIfFound(Object element) {

        boolean deleted = false;

        for (int i = 0; i < size && !deleted; i++) {

            if (elements[i] == element) {
                elements[i] = null;
                deleted = true;
            }
        }
        return deleted;
    }

    private void increaseSize() {

        int oldSize = size;

        Object[] newElements = new Object[oldSize + 1];

        for (int i = 0; i < oldSize; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    public void clear() {

        elements = new Object[]{};

        size = 0;

    }

    public void addAll(Object[] elements) {

        if (elements != null && elements.length > 0) {

            final Object[] newElements = calculateNewSize(elements.length);

            for (int i = 0; i < size; i++) {

                newElements[i] = elements[i];
            }

            for (int i = size; i < newElements.length; i++) {
                newElements[i] = elements[i];
            }

            size = newElements.length;
        }
    }

    private Object[] calculateNewSize(int length) {

        int newSize = size + length;

        return new Object[]{newSize};
    }
}
