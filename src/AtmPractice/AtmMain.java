package AtmPractice;

import java.util.Scanner;

public class AtmMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account account = new Account("1234", "4321");

        System.out.println("ATMシステムへようこそ");
        System.out.print("口座番号を入力してください: ");
        String inputAccount = scanner.nextLine();

        System.out.print("パスワードを入力してください: ");
        String inputPassword = scanner.nextLine();

        if (!account.getAccountNumber().equals(inputAccount) || !account.authenticate(inputPassword)) {
            System.out.println("認証に失敗しました。終了します...");
            return;
        }

        Atm atm = new Atm(account);

        while (true) {
            System.out.println("\n--- ATM メニュー ---");
            System.out.println("1. 入金");
            System.out.println("2. 出金");
            System.out.println("3. 残高照会");
            System.out.println("4. 終了");
            System.out.print("オプションを選択してください (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("入金額を入力してください: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    atm.deposit(depositAmount);
                    break;
                case "2":
                    System.out.print("出金額を入力してください: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    atm.withdraw(withdrawAmount);
                    break;
                case "3":
                    atm.checkBalance();
                    break;
                case "4":
                    System.out.println("ATMをご利用いただきありがとうございました。さようなら！");
                    scanner.close();
                    return;
                default:
                    System.out.println("無効な選択です。正しいオプションを選んでください。");
            }
        }
    }
}
