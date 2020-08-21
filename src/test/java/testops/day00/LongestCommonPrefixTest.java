package testops.day00;

import org.testng.Assert;
import org.testng.annotations.Test;
import top.testops.basic.LongestCommonPrefix;

public class LongestCommonPrefixTest {
    @Test
    public void test1() {
        String[] strs = {"flower", "flow", "flight"};
        String s = LongestCommonPrefix.longestCommonPrefix(strs);
        Assert.assertEquals(s,"fl");
    }
    @Test
    public void test2() {
        String[] strs = {"aa","a"};
        String s = LongestCommonPrefix.longestCommonPrefix(strs);
        Assert.assertEquals(s,"a");
    }

    @Test
    public void test3() {
        String[] strs = {"abcd","abc","ab"};
        String s = LongestCommonPrefix.longestCommonPrefix(strs);
        Assert.assertEquals(s,"ab");
    }
}
