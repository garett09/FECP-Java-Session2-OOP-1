package org.example;

import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BankSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int userChoice = 0;
        while (userChoice != 6) {
            System.out.println("------Welcome to the Buni Personal Bank ------");
            System.out.println("---Choose your option below ---");
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
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = input.nextLine().trim();
                    System.out.print("Enter Account Number: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid account number.");
                        input.next();
                        System.out.print("Enter Account Number: ");
                    }
                    int accountNumber = input.nextInt();
                    input.nextLine();
                    boolean accountExists = false;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == accountNumber) {
                            accountExists = true;
                            break;
                        }
                    }
                    if (accountExists) {
                        System.out.println("Account with this number already exists. Please try again.");
                    } else {
                        System.out.print("Would you like to make an initial deposit? (yes/no): ");
                        String initialDepositChoice = input.next().trim().toLowerCase();
                        input.nextLine();
                        if (initialDepositChoice.equals("yes")) {
                            System.out.print("Enter initial deposit amount: ");
                            while (!input.hasNextDouble()) {
                                System.out.println("Invalid input. Please enter a valid amount.");
                                input.next();
                                System.out.print("Enter initial deposit amount: ");
                            }
                            double initialDeposit = input.nextDouble();
                            if (initialDeposit <= 0) {
                                System.out.println("Initial deposit must be greater than zero. Account created without initial deposit.");
                            } else if (initialDeposit >= 0) {
                                BankAccount newAccount = new BankAccount(accountNumber, accountHolderName);
                                newAccount.deposit(initialDeposit);
                                accounts.add(newAccount);
                                System.out.println("Account created successfully with initial deposit.");
                            }
                        } else {
                            BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, 0);
                            accounts.add(newAccount);
                            System.out.println("Account created successfully without initial deposit.");
                        }
                        System.out.println("Account created successfully for " + accountHolderName + " with Account Number: " + accountNumber);
                        System.out.println("Would you like to return to the main menu? (yes/no): ");
                        String returnToMenu = input.next().trim().toLowerCase();
                        input.nextLine();
                        if (returnToMenu.equals("yes")) {
                            continue;
                        } else {
                            System.out.println("Exiting account creation.");
                            break;
                        }
                    }
                case 2:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        System.out.println("List of Accounts:");
                        for (BankAccount account : accounts) {
                            account.displayAccountInfo();
                        }
                    }
                    System.out.println("Would you like to return to the main menu? (yes/no): ");
                    String returnToMenu2 = input.next().trim().toLowerCase();
                    input.nextLine();
                    if (returnToMenu2.equals("yes")) {
                        continue;
                    } else {
                        System.out.println("Exiting account view.");
                        break;
                    }
                case 3:
                    System.out.print("Enter Account Number to check balance: ");
                    int checkAccountNumber = input.nextInt();
                    boolean found = false;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == checkAccountNumber) {
                            System.out.println("Available Balance: " + account.getAvailableBalance());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    System.out.println("Would you like to return to the main menu? (yes/no): ");
                    String returnToMenu3 = input.next().trim().toLowerCase();
                    input.nextLine();
                    if (returnToMenu3.equals("yes")) {
                        continue;
                    } else {
                        System.out.println("Exiting balance check.");
                        break;
                    }
                case 4:
                    System.out.print("Enter Account Number to deposit money: ");
                    int depositAccountNumber = input.nextInt();
                    boolean depositFound = false;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == depositAccountNumber) {
                            System.out.print("Enter amount to deposit: ");
                            while (!input.hasNextDouble()) {
                                System.out.println("Invalid input. Please enter a valid amount.");
                                input.next();
                                System.out.print("Enter amount to deposit: ");
                            }
                            double depositAmount = input.nextDouble();
                            account.deposit((int) depositAmount);
                            depositFound = true;
                            break;
                        }
                    }
                    if (!depositFound) {
                        System.out.println("Account not found.");
                    }
                    System.out.println("Would you like to return to the main menu? (yes/no): ");
                    String returnToMenu4 = input.next().trim().toLowerCase();
                    input.nextLine();
                    if (returnToMenu4.equals("yes")) {
                        continue;
                    } else {
                        System.out.println("Exiting deposit.");
                        break;
                    }

                case 5:
                    System.out.print("Enter Account Number to withdraw money: ");
                    int withdrawAccountNumber = input.nextInt();
                    boolean withdrawFound = false;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == withdrawAccountNumber) {
                            System.out.print("Enter amount to withdraw: ");
                            while (!input.hasNextDouble()) {
                                System.out.println("Invalid input. Please enter a valid amount.");
                                input.next();
                                System.out.print("Enter amount to withdraw: ");
                            }
                            double withdrawAmount = input.nextDouble();
                            account.withdraw((int) withdrawAmount);
                            withdrawFound = true;
                            break;
                        }
                    }
                    if (!withdrawFound) {
                        System.out.println("Account not found.");
                    }
                    System.out.println("Would you like to return to the main menu? (yes/no): ");
                    String returnToMenu5 = input.next().trim().toLowerCase();
                    input.nextLine();
                    if (returnToMenu5.equals("yes")) {
                        continue;
                    } else {
                        System.out.println("Exiting withdrawal.");
                        break;
                    }

                case 6:
                    System.out.println("---Thank you for using The Buni Personal Bank---");
                    break;
            }

            }
        }

    }
