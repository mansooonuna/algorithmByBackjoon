import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 그래프 이론
 * 그래프 탐색
 * 너비 우선 탐색
 * 깊이 우선 탐색
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 인접 행렬 방법
        arr = new int[node + 1][node + 1];
        for (int i = 0; i < line; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        check = new boolean[node + 1];
        dfs(start);

        sb.append("\n");
        check = new boolean[node + 1];

        bfs(start);

        System.out.println(sb);
    }

    /**
     * DFS (Depth First Search) -> 깊이 우선 탐색
     * 보통 재귀로 많이 구현
     */
    private static void dfs(int start) {
        // 시작점을 boolean 배열로 체크
        check[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i <= node; i++) {
            // 노드가 연결되어있다 + 아직 순회하지 않았다
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    /**
     * BFS (Breadth First Search) -> 너비 우선 탐색
     * 보통 큐로 많이 구현
     */
    private static void bfs(int start) {
        // 큐에 시작 노드 받아주고 boolean 배열 체크
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start).append(" ");

            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}

/**
 * 예제를 입력받아서 연결이 있으면 1, 없으면 0
 *
 * 0 1 1 1
 * 1 0 0 1
 * 1 0 0 1
 * 1 1 1 0
 */