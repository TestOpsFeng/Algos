package top.testops.day01.interfaces;

/**
 * 背包
 */
public interface BagInterface<T> {
    void add(T t);
    int size();
    boolean isEmpty();
}
