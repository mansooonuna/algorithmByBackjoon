import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(check(n, m)).append("\n");
        }
        System.out.println(sb);
    }

    private static long check(int n, int m) {
        dp = new long[n + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j / 2];
            }
        }

        return dp[n][m];
    }
}

/**
 * dp[n][m] = m까지 숫자 중 n개의 수열을 고르는 경우의 수
 * 1. 이전까지 수열 -> dp[i][j-1] 에다가 마지막 숫자 추가 (1, 2, 4, 8) 그럼 그냥 + 1
 * 2. 이전까지 수열 -> dp[i][j-1] 에다가 2배수 이상의 숫자 추가하려면 dp[i-1][j] / 2 한거 추가
 *
 *
 * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
 * 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
 * 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
 * 0, 0, 0, 0, 1, 2, 4, 6, 9, 12, 16
 * 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 4
 * */