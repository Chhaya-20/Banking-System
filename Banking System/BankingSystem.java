
import java.util.Scanner;

class BankException extends Exception {

    public BankException(String s) {
        super(s);
    }
}

class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println(
                    "***********************************Welcome to the Banking System******************************************");
            System.out.println("1. Create Account\n" +
                    "2. Deposit Money To Your Account \n" +
                    "3. Withdraw Money From Your Account \n" +
                    "4. Transfer Money\n" +
                    "5. Display Transaction Info\n" +
                    "6. Check Current Balance\n" +
                    "7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    int initBalance = sc.nextInt();
                    BankAccount newAcc = new BankAccount(accNum, initBalance);
                    bank.AddAccount(newAcc);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccNum = sc.nextInt();
                    System.out.print("Enter Deposit Amount: ");
                    int depositAmount = sc.nextInt();
                    bank.addM(depositAccNum, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccNum = sc.nextInt();
                    System.out.print("Enter Withdrawal Amount: ");
                    int withdrawAmount = sc.nextInt();
                    bank.withM(withdrawAccNum, withdrawAmount);
                    break;
                case 4:

                    System.out.print("Enter Sending Account Number: ");
                    int fromAccNum = sc.nextInt();
                    System.out.print("Enter Recieving Account Number: ");
                    int toAccNum = sc.nextInt();
                    System.out.print("Enter Transfer Amount: ");
                    int transferAmount = sc.nextInt();
                    bank.transfer(fromAccNum, toAccNum, transferAmount);
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int displayAccNum = sc.nextInt();
                    bank.show(displayAccNum);
                    break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    int balanceAccNum = sc.nextInt();
                    bank.amount(balanceAccNum);
                    // bankingSystem.currentBalance(balanceAccNum);
                    break;
                case 7:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (flag);
        sc.close();
    }

}
