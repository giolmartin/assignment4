package com.meritamerica.assignment4;

public class WithdrawTransaction extends Transaction{

	WithdrawTransaction(BankAccount targetAccount, double amount){
		this.targetAccount = targetAccount;
		this.amount = amount;
	}
	
	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		if(amount < 0) {
			throw new NegativeAmountException("Cant withdraw negative amounts");
		} else if (amount>1000) {
			throw new ExceedsFraudSuspicionLimitException("Can't deposit more than $1000");
			
		} else if(targetAccount.getBalance() < amount) {
			throw new ExceedsAvailableBalanceException("Can't withdraw more than in account");
		} else {
			targetAccount.withdraw(amount);
		}
		
	}

}
