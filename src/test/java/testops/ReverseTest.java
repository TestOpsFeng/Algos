package testops;

import org.testng.Assert;
import org.testng.annotations.Test;
import top.testops.Reverse;

public class ReverseTest {
    @Test
    public void reverse1() {
        int i = -1234 % 100;
        int x = -1234 / 10;
        System.out.println("i: " + i);
        System.out.println("x: " + x);
    }

    @Test
    public void reverse2() {
        int reverse = Reverse.reverse(1124);
        Assert.assertEquals(reverse, 4211);
    }

    @Test
    public void reverse3() {
        int reverse = Reverse.reverse(-1124);
        Assert.assertEquals(reverse, -4211);
    }
    @Test
    public void reverse4() {
        int reverse = Reverse.reverse(1120);
        System.out.println("reverse: " + reverse);
        Assert.assertEquals(reverse, 211);
    }

    @Test
    public void reverse5() {
        int reverse = Reverse.reverse(1056389759);
        System.out.println("reverse: " + reverse);
        Assert.assertEquals(reverse, 0);
    }

}