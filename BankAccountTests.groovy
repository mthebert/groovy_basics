import groovy.util.GroovyTestCase
import groovy.mock.interceptor.*

class BankAccountTests extends GroovyTestCase {
	private account
	
	def void setUp(){
		// println("in setup")
		account = new BankAccount(10)
	}
	
	def void tearDown(){
		// println("in teardown")
		account = null
	}
	
	def void testCanDepositMoney() {
		account.deposit(5)
		assert 15 == account.balance
		// assert 25 == account.balance
	}
	
	def void testCanWithdrawMoney() {
		account.withdraw(5)
		assert 5 == account.balance
	}
	
	def void testCannotWithdrawMoreMoneyThanBalance() {
		shouldFail(InsufficientFundsException) {
			account.withdraw(15)
		}
	}
	
	def void testCanAccrueInterest() {
		// does not insure that the service gets called
		// def service = new StubFor(InterestRateService)
		def service = new MockFor(InterestRateService)
		service.demand.getInterestRate {
			return 0.10
		}
		service.use{
			account.accrueInterest()
			assert 11 == account.balance
		}
	}
}
