import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        dp[0][0] = map[0][0];
        // 1. x = 0
        for (int i = 1; i < M; i++) dp[0][i] = dp[0][i - 1] + map[0][i];
        // 2. y = 0
        for (int i = 1; i < N; i++) dp[i][0] = dp[i - 1][0] + map[i][0];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        System.out.println(dp[N - 1][M - 1]);
    }
}
/*
dp[i][j] = i,j까지 경로 중 가장 많은 광석 수

0 1 1 1
0 1 2 2
1 2 2 2
2 2 3 3
3 4 4 4
 */