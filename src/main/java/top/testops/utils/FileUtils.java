package top.testops.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtils {
    public static void writeText(String filePath, String content, boolean isAppend) {
        FileOutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = new FileOutputStream(filePath, isAppend);
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder buffer = new StringBuilder();
        int N = 10;
        for (int i = 0; i < N; i++) {
            int randomInt1 = (int) (Math.random() * N );
            int randomInt2 = (int) (Math.random() * N );
            buffer.append(randomInt1 + " " +randomInt2 + "\n");
        }
        FileUtils.writeText("E:\\IdeaProject\\Algos\\src\\main\\resources\\file.txt", buffer.toString(), false);
    }
}
