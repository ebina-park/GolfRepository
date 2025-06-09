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

            // 숫자 개수가 2개가 아니거나 연산자 없음
            if (numbers.length != 2 || operator == ' ') {
                System.out.println("正しくない入力です");
                continue;
            }

            try {
                int 숫자1 = Integer.parseInt(numbers[0]);
                int 숫자2 = Integer.parseInt(numbers[1]);
                int result = 0;

                switch (operator) {
                    case '+':
                        result = 숫자1 + 숫자2;
                        break;
                    case '-':
                        result = 숫자1 - 숫자2;
                        break;
                    case '*':
                        result = 숫자1 * 숫자2;
                        break;
                    case '/':
                        if (숫자2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue;
                        }
                        result = 숫자1 / 숫자2;
                        break;
                }

                System.out.println("결과: " + result);
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식이 잘못되었습니다.");
            }
        }
    }
}
