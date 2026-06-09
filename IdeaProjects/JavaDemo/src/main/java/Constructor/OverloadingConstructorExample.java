package Constructor;

class Product {

    int productId;
    String productName;

    // Default constructor
    Product() {
        productId = 0;
        productName = "No Name";
    }

    // Parameterized constructor (1 parameter)
    Product(int id) {
        productId = id;
        productName = "Unknown Product";
    }

    // Parameterized constructor (2 parameters)
    Product(int id, String name) {
        productId = id;
        productName = name;
    }
}

public class OverloadingConstructorExample {

    public static void main(String[] args) {

        // Different constructor calls
        Product p1 = new Product();              // default
        Product p2 = new Product(101);           // one parameter
        Product p3 = new Product(102, "Laptop"); // two parameters

        System.out.println(p1.productId + " " + p1.productName);
        System.out.println(p2.productId + " " + p2.productName);
        System.out.println(p3.productId + " " + p3.productName);

        /*
         Explanation:
         - Same class has multiple constructors
         - Based on arguments, correct constructor is called
         - This is constructor overloading
         */
    }
}
