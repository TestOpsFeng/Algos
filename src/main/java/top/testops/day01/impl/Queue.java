package top.testops.day01.impl;

import top.testops.day01.interfaces.QueueInterface;

import javax.swing.*;
import java.util.Iterator;

public class Queue<T> implements QueueInterface<T>, Iterable<T> {
    private int N;
    private T[] items;

    public Queue() {
        items = (T[]) new Object[1];
    }

    @Override
    public void enqueue(T t) {
        items[N] = t;
        N++;
        resizeArray();
    }

    @Override
    public T dequeue() {
        T item = items[0];
        // 把数组前移一位
        reSort();
        N--;
        resizeArray();
        return item;
    }

    private void reSort() {
        for (int i = 0; i < N; i++) {
            items[i] = items[i + 1];
        }
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public T getK(int k) {
        if (k > N || k < 0){
            throw new RuntimeException("k不在范围内");
        }
       return items[N - k];
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
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


    private class QueueIterator implements Iterator<T> {
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
