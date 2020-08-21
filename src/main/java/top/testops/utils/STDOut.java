package top.testops.utils;

public class STDOut {
    public static void printType(Object obj){
        System.out.println("Type is: " + "【"+ obj.getClass().toString() + "】");
    }

    public static void printValue(Object obj){
        System.out.println("Value is: " + "【" +obj.toString() + "】");
    }

    public static void printTypeAndValue(Object obj){
        System.out.print("Type is: " +  "【"+ obj.getClass().toString() + "】");
        System.out.println(", Value is: " + "【" +obj.toString() + "】");
    }

    public static void printFormat(String format, Object... args) {
        System.out.printf("Value is: " + "【" + format + "】", args);
    }

    public static void printIntegetToBinaryString(int N){
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        System.out.println("BinaryString is: " + "【" + s + "】");
    }

    public static void printArrayWithIndex(Object[] objs){
        for (int i =0;i < objs.length;i++) {
            System.out.print("Index is: " + "【" + i + "】");
            System.out.println("Value is: " + "【" +objs[i].toString() + "】");
        }
    }

}
