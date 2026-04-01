import java.util.Scanner;
import java.util.InputMismatchException;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Transaction failed.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        }
    }

    public void displayBalance() {
        System.out.println("\n----------------------------");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
        System.out.println("----------------------------");
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Initializing with dummy data
        Account userAccount = new Account("BANK12345", "Anuj", 1000.00);

        System.out.println("Welcome to the Online Banking System");

        boolean running = true;
        while (running) {
            try {
                System.out.println("\n1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        userAccount.displayBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        userAccount.deposit(scanner.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        userAccount.withdraw(scanner.nextDouble());
                        break;
                    case 4:
                        System.out.println("Thank you for using our services. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numerical value.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.close();
    }
}