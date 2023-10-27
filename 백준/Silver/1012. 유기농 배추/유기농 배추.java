import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

            map = new int[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 배추 위치 X
                int Y = Integer.parseInt(st.nextToken()); // 배추 위치 Y
                map[X][Y] = 1;
            }

            int wormCnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        wormCnt++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(wormCnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}