package testops.day00;

import org.testng.Assert;
import org.testng.annotations.Test;
import top.testops.basic.RomanToInt;

public class RomanToIntTest {
    @Test
    public void romanToInt2(){
        int result = RomanToInt.romanToInt2("III");
        Assert.assertEquals(result,3);
    }
    @Test
    public void RomanToInt2(){
        int result = RomanToInt.romanToInt2("IV");
        Assert.assertEquals(result,4);
    }
    @Test
    public void RomanToInt3(){
        int result = RomanToInt.romanToInt2("IX");
        Assert.assertEquals(result,9);
    }
    @Test
    public void RomanToInt4(){
        int result = RomanToInt.romanToInt2("LVIII");
        Assert.assertEquals(result,58);
    }
    @Test
    public void RomanToInt5(){
        int result = RomanToInt.romanToInt2("MCMXCIV");
        Assert.assertEquals(result,1994);
    }
}
