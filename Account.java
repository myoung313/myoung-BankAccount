import java.util.Scanner;

public class Account {
    // Class Variables Created
    int balance;
    int previousTranscation;
    String customerName;
    String customerID;

    // Class Constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    // Function for Deposits
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTranscation = amount;
        }
    }

    // Function for Withdrawal
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTranscation = amount;
        }
    }

    // Fuction Displays Previous Transcation
    void getPreviousTranscation() {
        if (previousTranscation > 0) {
            System.out.println("Deposited: " + previousTranscation);
        } else if (previousTranscation < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTranscation));
        } else {
            System.out.println("No Transcation Occured");
        }
    }

    // Function Calculating Interest of current funds after number of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance + interestRate + years) + balance;
        System.out.println("The current interest rate is  " + (100 * interestRate) + " %");
        System.out.println("After " + years + " years , your balance will be: " + newBalance);
    }

    // Function Displaying the Main Menu
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("A. Check Your Balance");
        System.out.println("B. Make A Deposit");
        System.out.println("C. Make A Withdrawal");
        System.out.println("D. View Previous Transcations");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // Case 'A' allows the user to check their bank account balance
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;

                // Case 'B' allows user to deposit money into their account
                case 'B':
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                // Case 'C' allows the user to withdrawal money from account
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                // Case 'D' allow the user to view their most recent transcation
                case 'D':
                    System.out.println("==============================");
                    getPreviousTranscation();
                    System.out.println("==============================");
                    System.out.println();
                    break;

                // Case 'E' calculates the accrued interest on the account after a number of
                // years
                case 'E':
                    System.out.println("Enter how many years of accrued  interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;

                // Case 'F' exits the user from their account
                case 'F':
                    System.out.println("==============================");
                    break;

                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thanks for Banking with us!");
    }
}
