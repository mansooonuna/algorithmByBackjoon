import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 구현
 * 그래프 이론
 * 그래프 탐색
 * 시뮬레이션
 * 너비 우선 탐색
 */
public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        boolean moved; // 이동 여부 체크
        do {
            visited = new boolean[N][N];
            moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        bfs(i, j, union);

                        if (union.size() > 1) {
                            int totalPeople = 0;
                            for (int[] ints : union) {
                                totalPeople += map[ints[0]][ints[1]];
                            }
                            int newPeople = totalPeople / union.size();
                            for (int[] ints : union) {
                                map[ints[0]][ints[1]] = newPeople;
                            }
                            moved = true;
                        }
                    }
                }
            }
            if (moved) days++;
        } while (moved); // 인구 이동이 없을 때까지 반복

        System.out.println(days);
    }

    public static void bfs(int x, int y, List<int[]> union) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 해당 인덱스 queue와 연합 배열에 추가
        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[curr[0]][curr[1]] - map[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}