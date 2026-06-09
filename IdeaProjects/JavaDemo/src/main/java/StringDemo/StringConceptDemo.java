package StringDemo;

public class StringConceptDemo {
    public static void main(String[] args) {
        // ================================
        // 1. STRING CREATION
        // ================================
        String s1 = "Hello";
        // String literal (stored in String Constant Pool)
        String s2 = new String("Hello");
        // String object created using 'new' keyword (stored in heap)
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        // ================================
        // 2. IMMUTABILITY
        // ================================
        String str = "Java";
        // concat() does NOT modify original string
        str.concat(" Selenium");
        System.out.println("After concat (without assign): " + str);
        // Output: Java (unchanged)
        // To actually change, assign result
        str = str.concat(" Selenium");
        System.out.println("After concat (with assign): " + str);
        // Output: Java Selenium
        // ================================
        // 3. LENGTH METHOD
        // ================================
        String word = "Automation";
        int length = word.length(); // counts characters
        System.out.println("Length: " + length);
        // Output: 10
        // ================================
        // 4. SUBSTRING
        // ================================
        String text = "Selenium";
        String sub1 = text.substring(0, 4);
        // Extracts characters from index 0 to 3
        String sub2 = text.substring(4);
        // Extracts from index 4 to end
        System.out.println("Substring(0,4): " + sub1); // Sele
        System.out.println("Substring(4): " + sub2);   // nium
        // ================================
        // 5. EQUALS METHOD
        // ================================
        String a = "Test";
        String b = "Test";
        String c = new String("Test");
        System.out.println("a.equals(b): " + a.equals(b)); // true
        System.out.println("a.equals(c): " + a.equals(c)); // true
        // ================================
        // 6. == VS EQUALS
        // ================================
        System.out.println("a == b: " + (a == b));
        // true (same reference in SCP)
        System.out.println("a == c: " + (a == c));
        // false (different objects in memory)
        // ================================
        // 7. toUpperCase & toLowerCase
        // ================================
        String mixed = "SeLeNiUm";
        System.out.println("Upper: " + mixed.toUpperCase()); // SELENIUM
        System.out.println("Lower: " + mixed.toLowerCase()); // selenium
        // ================================
        // 8. CONTAINS METHOD
        // ================================
        String sentence = "Welcome to Selenium";
        boolean contains = sentence.contains("Selenium");
        System.out.println("Contains Selenium: " + contains);
        // true
        // ================================
        // 9. TRIM METHOD
        // ================================
        String spaced = "   Java   ";
        String trimmed = spaced.trim();
        System.out.println("Trimmed: '" + trimmed + "'");
        // Removes leading and trailing spaces
        // ================================
        // 10. REPLACE METHOD
        // ================================
        String replaceExample = "this is Java";
        String updated = replaceExample.replace("Java", "Selenium");
        System.out.println("Replaced: " + updated);
        // ================================
        // 11. IMPORTANT - STRING VALIDATION (Selenium use case)
        // ================================
        String actualTitle = "Google";
        String expectedTitle = "Google";
        // Best practice in Selenium validation
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title matched");
        } else {
            System.out.println("Title not matched");
        }
        // ================================
        // END OF DEMO
        // ================================
        System.out.println("Program Completed");
    }
}
