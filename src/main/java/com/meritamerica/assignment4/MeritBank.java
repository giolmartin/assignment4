package com.meritamerica.assignment4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MeritBank{
	
	private static AccountHolder[] accounts = new AccountHolder[0];
	private static CDOffering[] cdOfferings = new CDOffering[3];
	                                     
	private static  long accountNumber = 1;
	
	private static CDOffering bestCDOffering;
	private static CDOffering secondBestCDOffering;
	private static int counterA = 0;//counter accounts at addAccountHolder()
	
	public static void addAccountHolder(AccountHolder accountHolder) 
	{
		if(counterA == accounts.length)
		{
			AccountHolder[] newAccounts = new AccountHolder[counterA + 1];
			for(int i = 0; i <counterA ; i++)
			{
				newAccounts[i] = accounts[i];
			}
			accounts = newAccounts;
		}
			accounts[counterA++] = accountHolder;
			
	}
	
	public static AccountHolder[] getAccountHolders() 
	{
		return accounts;
	}
	
	public static CDOffering[] getCDOfferings() 
	{
		
		
		return  cdOfferings;	
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) 
	{
		return bestCDOffering;
	}
	public static CDOffering getSecondBestCDOfferings(double depositAmount)
	{
		return secondBestCDOffering;
	}
	
	public static void clearCDOfferings() 
	{
		cdOfferings = null;	
	}
	
	public static void setCDOfferings(CDOffering[] offerings)
	{
		cdOfferings = offerings;
	}
	
	public  static long getNextAccountNumber() 
	{
		return accountNumber ;
	}
	public static void setAccountNumber(Long accountN) 
	{
		accountNumber = accountN;
	}
	public static double totalBalances() 
	{
		double tB = 0;
		System.out.println("Method Total Balance" + tB);
		return tB;
	}
	
	public static double futureValue(double presentValue, double interestRate, int term) 
	{
		return 0;
	}
	
	
	public static boolean readFromFile(String fileName)   // --------------------------> Read transactions and the Fraud Queue TODO. Revise Savings, Checkings Exceptions.
	{
		File file = new File(fileName);
		ArrayList<String> values = new ArrayList<String>();
		
		int cdofferingsCounter; 
		AccountHolder ac;
		int checkingCounter;
		int accountHolderCounter;
		int savingsCounter;
		int cdAccountCounter;
		int index = 0;
		long accountN;
		try (BufferedReader bR = new BufferedReader(new FileReader(file)) )
		{	
			String line;
			while((line = bR.readLine()) != null)
			{	
				values.add(line);								
			}
			accountN = Long.parseLong(values.get(index));
			setAccountNumber(accountN);
			index++;        
			cdofferingsCounter = Integer.parseInt(values.get(index));
			index++;
			for(int i = index ; i < cdofferingsCounter + index; i ++) //runs the amount of cd offerings
			{ 
				CDOffering.readFromString(values.get(i)); 	
			}
			index += cdofferingsCounter ;
			accountHolderCounter = Integer.parseInt(values.get(index));
			index++;
			for(int i = index; i < accountHolderCounter + index; i++) 
			{
				if (index == values.size())return true; //checks to see if the index is at the end of the array.
				addAccountHolder(ac = AccountHolder.readFromString(values.get(index)));
				index++; 
				checkingCounter = Integer.parseInt(values.get(index));
				index++;
				if(checkingCounter != 0)
				{
					for (int j = index ; j < checkingCounter + index ; j++) 
					{	
						ac.addCheckingAccount(CheckingAccount.readFromString(values.get(j)));
					}
				} 
				index += checkingCounter;
				savingsCounter = Integer.parseInt(values.get(index));
				index++;
				if(savingsCounter != 0)
				{
					for(int k = index; k < savingsCounter + index; k++)
					{
						ac.addSavingsAccount(SavingsAccount.readFromString(values.get(k)));
					}
				}
				index += savingsCounter;
				cdAccountCounter = Integer.parseInt(values.get(index));
				index++;
				if(cdAccountCounter != 0)
				{
					for(int x = index; x < cdAccountCounter + index; x++)
					{
						ac.addCDAccount(CDAccount.readFromString(values.get(x)));
					}
				}
				index += cdAccountCounter;
			}
		}catch(NumberFormatException e)
		{
			return false;
		} 
		catch(NullPointerException n)
		{
			System.out.println(n.getMessage());
			return false;
		}
		catch(IOException e )
		{
			e.getStackTrace();
			System.out.println("File not found");
		}
		return true; 
	}
	
	public static boolean writeToFile(String fileName)
	{
		return true;
	}
	
	public static AccountHolder[] sortAccountHolders() 
	{
		 Arrays.sort(accounts);
		 return accounts;
	}
	
	public static void setNextAccountNumber(long nextAccountNumber) 
	{
		++accountNumber ;
	}

	
	//-------------------------------------------------------Assignment4---------------------------------------
	
	public static double recursiveFutureValue(double amount, int years, double interestRate) {
		
		//No MathPow, but recursive
		return 0; // ---------------------------> //(amount * recursiveFutureValue((1 + interestRate), years - 1)); TODO for loop maybe.
	}
	
	public static boolean processTransaction(Transaction transaction) throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		return false;
		
	}
	
	public static FraudQueue getFraudQueue() {
		return null;
		
	}
	
	public static BankAccount getBankAccount(long accountId) {
		return null;
	}
	
	
	
	
}
