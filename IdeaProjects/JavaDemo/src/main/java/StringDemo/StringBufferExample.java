package StringDemo;

public class StringBufferExample {
    public static void main(String[] args) {

        // Create StringBuffer object
        StringBuffer sb = new StringBuffer("Hello");

        // append() → adds text at the end
        sb.append(" World");
        // Now sb = "Hello World"

        // insert() → inserts text at a specific index
        sb.insert(5, ",");
        // Now sb = "Hello, World"

        // delete() → removes characters from start index to end index
        sb.delete(5, 6);
        // removes comma → "Hello World"

        // Print final result
        System.out.println(sb);
    }
}
