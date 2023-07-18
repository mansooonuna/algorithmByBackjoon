import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int count = 0;
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char cmd = input.charAt(i);
            if (cmd == '(') {
                stk.push('(');
            }

            if (cmd == ')') {
                stk.pop();
                // 레이저 -> 막대기 잘림
                if (input.charAt(i - 1) == '(') {
                    count += stk.size();
                } 
                // 레이저 아님 -> 잘리지 않은 막대기 추가
                else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}