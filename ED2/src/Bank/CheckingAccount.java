package Bank;

// Bank.CheckingAccount
public class CheckingAccount extends Account {
    private static final double DAILY_INTEREST_RATE = 0.001; // 0.1%

    public CheckingAccount(String owner, double initialBalance) {
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
