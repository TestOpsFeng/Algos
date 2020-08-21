package top.testops.basic;

import java.util.HashMap;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class RomanToInt {
    public static int romanToInt1(String s) {
        int length = s.length();
        int result = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        for (int i = 0; i < length; i++) {
            String substring = s.substring(i, i + 1);
            if (substring.equals("I") || substring.equals("X") || substring.equals("C")) {
                if (length - i > 1) {
                    String subSubstring = s.substring(i, i + 2);
                    if (map.containsKey(subSubstring)) {
                        result = result + map.get(subSubstring);
                        i++;
                        continue;
                    }
                }
                result = result + map.get(substring);
            } else {
                result = result + map.get(substring);
            }
        }
        return result;
    }

    /**
     * 使用substring
     * @param s
     * @return
     */
    public int romanToInt3(String s) {
        int length = s.length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        int begin = map.get(s.substring(0, 1));
        for (int i = 1; i < length; i++) {
            int temp = map.get(s.substring(i,i+1));
            if (begin >= temp){
                result = result + begin;
            }else {
                result = result - begin;
            }
            begin = temp;
        }
        result += begin;
        return result;
    }

    /**
     * 使用charAt + getValue
     * @param s
     * @return
     */
    public static int romanToInt2(String s) {
        int length = s.length();
        int result = 0;
        int begin = getValue(s.charAt(0));
        for (int i = 1; i < length; i++) {
            int temp = getValue(s.charAt(i));
            if (begin >= temp){
                result = result + begin;
            }else {
                result = result - begin;
            }
            begin = temp;
        }
        result += begin;
        return result;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


}
