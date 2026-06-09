package Oops;

class BankAccount {

    // private variable (data hiding)
    private double balance=1000;


    public void testdata(){
        balance=2000;
    }

    // setter method
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // getter method
    public double getBalance() {
        return balance;
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
       // balance=1000;
        //getBalance();
       // classname objectname =  new classname
        BankAccount account = new BankAccount();

        account.setBalance(5000);
        System.out.println("Balance: " + account.getBalance());
    }
}

