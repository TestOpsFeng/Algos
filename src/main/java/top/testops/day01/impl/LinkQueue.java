package top.testops.day01.impl;

import top.testops.day01.interfaces.QueueInterface;

import java.util.Iterator;

public class LinkQueue<T> implements QueueInterface<T>, Iterable<T> {
    private int N = 0;
    private Node first;
    private Node last;

    private class Node {
        T item;
        Node next;
    }

    @Override
    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.item = t;
        if (isEmpty()) {
            first = last;
        } else {
            // 如果链表不为空，设置老node指向最后一个元素
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public T dequeue() {
        T item = first.item;
        first = first.next;
        N--;
        // 链表为空，设置last为空
        if (isEmpty()) last = null;
        return item;
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
        Node temp = last;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }


    private class QueueIterator implements Iterator<T> {
        private Node temp = first;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {
            T item = temp.item;
            temp = temp.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
