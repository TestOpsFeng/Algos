package top.testops.day02.impl;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import top.testops.day02.interfaces.UFInterface;
import top.testops.utils.FileUtils;
import top.testops.utils.Timer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class UF implements UFInterface {

    private int[] id;
    private int count;
    private int[] sz;

    public UF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    /**
     * id的值对应分量
     *
     * @param p
     * @param q
     */
    public int theunionCount = 0;

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        theunionCount = theunionCount + 2;
        if (pId == qId) return;
        for (int i = 0; i < id.length; i++, theunionCount++) {
            if (id[i] == pId) {
                theunionCount++;
                id[i] = qId;
            }
        }
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
        count--;
    }

    public void union2(int p, int q) {
        int pRoot = find2(p);
        int qRoot = find2(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        theunionCount++;
        count--;
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
        System.out.println("x=" + theunionCount);
    }

    public void union3(int p, int q) {
        int i = find2(p);
        int j = find2(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public void union4(int p, int q) {
        int i = find3(p);
        int j = find3(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public int find3(int p) {
        while (id[p] != p) {
            //指向爷爷节点，如没有爷爷节点，则指向父节点
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public int find2(int p) {
        for (theunionCount++; id[p] != p;) {
            theunionCount++;
            p = id[p];
        }
        return p;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    private static void temp() {
        File file = new File("E:\\IdeaProject\\Algos\\src\\main\\resources\\mediumUF.txt");
        try {
            if (file.exists() && file.isFile()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "utf-8");// 考虑到编码格式
                //FileReader read = new FileReader(file); //不考虑转码，可使用FileReader;
                BufferedReader br = new BufferedReader(read);//使用缓冲流按行读取
                String lineText = null;
                StringBuffer sb = new StringBuffer();
                while ((lineText = br.readLine()) != null) {
//                    sb.append(lineText + "\n");
                }
            } else {
                throw new RuntimeException("File is not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void temp1() {
        StringBuilder buffer = new StringBuilder();
        int N = 500000;
        for (int i = 0; i < N; i++) {
            int randomInt1 = (int) (Math.random() * N / 5);
            int randomInt2 = (int) (Math.random() * N / 5);
            buffer.append(randomInt1 + " " + randomInt2 + "\n");
        }
        FileUtils.writeText("E:\\IdeaProject\\Algos\\src\\main\\resources\\file.txt", buffer.toString(), false);
        File file = new File("E:\\IdeaProject\\Algos\\src\\main\\resources\\file.txt");
        try {
            if (file.exists() && file.isFile()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "utf-8");// 考虑到编码格式
                //FileReader read = new FileReader(file); //不考虑转码，可使用FileReader;
                BufferedReader br = new BufferedReader(read);//使用缓冲流按行读取
                String lineText = null;
                UF uf = new UF(N / 5);
                Timer timer = new Timer();
                while ((lineText = br.readLine()) != null) {
                    int p = Integer.parseInt(lineText.split(" ")[0]);
                    int q = Integer.parseInt(lineText.split(" ")[1]);
                    if (uf.connected(p, q)) {
                        continue;
                    }
                    uf.union3(p, q);
//                    StdOut.println(p + " -> " + q);
                }
                System.out.println("union3 - count:" + uf.count());
                timer.getTime();
            } else {
                throw new RuntimeException("File is not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void temp2() {
        StringBuilder buffer = new StringBuilder();
        int N = 500000;
        for (int i = 0; i < N; i++) {
            int randomInt1 = (int) (Math.random() * N / 5);
            int randomInt2 = (int) (Math.random() * N / 5);
            buffer.append(randomInt1 + " " + randomInt2 + "\n");
        }
        FileUtils.writeText("E:\\IdeaProject\\Algos\\src\\main\\resources\\file.txt", buffer.toString(), false);
        File file = new File("E:\\IdeaProject\\Algos\\src\\main\\resources\\file.txt");
        try {
            if (file.exists() && file.isFile()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "utf-8");// 考虑到编码格式
                //FileReader read = new FileReader(file); //不考虑转码，可使用FileReader;
                BufferedReader br = new BufferedReader(read);//使用缓冲流按行读取
                String lineText = null;
                UF uf = new UF(N / 5);
                Timer timer = new Timer();
                while ((lineText = br.readLine()) != null) {
                    int p = Integer.parseInt(lineText.split(" ")[0]);
                    int q = Integer.parseInt(lineText.split(" ")[1]);
                    if (uf.connected(p, q)) {
                        continue;
                    }
                    uf.union4(p, q);
//                    StdOut.println(p + " -> " + q);
                }
                System.out.println("union4 - count:" + uf.count());
                timer.getTime();
            } else {
                throw new RuntimeException("File is not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("E:\\IdeaProject\\Algos\\src\\main\\resources\\file.txt");
        try {
            if (file.exists() && file.isFile()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "utf-8");// 考虑到编码格式
                //FileReader read = new FileReader(file); //不考虑转码，可使用FileReader;
                BufferedReader br = new BufferedReader(read);//使用缓冲流按行读取
                String lineText = null;
                UF uf = new UF(10);
                Timer timer = new Timer();
                while ((lineText = br.readLine()) != null) {
                    int p = Integer.parseInt(lineText.split(" ")[0]);
                    int q = Integer.parseInt(lineText.split(" ")[1]);
                    if (uf.connected(p, q)) {
                        continue;
                    }
                    uf.union2(p, q);
//                    StdOut.println(p + " -> " + q);
                }
                System.out.println("union4 - count:" + uf.count());
                System.out.println("union4 - use id count:" + uf.theunionCount);
                timer.getTime();
            } else {
                throw new RuntimeException("File is not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        temp2();
//        temp1();
//        UF uf = new UF(N);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if (uf.connected(p, q)) {
//                continue;
//            }
//            uf.union(p, q);
//            StdOut.println(p + " -> " + q);
//        }
//        StdOut.println(uf.count() + "components");

    }
}
