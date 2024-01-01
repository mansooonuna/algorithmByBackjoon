import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] normalMap; // R, G, B
    static char[][] blindnessMap; // R == G, B
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        normalMap = new char[N][N];
        blindnessMap = new char[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = input.charAt(j);
                normalMap[i][j] = blindnessMap[i][j] = c;

                if (blindnessMap[i][j] == 'G') blindnessMap[i][j] = 'R';
            }
        }

        int normalResult = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, normalMap[i][j], normalMap);
                    normalResult++;
                }
            }
        }

        visited = new boolean[N][N];
        int blindnessResult = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, blindnessMap[i][j], blindnessMap);
                    blindnessResult++;
                }
            }
        }

        System.out.println(normalResult + " " + blindnessResult);
    }

    static void dfs(int x, int y, char color, char[][] map) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == color && !visited[nx][ny]) {
                    dfs(nx, ny, color, map);
                }
            }
        }
    }
}