import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        // 문자열을 입력받아 저장
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            strings[i] = str;
        }

        // 스택 활용하여 같은 문자면 POP, 다른 문자면 PUSH
        for (String s : strings) {
            Stack<Character> stack = new Stack<>();

            // 문자열 하나씩 비교
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 스택이 비어있으면 오류가 생기므로
                // 스택이 비어있지 않고 peek값이 같다면 pop
                if ( !stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }

            }
            // 스택이 비어있다는건 좋은 단어라는 뜻
            if (stack.isEmpty()) {
                count++;
            }

        }
        System.out.println(count);
    }
}