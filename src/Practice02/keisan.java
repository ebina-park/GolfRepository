package Practice02;
import java.util.Scanner;

public class keisan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("値を入力してください: ");
            String input = sc.nextLine().trim();  // 공백 제거 + 엔터만 눌렀을 때 방지

            if (input.isEmpty()) {
                System.out.println("空欄✖.");
                continue;
            }

            input = input.replaceAll(" ", "");  // 중간 공백 제거
            String[] numbers = input.split("[+\\-*/]");
            char operator = ' ';

            // 연산자 찾기
            for (char c : input.toCharArray()) {
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    operator = c;
                    break;
                }
            }

            // num 개수가 2개가 아니거나 연산자 없음
            if (numbers.length != 2 || operator == ' ') {
                System.out.println("正しくない入力です");
                continue;
            }

            try {
                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);
                int result = 0;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("0は使えません.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                }

                System.out.println("結果: " + result);
                break;
            } catch (NumberFormatException e) {
                System.out.println("正しくない形式です");
            }
        }
    }
}
