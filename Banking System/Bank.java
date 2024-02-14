import java.util.*;

class Bank {
    int count = 0;
    HashMap<Integer, BankAccount> account = new HashMap<>();
    HashMap<Integer, ArrayList<Transaction>> t;

    public Bank() {
        t = new HashMap<>();
    }

    // CREATE ACCOUNT OF USER
    public void AddAccount(BankAccount b) {
        try {
            if (account.containsKey(b.getno())) {
                throw new BankException("Already Bank Account exist no. with this no....");

            }
            account.put(b.getno(), b);
            System.out.println("Account Successfully Created......");
        } catch (BankException E) {
            System.out.println(E.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured");
        }

    }

    // TRANSFER money from ONE ACCOUNT TO OTHER
    public void transfer(int n1, int n2, int bal) {
        BankAccount a = account.get(n1);
        BankAccount b = account.get(n2);
        try {
            if (a == null || b == null) {
                throw new BankException("Either n1 or n2 is Wrong Account no....");
            }
            if ((a.balance - bal) < 0) {
                throw new BankException("Not Enough Amount.....");
            }
            a.balance = a.balance - bal;
            b.balance = b.balance + bal;
            Transaction t1 = new Transaction(count, "Withdraw", bal);
            count++;
            Transaction t2 = new Transaction(count, "deposit", bal);
            a.trans.add(t1);
            b.trans.add(t2);
            System.out.println("Money Successfully Tranfered........");

        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // DEPOSIT MONEY TO USER ACCOUNT
    public void addM(int no, int bal) {
        BankAccount b = account.get(no);
        try {
            if (b == null) {
                throw new BankException("Invalid Account no.....");
            }
            b.balance = b.balance + bal;
            System.out.println("Successfully Money Deposited.......");
        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured......");

        }
    }

    public void withM(int no, int bal) {
        BankAccount b = account.get(no);
        try {
            if (b == null) {
                throw new BankException("Invalid Account no.....");
            }
            if ((b.balance - bal) < 0) {
                throw new BankException("Not Enough Amount.....");
            }
            b.balance = b.balance - bal;
            System.out.println("Successfully Money WithDrawed.......");
        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured......");

        }

    }

    // Show Transaction of user
    public void show(int no) {
        BankAccount b = account.get(no);
        try {
            if (b == null) {
                throw new BankException("Invalid Account no.....");
            }
            ArrayList<Transaction> temp = b.trans;
            if (temp.size() == 0) {
                throw new BankException("Not Any Transaction Yet......");
            }
            for (int i = 0; i < temp.size(); i++) {
                System.out.println("Transaction id = " + temp.get(i).id() + " , Transaction type = "
                        + temp.get(i).gettype() + " , Amount = " + temp.get(i).getamount());
            }

        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured......");

        }

    }

    // Show Amount of user
    public void amount(int n) {
        BankAccount b = account.get(n);
        try {
            if (b == null) {
                throw new BankException("Invalid Account no.....");
            }
            System.out.println("Balance of your account is " + (b.balance));

        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some error occured......");

        }

    }

}
