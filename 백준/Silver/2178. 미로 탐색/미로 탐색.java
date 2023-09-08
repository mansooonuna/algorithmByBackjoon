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
 */
public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(maze[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny] || maze[nx][ny] == 0)
                    continue;

                queue.add(new int[]{nx, ny});
                maze[nx][ny] = maze[curX][curY] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}