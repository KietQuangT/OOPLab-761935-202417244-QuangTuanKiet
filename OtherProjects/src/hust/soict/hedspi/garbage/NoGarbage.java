package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "E:/test.exe"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));

            startTime = System.currentTimeMillis();

            StringBuilder outputBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputBuilder.append((char) b);
            }

            String outputString = outputBuilder.toString(); 
            endTime = System.currentTimeMillis();

            System.out.println("Time: " + (endTime - startTime) + " ms");
            System.out.println("Length: " + outputString.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}