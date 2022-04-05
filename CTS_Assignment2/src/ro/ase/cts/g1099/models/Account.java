package ro.ase.cts.g1099.models;

import ro.ase.cts.g1099.exceptions.InvalidLoanValException;
import ro.ase.cts.g1099.models.Account;

public class Account {
	private AccountType accountType;
	public double	loanValue,rateValue;	
	public int	daysActive;
	
	public Account(double loanValue, double rateValue, AccountType accountType) throws Exception {
		if(loanValue<0)
		{
			throw new Exception();
		}
		else
		{
			this.loanValue = loanValue;
		}
		this.rateValue = rateValue;
		this.accountType = accountType;
	}
	
	public double getLoanValue() {
		System.out.println("The loan value is " + this.loanValue);
		return loanValue;
	}
	
	public void setLoanValue(double loanValue) {
		if (loanValue < 0)
			throw new InvalidLoanValException();
		else {
			this.loanValue = loanValue;
		}
	}
	
	public double getRate() {
		System.out.println("The rate is "+rateValue);
		return this.rateValue;
	}
	
	public double getMonthlyRate() {
		System.out.println("The monthly rate is " + loanValue * rateValue);
		return loanValue*rateValue;
	}
	
	
	
	
	public void print() {
		int vb = 10;
		System.out.println("This is an account");
	}

	public static double calculate(Account[] 	accounts)
	{
	double totalFee=0.0;
	Account	account;
	int temp = 365;
	for	(int	i=0;i<accounts.length;i++)	{
	account=accounts[i];
	if(account.accountType==Account.PREMIUM||account.accountType==Account.SUPER_PREMIUM)	
	totalFee+=.0125	*	(	//	1.25%	broker's	fee
			account.loanValue*Math.pow(account.rateValue,(account.daysActive/365)) - account.loanValue);	//	interest-principal
	}
	return	totalFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountType=");
		builder.append(accountType);
		builder.append(", loanValue=");
		builder.append(loanValue);
		builder.append(", rateValue=");
		builder.append(rateValue);
		builder.append(", daysActive=");
		builder.append(daysActive);
		builder.append("]");
		return builder.toString();
	}
	
	
}
