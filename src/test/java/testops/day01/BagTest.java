package testops.day01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.testng.annotations.Test;
import top.testops.day01.impl.*;

public class BagTest {
    @Test
    public void test1() {
        Bag<Double> numbers = new Bag<Double>();
//        while (!StdIn.isEmpty()) numbers.add(StdIn.readDouble());
        double[] doubles = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (double aDouble : doubles) {
            numbers.add(aDouble);
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers) sum += x;
        double mean = sum / N;
        sum = 0.0;
        for (double x : numbers) sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }

    @Test
    public void test2() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        Queue<Integer> q = new Queue<Integer>();
//        while (!ints.isEmpty()) q.enqueue(in.readInt());
        for (int anInt : ints) {
            q.enqueue(anInt);
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = q.dequeue();
            System.out.println(a[i]);
        }
    }

    @Test
    public void test3() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
//        while (!ints.isEmpty()) q.enqueue(in.readInt());
        Stack<Integer> stack;
        stack = new Stack<Integer>();
//        while (!StdIn.isEmpty()) stack.push(StdIn.readInt());
        for (int anInt : ints) {
            stack.push(anInt);
        }
        for (int i : stack) StdOut.println(i);

    }

    @Test
    public void test4() {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
//        String ss1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
//        String ss = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";
        String ss = "( ( 2 * 3 ) / ( ( 2 - 1 ) + ( 3 * ( 4 - 1 ) ) )";
        String[] strings = ss.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
//            if (s.equals(" ")) continue;
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }

    @Test
    public void test5() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        LinkQueue<Integer> q = new LinkQueue<Integer>();
//        while (!ints.isEmpty()) q.enqueue(in.readInt());
        for (int anInt : ints) {
            q.enqueue(anInt);
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = q.dequeue();
            System.out.println(a[i]);
        }
    }

    @Test
    public void test6() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
//        while (!ints.isEmpty()) q.enqueue(in.readInt());
        LinkStack<Integer> stack;
        stack = new LinkStack<Integer>();
//        while (!StdIn.isEmpty()) stack.push(StdIn.readInt());
        for (int anInt : ints) {
            stack.push(anInt);
        }
        for (int i : stack) StdOut.println(i);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void test7() {

    }

}

