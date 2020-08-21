package top.testops.day01.impl;

import top.testops.day01.interfaces.BagInterface;

import java.util.Iterator;

public class Bag<T> implements BagInterface<T>, Iterable<T> {

    private T[] items;
    private int N = 0;

    public Bag() {
        items = (T[]) new Object[1];
    }

    @Override
    public void add(T t) {
        items[N] = t;
        N++;
        resizeArray();
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    private void resizeArray() {
        T[] temp = items;
        if (N >= items.length) {
            items = (T[]) new Object[2 * N];
        } else if (N <= (items.length / 4)) {
            items = (T[]) new Object[N / 2];
        }
        for (int i = 0; i < temp.length; i++) {
            items[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {
        private int index = N;
        @Override
        public boolean hasNext() {
            return index != 0;
        }

        @Override
        public T next() {
            return items[--index];
        }

        @Override
        public void remove() {

        }
    }
}
