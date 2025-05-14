package Bank;

// Bank.SavingsAccount
public class SavingsAccount extends Account {
    private static final double DAILY_INTEREST_RATE = 0.0008; // 0.08%

    public SavingsAccount(String owner, double initialBalance) {
        super(owner, initialBalance);
    }

    @Override
    public void applyDailyInterest() {
        balance += balance * DAILY_INTEREST_RATE;
    }

    @Override
    public void printStatement() {
        System.out.println("Owner: " + owner);
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
}
