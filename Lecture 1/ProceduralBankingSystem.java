import java.util.ArrayList;
import java.util.Scanner;

public class ProceduralBankingSystem {
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.next();
        accounts.add(new Account(name, 0));
        System.out.println("Account created.");
    }

    static void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (accountNumber >= 0 && accountNumber < accounts.size()) {
            Account account = accounts.get(accountNumber);
            account.balance += amount;
            System.out.println("Deposit successful. New balance: " + account.balance);
        } else {
            System.out.println("Invalid account number.");
        }
    }

    static void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (accountNumber >= 0 && accountNumber < accounts.size()) {
            Account account = accounts.get(accountNumber);
            if (account.balance >= amount) {
                account.balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + account.balance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }
}

class Account {
    String holderName;
    double balance;

    Account(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
    }
}
