// All Groovy classes are public by default
class BankAccount {
	private balance
	
	BankAccount(openingBalance) {
		balance = openingBalance
	}
	
	void deposit(amount){
		balance += amount
	}
	
	void withdraw(amount) {
		if(amount > balance)
			throw new InsufficientFundsException()
		balance -= amount
	}
	
	def void accrueInterest() {
		def service = new InterestRateService()
		def rate = service.getInterestRate()
		
		// example: 40 = 500 * 0.10
		def accruedInterest = balance * rate
		
		deposit(accruedInterest)
	}
	
	// this overrides the default getter created by groovy
	// to prevent accessing a private field
	/*
	def getBalance() {
		// return balance
	}
	*/
}