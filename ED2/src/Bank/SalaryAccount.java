package Bank;

// Bank.SalaryAccount
public class SalaryAccount extends Account {
    public SalaryAccount(String owner, double initialBalance) {
        super(owner, initialBalance);
    }

    @Override
    public void applyDailyInterest() {
        // Salary accounts do not accrue interest
    }

    @Override
    public void printStatement() {
        System.out.println("Owner: " + owner);
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
}
