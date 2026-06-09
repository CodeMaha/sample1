package StringDemo;

public class MutabilityDemo {
    public static void main(String[] args) {

        // Immutable String
        String str = "Hello";
        str.concat(" World");

        // Does NOT change original string

        System.out.println("str: " + str);
        // Output: Hello

        // Mutable StringBuffer
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        // Changes original object

        System.out.println("StringBuffer: " + sb);
        // Output: Hello World

        String str1= str.concat(" World");
        System.out.println("str: " + str);
        System.out.println("str1: " + str1);
    }
}
