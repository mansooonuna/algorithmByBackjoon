import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] map;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[w][h];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1) {
                        island++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(island);
        }

    }

    static void dfs(int x, int y) {
        int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
        int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
        map[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}

/*
 */