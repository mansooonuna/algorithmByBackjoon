import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        dp = new int[31][31];
        dp[1][1] = 1;

        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < i + 1; j++) {
                sum += dp[R + i][C + j];
            }
        }
        System.out.println(sum);
    }
}

/**
 * 1 0 0 0
 * 1 1 0 0
 * 1 2 1 0
 * 1 3 3 1
 * ...
 * <p>
 * dp[i][j] = i번째 줄 j번째 수
 * dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 */