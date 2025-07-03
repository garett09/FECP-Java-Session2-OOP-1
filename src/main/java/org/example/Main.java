package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int userChoice = 0;
        System.out.println("------Welcome to the Buni Personal Bank ------");
        System.out.println("---Choose your option below ---");
        while (userChoice != 6) {
            System.out.println("\n1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Exit");
            while (!input.hasNextInt()) {
                System.out.println("Invalid Input. Please input between 1 and 6");
                input.next();
                System.out.println("Choose your option:");
            }
            userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter Account Name: ");
                    String accountName = input.nextLine();
                    System.out.print("Enter Account Number: ");
                    int accountNumber = input.nextInt();
                    System.out.println("Do you want to deposit an initial amount? (yes/no)");
                    String initialDepositChoice = input.next();
                    double initialDeposit = 0;
                    if (initialDepositChoice.equalsIgnoreCase("yes")) {
                        System.out.print("Enter initial deposit amount: ");
                        while (!input.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            input.next();
                            System.out.print("Enter initial deposit amount: ");
                        }
                        initialDeposit = input.nextDouble();
                        BankAccount newAccount = new BankAccount(accountNumber,accountName, initialDeposit);
                        accounts.add(newAccount);
                    } else if (initialDepositChoice.equalsIgnoreCase("no")) {
                        BankAccount newAccount = new BankAccount(accountNumber,accountName, 0);
                        accounts.add(newAccount);
                    } else {
                        System.out.println("Invalid choice. Account created without initial deposit.");
                        BankAccount newAccount = new BankAccount(accountNumber,accountName, 0);
                        accounts.add(newAccount);
                    }
                    break;
                case 2:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        System.out.println("List of Accounts:");
                        for (BankAccount account : accounts) {
                            account.displayAccountInfo();
                        }
                    }
                    break;

            }
        }

        }
    }
