package top.testops.utils;

public class Timer {

    private final long startTime;
    private final String name;

    public Timer() {
        startTime = System.currentTimeMillis();
        name = "";
    }

    public Timer(String name) {
        startTime = System.currentTimeMillis();
        this.name = name;
    }

    public void getTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long offsetTime = (currentTimeMillis - startTime);
        System.out.println(name + " use time(ms)：" + offsetTime);
    }
}
