package testops.day00;

import edu.princeton.cs.algs4.StdOut;
import org.testng.annotations.Test;
import top.testops.utils.STDOut;

import java.util.HashSet;

public class Day01 {
    @Test
    public void v_1_1_1() {
        STDOut.printTypeAndValue((0 + 15) / 2);
        STDOut.printTypeAndValue(2.0e-6 * 100000000.1);
        STDOut.printTypeAndValue(true && false || true && true);
    }

    @Test
    public void v_1_1_2() {
        STDOut.printTypeAndValue((1 + 2.236) / 2);
        STDOut.printTypeAndValue(1 + 2 + 3 + 4.0);
        STDOut.printTypeAndValue(4.1 >= 4);
        STDOut.printTypeAndValue(1 + 2 + "3");
    }

    @Test
    public void v_1_1_3(Object a1, Object a2, Object a3) {
        if (!(a1 instanceof Integer && a2 instanceof Integer && a3 instanceof Integer)) {
            throw new RuntimeException("参数必须为：Integer");
        }
        if (a1 == a2 && a2 == a3) {
            STDOut.printValue("Equal");
        } else {
            STDOut.printValue("Not Equal");
        }
    }

    @Test
    public void v_1_1_4() {
        int a = 1, b = 2, c = 3;
        if (a > b) c = 0;
        else b = 0;
        System.out.println("" + a + b + c);
    }

    public static void v_1_1_5(Double x, Double y) {
        if (x <= 1 && x >= 0 && y <= 1 && y >= 0) {
            STDOut.printValue(true);
        } else {
            STDOut.printValue(false);
        }
    }

    @Test
    public void v_1_1_6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            STDOut.printValue(f);
            f = f + g;
            g = f - g;
        }
    }

    //给t开平方：t为9，则结果为3
    @Test
    public void v1_1_7_a() {
        double t = 9809.0;
        double s = t;
        while (Math.abs(t - s / t) > .001) {
            t = (s / t + t) / 2.0;
            STDOut.printValue(t);
        }
        STDOut.printFormat("%.5f", t);
    }

    //差值不断+1
    @Test
    public void v1_1_7_b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
            STDOut.printValue(sum);
        }
        STDOut.printValue(sum);
    }

    //差值不断*2
    @Test
    public void v1_1_7_c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
            STDOut.printValue(sum);
        }
        STDOut.printValue(sum);
    }

    @Test
    public void v1_1_8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    // Integer格式的N,转换为二进制，用String表示
    @Test
    public void v1_1_9() {
        Integer N = 8;
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            s = (n % 2) + s;
            STDOut.printValue(s);
        }
        STDOut.printValue(s);
    }

    @Test
    public void v1_1_10() {
        int[] a;
        for (int i = 0; i < 10; i++) {
//            a[i] = i * i;
        }
    }

    @Test
    public void v1_1_13() {
        //略
    }

    @Test
    public void v1_1_14() {
        int N = 32;
        int i = 0;
        while ((N >>= 1) > 0) {
            i++;
            STDOut.printIntegetToBinaryString(N);
        }
        STDOut.printValue(i);
    }

    @Test
    public void v1_1_15() {
        int a[] = new int[]{2, 3, 4, 5, 6, 2, 3, 4};
        int M = 10;
        Integer[] result = new Integer[M];
        for (int i = 0; i < M; i++) {
            int tempI = 0;
            for (int j = 0; j < a.length; j++) {
                if (i == a[j]) {
                    tempI++;
                }
            }
            result[i] = tempI;
        }
        STDOut.printArrayWithIndex(result);
    }

    public static String v1_1_16_exR1(int n) {
        if (n <= 0) return "";
        return v1_1_16_exR1(n - 3) + n + v1_1_16_exR1(n - 2) + n;
    }

    public static int mystery(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a * a, b / 2);
        return mystery(a * a, b / 2) * a;
    }

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static double N1(int N) {
        if (N == 1) return 1;
        return N * N1(N - 1);
    }

    public static double v1_1_20(int N) {
        if (N == 1) return 0;
//        if (N == 2) return 1;
        return (Math.log(N) + v1_1_20(N - 1));
    }

    public static int v1_1_22(int lo, int hi, int target, int[] test) {
        int mid = (hi - lo) / 2 + lo;
        if (target == test[mid]) return mid;
        if (lo == mid) return hi;
        if (test[mid] > target) {
            return v1_1_22(lo, mid, target, test);
        } else {
            return v1_1_22(mid, hi, target, test);
        }
    }

    public static int gcd(int p, int q) {
        STDOut.printValue(p + "," + q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static int count = 0;

    public static double binomial(int N, int k, double p) {
        count++;
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static void main(String[] args) {
        int[] a = {768, 770, 771, 773, 775, 525, 527, 785, 791, 536, 539, 541, 545, 549, 552, 809, 553, 558, 566, 825, 573, 831, 575, 576, 577, 578, 579, 580, 581, 327, 584, 328, 585, 586, 843, 587, 844, 588, 845, 336, 337, 340, 346, 347, 349, 606, 607, 610, 868, 357, 870, 616, 363, 619, 364, 366, 625, 881, 626, 882, 627, 883, 628, 884, 629, 630, 631, 633, 890, 635, 636, 895, 896, 644, 900, 645, 646, 905, 906, 651, 652, 656, 661, 920, 921, 410, 666, 923, 924, 925, 926, 927, 672, 677, 425, 682, 428, 692, 696, 705, 706, 708, 713, 982, 474, 731, 733, 992, 993, 994, 486, 998, 489, 752, 498, 756, 758, 760, 762, 764, 765};
        System.out.println(a.length);
        HashSet<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            integers.add(a[i]);
        }
        System.out.println(integers.size());
    }


}
