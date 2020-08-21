package top.testops.day03;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.util.HashMap;

public abstract class Example {

    abstract void sort(Comparable[] a);

    protected boolean less(Comparable v, Comparable w) {
        StdDraw.setPenColor(Color.BLACK);
        return v.compareTo(w) < 0;
    }

    protected void exch(Comparable[] a, int i, int j) {
        StdDraw.setPenColor(Color.RED);
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) StdOut.print(a[i] + " ");
        StdOut.println();
    }

    protected void showPhoto(Double[] a, Double height, HashMap<Integer, Color> map) {
//        StdDraw.clear();
        int N = a.length;
        double[] x = new double[4];
        double[] y = new double[4];
        for (int i = 0; i < N; i++) {
            StdDraw.setPenColor(Color.GRAY);
            if (map.containsKey(i)) {
                StdDraw.setPenColor(map.get(i));
            }
            //左
            x[0] = x[3] = 1.0 * i / N * 0.5;
            //右
            x[1] = x[2] = 1.0 * i / N * 0.5 + 0.25 / N;
            //下
            y[3] = y[2] = 1.0 * (height - 1) / N + (0.5 / N);
            //上
            y[0] = y[1] = y[3] + (a[i] / N) / N;
            StdDraw.setXscale(0,1.5);
            StdDraw.filledPolygon(x, y);
//            double x = 1.0 * i / N + (0.5 / N);
//            double y = a[i] / 2.0 / N;
//            double rw = 0.25 / N;
//            double rh = a[i] / 2.0 / N;
//            StdDraw.filledRectangle(x, y, rw, rh);
        }
//        StdOut.println();
    }

    protected boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) if (less(a[i], a[i - 1])) return false;
        return true;
    }

}
