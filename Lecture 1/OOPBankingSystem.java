import java.util.ArrayList;
import java.util.Scanner;

public class OOPBankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.deposit();
                    break;
                case 3:
                    bank.withdraw();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class Bank {
    private ArrayList<Account> accounts;
    private Scanner scanner;

    Bank() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.next();
        accounts.add(new Account(name));
        System.out.println("Account created.");
    }

    void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (accountNumber >= 0 && accountNumber < accounts.size()) {
            Account account = accounts.get(accountNumber);
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Invalid account number.");
        }
    }

    void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (accountNumber >= 0 && accountNumber < accounts.size()) {
            Account account = accounts.get(accountNumber);
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }
}

class Account {
    private String holderName;
    private double balance;

    Account(String holderName) {
        this.holderName = holderName;
        balance = 0;
    }

    void deposit(double amount) {
        balance += amount;
    }

    boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    double getBalance() {
        return balance;
    }
}
