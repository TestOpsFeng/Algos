package top.testops.day01.impl;

import top.testops.day01.interfaces.StackInterface;

import java.util.Iterator;

public class Link<T> implements StackInterface<T>, Iterable<T> {
    private int N = 0;
    private Node first;

    private class Node {
        T item;
        Node next;
    }

    public void print(){
        for (Node temp = first; temp != null; temp = temp.next) {
            System.out.print("【 ");
            System.out.print(temp.item+" ");
            System.out.print("】");
        }
    }

    public static void main(String[] args) {
        Link<Integer> link = new Link<Integer>();
        for (int i = 0; i < 5; i++) {
            link.push(i);
        }
        link.find(3);
        link.find(6);
    }

    public void deleteLastNode() {
        for (Node temp = first; temp != null; temp = temp.next) {
            if (temp.next.next == null){
                temp.next = null;
                break;
            }
        }
    }

    public void find(T key){
        boolean flag = false;
        for (Node temp = first; temp != null; temp = temp.next) {
            if (temp.item == key){
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }

    @Override
    public void push(T t) {
        Node oldfirst = first;
        first = new Node();
        first.item = t;
        first.next = oldfirst;
        N++;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        System.out.print(item + "  ");
        N--;
        return item;
    }

    @Override
    public T peek() {
        return first.item;
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
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
