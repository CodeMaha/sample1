package AccessSpecifiers;

class PrivateExample {

    private int salary = 50000;

    private void showSalary() {
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        PrivateExample obj = new PrivateExample();

        obj.showSalary();  //  allowed inside same class
    }
}