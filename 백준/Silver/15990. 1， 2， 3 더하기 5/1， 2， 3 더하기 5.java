import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static final int MOD = 1_000_000_009;
    static long[][] dp = new long[100001][4];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long result = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

/*
1. n을 만들기 위한 경우의 수
2. 수식의 마지막이 어떤 수로 끝나는가?

** 7을 1,2,3의 합으로 나타내는 경우의 수
dp[7][1] -> 7을 만드는 수식 중 마지막이 1로 끝나는 경우의 수
 = dp[6][2] -> 6을 만드는 수식 중 마지막이 2로 끝나는 경우의 수 + 1
 + dp[6][3] -> 6을 만드는 수식 중 마지막이 3으로 끝나는 경우의수 + 1

...

DP[N][1] = DP[N - 1][2] + DP[N - 1][3]
DP[N][2] = DP[N - 2][1] + DP[N - 2][3]
DP[N][3] = DP[N - 3][1] + DP[N - 3][2]
 */