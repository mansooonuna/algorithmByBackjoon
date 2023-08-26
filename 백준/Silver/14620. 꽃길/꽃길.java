import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 브루트포스 알고리즘
 */
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        System.out.println(min);
    }


    static void dfs(int depth, int sum) {
        // 3개의 꽃을 심었다면 최소 비용 갱신
        if (depth == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 꽃을 심을 수 있다면
                if (isPossible(i, j)) {
                    int temp = cost(i, j); // 비용 계산

                    // 꽃을 심은 자리와 상,하,좌,우 방문처리
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        visited[nx][ny] = true;
                    }

                    dfs(depth + 1, sum + temp); // 개수를 1 늘리고, 비용을 더한 후 재귀호출

                    // 다음 경우의 수를 위해 값 초기화
                    visited[i][j] = false;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    public static boolean isPossible(int x, int y) {
        if (visited[x][y]) return false;

        // 꽃잎이 생길 수 있는지 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 꽃잎이 배열의 범위를 벗어난다면 해당 자리에 꽃을 심을수 없음
            if (nx >= N || ny >= N || nx < 0 || ny < 0)
                return false;

            // 꽃잎의 자리에 다른 꽃이 핀 경우도 꽃을 심을 수 없음
            if (visited[nx][ny])
                return false;
        }
        // 위의 경우가 아니라면 꽃을 심을 수 있음
        return true;
    }

    // x행 y열에 꽃을 심었다면 비용 계산
    static int cost(int x, int y) {
        int sum = map[x][y]; // 씨앗 자리 비용

        // 꽃잎 자리 비용 계산
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            sum += map[nx][ny];
        }
        return sum;
    }
}