package ro.ase.cts.g1099.models;

import ro.ase.cts.g1099.exceptions.InvalidLoanValException;
import ro.ase.cts.g1099.exceptions.InvalidRateValException;
import ro.ase.cts.g1099.interfaces.MonthlyRateInterface;
import ro.ase.cts.g1099.models.Account;

public class Account implements MonthlyRateInterface {
	private AccountType accountType;
	public double loanValue, rateValue;
	public int daysActive;

	public Account(double loanValue, double rateValue, AccountType accountType) throws Exception {
		if (loanValue < 0)
			throw new Exception();
		else {
			this.loanValue = loanValue;
			this.rateValue = rateValue;
			this.accountType = accountType;
		}
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
		System.out.println("The rate is " + rateValue);
		return this.rateValue;
	}

	public void setRate(double rateValue) {
		if (rateValue < 0)
			throw new InvalidRateValException();
		else {
			this.rateValue = rateValue;
		}
	}

	public int getDaysActive() {
		System.out.println("The number of active days is " + this.daysActive);
		return daysActive;
	}

	public void setDaysActive(int daysActive) throws Exception {
		if(daysActive <0)
			throw new Exception();
		else {
			this.daysActive = daysActive;
		}
	}
	
	@Override
	public double getMonthlyRate() {
		System.out.println("The monthly rate is " + loanValue * rateValue);
		return loanValue * rateValue;
	}

	public static double calculateTotalFee(Account[] accounts) {
		double totalFee = 0.0;
		Account account;
		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.accountType == AccountType.PREMIUM || account.accountType == AccountType.SUPER_PREMIUM)
				totalFee += .0125 * (
				account.loanValue * Math.pow(account.rateValue, (account.daysActive / 365)) - account.loanValue);
		}
		return totalFee;
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
