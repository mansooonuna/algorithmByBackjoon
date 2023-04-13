import java.util.*;
import java.io.*;


// ([]())
//[]()
//(]
// )(
// ([)]

/**
 * 대괄호와 소괄호의 입력 순서도 지켜야함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = "";
        while (!sentence.equals(".")) {                                     // .이 들어올때까지 입력받음
            sentence = br.readLine();
            if (sentence.equals(".")) {                                     // .만 들어왔을 때는 출력문구 없음
                break;
            }
            // 문자열 하나씩 비교
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);

                // 여는괄호가 들어왔으면 push
                if (c == '(' || c == '[') {
                    stack.push(c);
                    // 닫는 괄호가 들어오고 자신의 짝 괄호이면 pop
                    // 여기서 처음에 EmpthStackExcepton 방지하려고
                    /**
                     * try {
                     *   stack.pop();
                     * } catch(Exception e) {
                     *   stack.push(c);
                     *   break;
                     * }
                     */
                    // 예외처리해주었지만 소용없었음
                } else if (c == ')') {
                    if ( stack.isEmpty() || stack.peek() != '(') {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }

                } else if (c == ']') {
                    if ( stack.isEmpty() || stack.peek() != '[') {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }

            }

            if (stack.isEmpty()) {
                bw.write("yes" + "\n");
            } else {
                bw.write("no" + "\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}