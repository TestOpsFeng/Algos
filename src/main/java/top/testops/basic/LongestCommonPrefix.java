package top.testops.basic;

public class LongestCommonPrefix {
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int arrayLen = strs.length;
        char temp;
        String result = "";
        int stringLen = strs[0].length();
        for (int i = 0; i < stringLen; i++) {
            temp = strs[0].charAt(i);
            for (int j = 1; j < arrayLen; j++) {
                if (strs[j].length() - 1 >= i) {
                    char x = strs[j].charAt(i);
                    if (temp != x) {
                        return result;
                    }
                } else {
                    return result;
                }
            }
            result = result + temp;
        }
        return result;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int arrayLen = strs.length;
        String result = "";
        int stringLen = strs[0].length();
        for (int i = 1; i <= stringLen; i++) {
            result = strs[0].substring(0, i);
            for (int j = 1; j < arrayLen; j++) {
                if (!strs[j].startsWith(result)){
                    return result.substring(0,result.length() - 1);
                }
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
