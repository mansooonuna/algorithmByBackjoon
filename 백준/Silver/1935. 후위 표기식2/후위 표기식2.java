import java.io.*;
import java.util.*;

/**
 * 후위표기식2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 피연산자 개수 = 5
        String cmd = br.readLine();              // 후위표기식 : ABC*+DE/-

        // 피연산자 갯수 크기의 int 배열 만들고 배열에 피연산자 대응하는 값 넣기
        int[] arr = new int[N]; // 1 2 3 4 5
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 스택 배열 생성 -> cmd의 입력값이 영어 대문자이면 arr의 0번 원소부터 push
        // 연산자를 만나면 숫자 두개 pop 해당 연산 수행 -> 연산 결과 다시 push
        // 마지막 출력이 소숫점 둘째 자리까지 이므로 스택은 double
        Stack<Double> stk = new Stack<>();
        for (int i = 0; i < cmd.length(); i++) {
            char c = cmd.charAt(i); // A, B, C, *, +, D, E, /, -
            // A ~ Z 대문자이면
            if (c >= 'A' && c <= 'Z') {
                double rs = arr[c - 'A']; // arr[0] arr[1] arr[2] arr[3] arr[4]
                stk.push(rs);             // arr 원소 스택에 push
            }
            // 연산자를 만났다면?
            else {
                // 스택에서 pop 두 번 , 연산결과 push
                double pop1 = 0.0;
                double pop2 = 0.0;
                double answer = 0.0;
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
        System.out.println(String.format("%.2f", stk.pop()));
    }
}