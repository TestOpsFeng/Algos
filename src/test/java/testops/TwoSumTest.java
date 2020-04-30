package testops;


import org.testng.Assert;
import org.testng.annotations.Test;
import top.testops.TwoSum;

public class TwoSumTest {

    @Test
    public void twoSum1() {
        int[] ints = {2, 7, 11, 15};
        int[] result = new TwoSum().twoSum5(ints, 18);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        Assert.assertEquals(result, new int[]{1, 2});
    }

    @Test
    public void twoSum2() {
        int[] ints = {3, 3};
        int[] result = new TwoSum().twoSum5(ints, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        Assert.assertEquals(result, new int[]{0, 1});
    }

    @Test
    public void twoSum3() {
        int[] ints = {3, 2, 4};
        int[] result = new TwoSum().twoSum5(ints, 5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        Assert.assertEquals(result, new int[]{0, 1});
    }

    @Test
    public void twoSum4() {
        int[] ints = {3, 2, 3};
        int[] result = new TwoSum().twoSum5(ints, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        Assert.assertEquals(result, new int[]{0, 2});
    }

    @Test
    public void twoSum5() {
        int[] ints = {5,1,2,3,4,5};
        int[] result = new TwoSum().twoSum5(ints, 10);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        Assert.assertEquals(result, new int[]{0, 5});
    }

}
