package Bank;

// Abstract Base Class: Bank.Account
public abstract class Account {
    protected String owner;
    protected double balance;

    public Account(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transferTo(Account target, double amount) {
        if (withdraw(amount)) {
            target.deposit(amount);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void applyDailyInterest();

    public abstract void printStatement();
}
