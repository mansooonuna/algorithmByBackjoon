import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, dist;
    static int n, m, targetX, targetY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                } else if (map[i][j] == 1) {
                    dist[i][j] = -1;
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int[] row : dist) {
            for (int d : row) {
                sb.append(d).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{targetX, targetY});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}