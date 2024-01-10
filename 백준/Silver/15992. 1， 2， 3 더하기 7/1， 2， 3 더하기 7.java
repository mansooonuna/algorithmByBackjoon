import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_009;
    static long[][] dp = new long[1001][1001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
        dp[3][2] = 2;
        for (int i = 4; i <= 1000; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % MOD;
            }
            dp[i][i] = 1;
        }

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
    }
}

/*
dp[i][j] = i를 j개의 1,2,3의 합으로 나타내는 방법의 수

dp[i][i] = 1
           i를 만들기 위해 i개의 수식을 사용하는 경우는
           1 + 1 + 1 + 1 + ... (1이 총 i번 더해지는 경우 밖에 없음)
 */