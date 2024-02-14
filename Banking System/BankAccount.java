import java.util.ArrayList;
//import java.util.HashMap;

class BankAccount {
    // Unique
    int accountNumber;
    public double balance = 0;
    ArrayList<Transaction> trans;

    public BankAccount(int no, double bal) {
        this.accountNumber = no;
        this.balance = bal;
        trans = new ArrayList<>();
    }

    public int getno() {
        return accountNumber;
    }

    public void widraw(int n) {
        balance = balance - n;
    }

    public void deposit(int n) {
        balance = balance + n;
    }

    public void show() {
        for (int i = 0; i < trans.size(); i++) {
            System.out.println(trans.get(i).id());

        }
    }

}
