package top.testops.day01.interfaces;

public interface StackInterface<T> {
    void push(T t);
    T pop();
    int size();
    boolean isEmpty();
    T peek();
}
