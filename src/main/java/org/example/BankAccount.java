package org.example;

public class BankAccount {
    private int accountNumber;
    private String acctHolderName;
    private int availableBalance;

    public BankAccount(int accountNumber, String acctHolderName, int availableBalance){
        this.accountNumber = accountNumber;
        this.acctHolderName = acctHolderName;
        this.availableBalance = availableBalance;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }
    public void setAccountNumber(){
        this.accountNumber = accountNumber;
    }

    public String getAcctHolderName(){
        return this.acctHolderName;
    }

    public void setAcctHolderName(){
        this.acctHolderName = acctHolderName;
    }

    public int getAvailableBalance(){
        return this.availableBalance;
    }

    public void setAvailableBalance(){
         this.availableBalance=availableBalance;
    }

    public void deposit(int amount){
        if(amount > 0){
            this.availableBalance += amount;
            System.out.println("Deposit successful. New balance: " + this.availableBalance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(int amount){
        if(amount > 0 && amount <= this.availableBalance){
            this.availableBalance -= amount;
            System.out.println("Withdrawal successful. New balance: " + this.availableBalance);
        } else if (amount > this.availableBalance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
    public void displayAccountInfo(){
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.acctHolderName);
        System.out.println("Available Balance: " + this.availableBalance);
    }
}

