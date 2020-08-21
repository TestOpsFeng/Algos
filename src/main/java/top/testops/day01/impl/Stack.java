package top.testops.day01.impl;

import top.testops.day01.interfaces.StackInterface;

import java.util.Iterator;

public class Stack<T> implements StackInterface<T>, Iterable<T> {
    private int N;
    private T[] items;

    public Stack() {
        items = (T[]) new Object[1];
    }

    @Override
    public void push(T t) {
        items[N] = t;
        N++;
        resizeArray();
    }

    @Override
    public T pop() {
        N--;
        T item = items[N];
        items[N] = null;
        resizeArray();
        return item;
    }
    @Override
    public T peek() {
        return items[N - 1];
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
            items = (T[]) new Object[items.length / 2];
        }
        for (int i = 0; i < N; i++) {
            items[i] = temp[i];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>{
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
