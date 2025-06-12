package AtmPractice;

public class Atm {
    private Account account;

    public Atm(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.printf("現在の残高: %.2f%n", account.getBalance());
    }
}
