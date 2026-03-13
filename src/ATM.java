import java.util.ArrayList;

public class ATM {
    ArrayList<Account> accounts;

    public ATM() {
        accounts = new ArrayList<>();
        // Add some demo accounts
        accounts.add(new Account(1234, 1111, 800.0));
        accounts.add(new Account(5678, 2222, 10000.0));
    }

    public Account login(int accountNumber, int pin) {
        for(Account
                acc : accounts) {
            if(acc.accountNumber == accountNumber && acc.pin == pin) {
                return acc;
            }
        }
        return null;
    }

    public void transfer(Account sender, int recipientAccNum, double amount) {
        Account recipient = null;
        for(Account acc : accounts) {
            if(acc.accountNumber == recipientAccNum) {
                recipient = acc;
                break;
            }
        }
        if(recipient == null) {
            System.out.println("Recipient account not found!");
            return;
        }
        if(amount > sender.balance) {
            System.out.println("Insufficient funds!");
            return;
        }
        sender.balance -= amount;
        recipient.balance += amount;
        sender.addTransaction("Transferred $" + amount + " to account " + recipientAccNum);
        recipient.addTransaction("Received $" + amount + " from account " + sender.accountNumber);
        System.out.println("Transfer successful! Your new balance: $" + sender.balance);
    }
}