import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graphs;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graphs[a].add(b);
            graphs[b].add(a);
        }

        int minKevinBacon = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int kevinBacon = bfs(i);
            if (kevinBacon < minKevinBacon) {
                minKevinBacon = kevinBacon;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graphs[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                }
            }
        }
        int kevinBacon = 0;
        for (int i = 1; i <= N ; i++) {
            kevinBacon += distance[i];
        }
        return kevinBacon;
    }
}

/*
  1 2 3 4 5
1 0 0 1 1 0
2 0 0 1 0 0
3 1 1 0 1 0
4 1 0 1 0 1
5 0 0 0 1 0

1 케빈 베이컨 : 6
1 - 3 - 2 (2)
1 - 3 (1)
1 - 4 (1)
1 - 4 - 5 (2)
 */