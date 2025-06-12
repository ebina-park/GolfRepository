package AtmPractice;

public class Account {
    private String accountNumber;
    private String password;
    private double balance;

    public Account(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = 5000;
    }

    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("入金額: ¥%.2f%n", amount);
        } else {
            System.out.println("無効な入金額です。");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("出金額: ¥%.2f%n", amount);
            } else {
                System.out.println("残高不足です。");
            }
        } else {
            System.out.println("無効な出金額です。");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
