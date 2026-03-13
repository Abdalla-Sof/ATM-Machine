import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("===== Welcome to the ATM System =====");

        Account currentUser = null;
        int attempts = 0;

        while(currentUser == null && attempts < 3) {
            System.out.print("Enter Account Number: ");
            int accNum = sc.nextInt();
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            currentUser = atm.login(accNum, pin);

            if(currentUser == null) {
                attempts++;
                System.out.println("Invalid credentials! Attempts left: " + (3 - attempts));
            }
        }

        if(currentUser == null) {
            System.out.println("Too many failed attempts! Exiting...");
            return;
        }

        // User menu
        while(true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Your balance: $" + currentUser.balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    currentUser.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    currentUser.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient account number: ");
                    int recipient = sc.nextInt();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = sc.nextDouble();
                    atm.transfer(currentUser, recipient, transferAmount);
                    break;
                case 5:
                    currentUser.printTransactions();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please choose 1-6.");
            }
        }
    }
}