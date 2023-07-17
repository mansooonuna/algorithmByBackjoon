import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            List<Integer> priorities = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                priorities.add(Integer.parseInt(st2.nextToken()));
            }
            int answer = getPrintOrder(priorities, M);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int getPrintOrder(List<Integer> priorities, int M) {
        int order = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.size(); i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int front = queue.poll();
            boolean isMaxPriority = true;
            for (int num : queue) {
                if (priorities.get(num) > priorities.get(front)) {
                    isMaxPriority = false;
                    break;
                }
            }
            if (isMaxPriority) {
                order++;
                if (front == M) {
                    return order;
                }
            } else {
                queue.offer(front);
            }
        }
        return order;
    }
}