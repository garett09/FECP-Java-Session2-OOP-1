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

    





}
