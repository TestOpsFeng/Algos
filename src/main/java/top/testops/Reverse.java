package top.testops;

import java.util.ArrayList;

public class Reverse {
    public static int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        int length = 0;
        long temp = 0;
        while (x!=0){
            int pop = x % 10;
            x = x / 10;
            temp = temp * 10;
            temp = temp + pop;
            if(temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int)temp;
    }

    public int a(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int b(int x) {
        int rev = 0;
        while (x != 0) {
            if ((rev * 10) / 10 != rev) {
                rev = 0;
                break;
            }
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev;
    }

}
