package ExceptionalHandling;

import java.io.FileReader;
import java.io.IOException;

//error may or may not occur based on real time scenario
public class CheckedExceptionDemo {

    public static void main(String[] args) {

        try {
            // FileReader may throw FileNotFoundException (checked exception)
            FileReader file = new FileReader("test.txt");

            // reading from file (can also throw IOException)
            int data = file.read();

            System.out.println("File read successfully");

        } catch (IOException e) {
            // This block handles checked exception
            System.out.println("Exception handled: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}

