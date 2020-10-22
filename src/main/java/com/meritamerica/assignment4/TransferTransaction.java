package com.meritamerica.assignment4;

public class TransferTransaction extends Transaction{

	TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount){
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.amount = amount;
	}
	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		if(amount < 0) {
			throw new NegativeAmountException("Cant transfer negative amounts");
		} else if (amount>1000) {
			throw new ExceedsFraudSuspicionLimitException("Can't deposit more than $1000");
			
		} else if(sourceAccount.getBalance() < amount) {
			throw new ExceedsAvailableBalanceException("Can't withdraw more than in account");
		} else {
			sourceAccount.withdraw(amount);
			targetAccount.deposit(amount);
		}
		
	}

}
