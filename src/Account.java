import java.util.ArrayList;

public class Account {
    int accountNumber;
    int pin;
    double balance;
    ArrayList<String> transactions;

    public Account(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: $" + amount);
        System.out.println("Deposit successful! New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful! New balance: $" + balance);
        }
    }

    public void addTransaction(String info) {
        transactions.add(info);
    }

    public void printTransactions() {
        System.out.println("----- Transaction History -----");
        if(transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for(String t : transactions) {
                System.out.println(t);
            }
        }
    }
}