import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graphs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        graphs = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graphs[a].add(b);
            graphs[b].add(a);
        }
        visited = new boolean[N + 1];
        System.out.println(dfs(1) - 1);
    }

    private static int dfs(int node) {
        int cnt = 1;
        visited[node] = true;
        for (Integer com : graphs[node]) {
            if (!visited[com]) cnt += dfs(com);
        }
        return cnt;
    }
}