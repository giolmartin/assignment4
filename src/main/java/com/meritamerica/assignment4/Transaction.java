package com.meritamerica.assignment4;

import java.util.*;

public abstract class Transaction {
	
	BankAccount sourceAccount;
	BankAccount targetAccount;
	double amount;
	Date transactionDate;
	boolean isProcessed;
	String rejectionReason;

	public BankAccount getSourceAccount() {
		return sourceAccount;
		
	}
	public void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public BankAccount getTargetAccount() {
		return targetAccount;
		
	}
	public void setTargetAccount(BankAccount targetAccount) {
		this.targetAccount = targetAccount;
	}
	public double getAmount() {
		return amount;
	}
	
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getTransactionDate(){
		return transactionDate;
		}
	
	public void setTransactionDate(Date date) {
		transactionDate = date;
	}
	
	public String writeToString() {
		return null;}
	
	
	public static Transaction readFromString(String transactionDataString) {
		int sourceAccount;
		int targetAccount;
		int transactionType;
		double amount;
		int counter = 0;
		Date date;
		String[] values = transactionDataString.split(",");
		try {
			transactionType = Integer.parseInt(values[0]);
			amount = Double.parseDouble(values[2]);
			if (transactionType < 0 && amount < 0) {         //Deposit or WithDrawl
				System.out.println("Withdrawl");
				amount = (amount * (-1));   // convert number positive
				
				//System.out.println("Deposit or Withrawl");
			} else  if (transactionType < 0 && amount >= 0){                           //Transfer
				
				System.out.println("Deposit");
				
				
			} else {
				System.out.println("Transfer");
			}
			
		} catch(NumberFormatException e) {
			throw e;
		}
		
		return null;
	}
	
	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException;
	
	public boolean isProcessedByFraudTeam() {
		return isProcessed;}
	
	public void setProcessedByFraudTeam(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	
	public String getRejectionReason() {
		return rejectionReason;
		}
	
	public void setRejectionReason(String reason) {
		rejectionReason = reason;
	}
}
