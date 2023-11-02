import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] family;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수

        family = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            family[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aPerson = Integer.parseInt(st.nextToken());
        int bPerson = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 관계 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            family[parent].add(child);
            family[child].add(parent);
        }

        System.out.println(bfs(aPerson, bPerson));
    }

    static int bfs(int aPerson, int bPerson) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(aPerson);
        visited[aPerson] = true;

        int chonSu = 0;

        while (!queue.isEmpty()) {
            // 현재 촌수에 있는 노드 개수
            int size = queue.size();
            chonSu++;

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                // 현재 노드와 연결된 이웃 노드 순회
                for (int f : family[cur]) {
                    if (!visited[f]) {
                        if (f == bPerson) return chonSu;

                        visited[f] = true;
                        queue.add(f);
                    }
                }
            }
        }
        return -1;
    }
}