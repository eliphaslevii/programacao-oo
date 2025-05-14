package Bank;

// Bank.Main Class
public class Main {
    public static void main(String[] args) {
        CheckingAccount acc1 = new CheckingAccount("Alice", 1000);
        SavingsAccount acc2 = new SavingsAccount("Dilera", 1500);
        SalaryAccount acc3 = new SalaryAccount("Carlos", 1200);

        acc1.deposit(200);                   // Alice adds funds
        acc2.withdraw(100);                  // Bob takes some cash
        acc3.transferTo(acc1, 300);          // Carlos pays Alice

        acc1.applyDailyInterest();
        acc2.applyDailyInterest();
        acc3.applyDailyInterest();

        acc1.printStatement();
        acc2.printStatement();
        acc3.printStatement();
    }
}
