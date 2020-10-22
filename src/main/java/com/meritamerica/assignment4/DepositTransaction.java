package com.meritamerica.assignment4;

public class DepositTransaction extends Transaction{
	
	
	DepositTransaction(BankAccount targetAccount, double amount ){
		this.targetAccount = targetAccount;
		this.amount = amount;
	}
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		
		if(amount < 0) {
			throw new NegativeAmountException("Cant deposit negative amounts");
		} else if (amount>1000) {
			throw new ExceedsFraudSuspicionLimitException("Can't deposit more than $1000");
			
		} else if(targetAccount.getBalance() > 250000) {
			throw new ExceedsAvailableBalanceException("Can't deposit to this account");
		} else {
			System.out.println("test");
			targetAccount.deposit(amount);
		}
		
	

}

}
