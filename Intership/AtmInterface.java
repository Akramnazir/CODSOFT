
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Invalid deposit amount.";
        }
        balance += amount;
        return "Successfully deposited " + amount + ". Current balance: " + balance;
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Invalid withdrawal amount.";
        }
        if (balance < amount) {
            return "Insufficient balance.";
        }
        balance -= amount;
        return "Successfully withdrew " + amount + ". Current balance: " + balance;
    }

    public String checkBalance() {
        return "Your account balance is: " + balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("=== ATM Menu ===");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    String withdrawResult = bankAccount.withdraw(withdrawAmount);
                    System.out.println(withdrawResult);
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    String depositResult = bankAccount.deposit(depositAmount);
                    System.out.println(depositResult);
                    break;

                case 3:
                    String balanceResult = bankAccount.checkBalance();
                    System.out.println(balanceResult);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        double initialBalance = 1000; // Initial balance for the user's bank account
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
