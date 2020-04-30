package testops;

import org.testng.Assert;
import org.testng.annotations.Test;
import top.testops.IsPalindrome;

public class IsPalindromeTest {

    @Test
    public void palindrome1(){
        Integer b = 12344321;
        boolean palindrome1 = IsPalindrome.isPalindrome3(b);
        System.out.println(palindrome1);
        Assert.assertTrue(palindrome1);
    }
    @Test
    public void palindrome2(){
        Integer b = 1234321;
        boolean palindrome1 = IsPalindrome.isPalindrome3(b);
        System.out.println(palindrome1);
        Assert.assertTrue(palindrome1);
    }
    @Test
    public void palindrome3(){
        Integer b = 11;
        boolean palindrome1 = IsPalindrome.isPalindrome3(b);
        System.out.println(palindrome1);
        Assert.assertTrue(palindrome1);
    }

}
