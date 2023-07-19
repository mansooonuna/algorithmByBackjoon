import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 현재 탑의 높이와 이전 탑의 높이를 비교하여 레이저 신호를 수신하는 탑을 찾을 수 있습니다.
 * 스택을 사용하여 수신 가능한 탑의 인덱스를 기록합니다.
 * 스택의 맨 위에 있는 탑의 높이가 현재 탑의 높이보다 작거나 같을 때까지 스택에서 탑을 제거합니다.
 * 수신 가능한 탑이 없으면 0을 기록하고, 수신 가능한 탑이 있으면 해당 탑의 인덱스를 기록합니다.
 */
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

        // 현재까지 탐색한 탑의 인덱스를 저장
        Stack<Integer> stack = new Stack<>();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                // 레이저 신호를 수신할 수 없는 탑 -> pop();
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