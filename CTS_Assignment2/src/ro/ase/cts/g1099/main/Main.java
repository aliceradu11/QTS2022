package ro.ase.cts.g1099.main;

import ro.ase.cts.g1099.models.Account;
import ro.ase.cts.g1099.models.AccountType;

public class Main {

	public static void main(String[] args) throws Exception {
		Account account1 = new Account(3.33, 2022.22, AccountType.PREMIUM);
		
		account1.getMonthlyRate();
		System.out.println(account1);

	}

}
