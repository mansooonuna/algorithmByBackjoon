import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[][] sheeps;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 그리드 높이
            W = Integer.parseInt(st.nextToken()); // 그리드 너비

            sheeps = new int[H][W];
            int sheepsCnt = 0;
            for (int i = 0; i < H; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < W; j++) {
                    String tmp = input[j];

                    if (tmp.equals("#")) {
                        sheeps[i][j] = 1;
                    } else sheeps[i][j] = 0;
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (sheeps[i][j] == 1) {
                        sheepsCnt++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(sheepsCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        sheeps[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < H && ny >= 0 && ny < W && sheeps[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}