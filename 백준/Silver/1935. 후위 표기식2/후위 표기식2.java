import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String cmd = br.readLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stk = new Stack<>();
        for (int i = 0; i < cmd.length(); i++) {
            char c = cmd.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                double rs = arr[c - 'A'];
                stk.push(rs);
            } else {
                double pop1;
                double pop2;
                double answer;
                switch (c) {
                    case '*':
                        pop1 = stk.pop();
                        pop2 = stk.pop();
                        answer = pop2 * pop1;
                        stk.push(answer);
                        break;
                    case '+':
                        pop1 = stk.pop();
                        pop2 = stk.pop();
                        answer = pop2 + pop1;
                        stk.push(answer);
                        break;
                    case '/':
                        pop1 = stk.pop();
                        pop2 = stk.pop();
                        answer = pop2 / pop1;
                        stk.push(answer);
                        break;
                    case '-':
                        pop1 = stk.pop();
                        pop2 = stk.pop();
                        answer = pop2 - pop1;
                        stk.push(answer);
                        break;
                }

            }
        }
        System.out.printf("%.2f", stk.pop());
    }
}