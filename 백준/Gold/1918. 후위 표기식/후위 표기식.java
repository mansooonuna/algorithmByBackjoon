import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String infix = br.readLine();
        char[] chars = infix.toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (char aChar : chars) {
            if (aChar >= 'A' && aChar <= 'Z') {
                answer.append(aChar);
            } else if (aChar == '(') {
                stack.push(aChar);
            } else if (aChar == ')') {
                // 괄호가 제대로 닫힐 때까지 스택에서 연산자를 꺼내 결과에 추가
                while (!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                // 앞에 있는 여는 괄호 제거
                stack.pop();
            }
            // * / 연산자일 경우
            else if (aChar == '*' || aChar == '/') {
                // 스택에 이미 우선순위가 더 높은 연산자가 있다면 결과에 추가
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    answer.append(stack.pop());
                }
                stack.push(aChar);
            }
            // 그 외 연산자
            else {
                // 스택에 이미 우선순위가 더 높은 연산자가 있다면 결과에 추가
                while (!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                stack.push(aChar);
            }
        }
        // 스택에 남아있는 모든 연산자를 결과에 추가
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }
}