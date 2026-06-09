package AccessSpecifiers;

public class PublicExample {

    public int number = 100;

    public void display() {
        System.out.println("Public method: " + number);
    }

    public static void main(String[] args) {
        PublicExample obj = new PublicExample();
        obj.display();
    }
}
