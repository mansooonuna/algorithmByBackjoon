import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance; // 각 도시까지 최단 거리 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 개수
        int m = Integer.parseInt(st.nextToken()); // 도로 개수
        int k = Integer.parseInt(st.nextToken()); // 최단 거리
        int x = Integer.parseInt(st.nextToken()); // 출발 도시

        // 초기화
        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        // x-x는 0
        distance[x] = 0;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int nextNode = graph.get(cur).get(i);
                if (distance[nextNode] == -1) { // 미방문
                    distance[nextNode] = distance[cur] + 1;
                    queue.offer(nextNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean check = false; // 최단 거리가 K인 도시가 있는지 체크
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                sb.append(i).append("\n");
                check = true;
            }
        }

        // 만약 최단 거리가 K인 도시가 없다면, -1
        if (!check) {
            sb.append("-1");
        }

        System.out.println(sb);
    }
}