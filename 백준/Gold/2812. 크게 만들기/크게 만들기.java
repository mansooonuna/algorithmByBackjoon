import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && K > 0 && stack.peek() < input.charAt(i)) {
                stack.pop();
                K--;
            }
            stack.push(input.charAt(i));
        }
        
        if (K > 0) {
            while (K --> 0) stack.pop();
        }

        for (Character character : stack) {
            sb.append(character);
        }

        System.out.println(sb);
    }
}