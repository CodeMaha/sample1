package AccessSpecifiers;

class DefaultExample {

    int value = 50;  // default access

    void display() {
        System.out.println("Default value: " + value);
    }

    public static void main(String[] args) {
        DefaultExample obj = new DefaultExample();
        obj.display();
    }
}

