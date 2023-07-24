import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            // 절댓값을 비교하는 방식 Comparator
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            // 두 수의 절댓값을 비교하여 우선순위를 결정
            if (abs1 == abs2) {
                return Integer.compare(o1, o2); // 절댓값이 같을 경우 원래 순서를 유지
            } else {
                return Integer.compare(abs1, abs2); // 절댓값이 다를 경우 절댓값이 작은 순서대로 정렬
            }
        });

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                priorityQueue.offer(num);
            } else {
                if (priorityQueue.isEmpty()) sb.append("0").append("\n");
                else {
                    sb.append(priorityQueue.remove()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}