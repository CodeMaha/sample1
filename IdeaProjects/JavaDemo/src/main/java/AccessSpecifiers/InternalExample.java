package AccessSpecifiers;


class Parent {

    protected void showMessage() {
        System.out.println("Protected method from Parent");
    }
}

class InternalExample extends Parent {

    public static void main(String[] args) {

        InternalExample obj = new InternalExample();

        obj.showMessage();  //inherited method accessible
    }
}
