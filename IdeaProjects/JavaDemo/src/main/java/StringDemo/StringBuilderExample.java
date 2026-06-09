package StringDemo;

public class StringBuilderExample {
    public static void main(String[] args) {

        // Create StringBuilder object
        StringBuilder sb = new StringBuilder("Java");

        // append() → adds data to end
        sb.append(" Programming");
        // "Java Programming"

        // insert() → insert at index
        sb.insert(4, " Language");
        // "Java Language Programming"

        // delete() → remove portion
        sb.delete(4, 13);
        // removes " Language" → "Java Programming"

        // Display result
        System.out.println(sb);
    }
}
