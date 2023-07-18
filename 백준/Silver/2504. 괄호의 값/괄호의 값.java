import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int tmp = 1;
        boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {
            char cmd = input.charAt(i);
            switch (cmd) {
                case '(':
                    stack.push('(');
                    tmp *= 2;
                    break;
                case '[':
                    stack.push('[');
                    tmp *= 3;
                    break;
                case ')':
                   if (stack.isEmpty() || stack.peek() != '(') { // 유효하지 않은 괄호
                       isValid = false;
                       break;
                   } else if (input.charAt(i-1) == '(') {
                       ans += tmp;
                   }
                   stack.pop();
                   tmp /= 2;
                   break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') { // 유효하지 않은 괄호
                        isValid = false;
                        break;
                    } else if (input.charAt(i-1) == '[') {
                        ans += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                    break;
            }
        }
        if (!stack.isEmpty() || !isValid) System.out.println("0");
        else System.out.println(ans);
    }
}