package top.testops.day01.interfaces;

public interface QueueInterface<T> {
    void enqueue(T t);
    T dequeue();
    int size();
    boolean isEmpty();
    T getK(int k);
}
