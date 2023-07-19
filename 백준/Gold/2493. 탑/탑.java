import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                if (arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                } else {
                    ans.add(stack.peek() + 1);
                    break;
                }
            }
            if (stack.isEmpty()) {
                ans.add(0);
            }
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}