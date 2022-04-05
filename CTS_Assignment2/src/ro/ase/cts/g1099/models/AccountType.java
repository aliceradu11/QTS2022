package ro.ase.cts.g1099.models;

public enum AccountType {
	STANDARD(0),
	BUDGET(1),
	PREMIUM(2),
	SUPER_PREMIUM(3);
	
	int type;
	
	private AccountType(int type) {
		this.type=type;
	}
	
	public int getAccountType() {
		return type;
	}	
}
