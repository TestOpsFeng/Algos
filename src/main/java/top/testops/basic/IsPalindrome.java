package top.testops.basic;

public class IsPalindrome {
    /**
     * 通过String判断
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        StringBuffer strbuff = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            String lastStr = str.substring(i, i + 1);
            strbuff.append(lastStr);
        }
        return strbuff.toString().equals(str);
//        str.substring(0, 1);

    }

    /**
     * 通过Integer判断
     *
     * @param x
     * @return
     */

    public static boolean isPalindrome2(int x) {
        return reverse(x) == x;
    }

    /**
     * 半回文
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int temp = 0;
        while (temp < x) {
            int a = x % 10;
            x = x / 10;
            temp = temp* 10 + a;
        }
        return temp == x || x == (temp / 10);
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10))
                return 0;
            rev = rev * 10 + pop;
        }
        if (rev < 0) {
            rev = -rev;
        }
        return rev;
    }

}
