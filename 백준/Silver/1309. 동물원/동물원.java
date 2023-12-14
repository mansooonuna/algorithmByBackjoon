import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 9901;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 우리의 크기

        int[][] dp = new int[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1; // 사자가 없거나, 왼쪽에 있거나, 오른쪽에 있거나 경우의 수는 1

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];

            dp[i][0] %= MOD;
            dp[i][1] %= MOD;
            dp[i][2] %= MOD;
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % MOD);
    }
}

/*
1. dp[i][0] = i행 사자 없음
   -> 이전 행에서 사자가 어느 곳이든 위치할 수 있음
      dp[n][0] = dp[n-1][0] + dp[n-1][1] + dp[n-1][2]

2. dp[i][1] = i행 사자 왼쪽 위치
   -> 이전 행에서 사자가 오른쪽에 있거나 없어야함
      dp[n][1] = dp[n-1][0] + dp[n-1][2]

3. dp[i][2] = i행 사자 오른쪽 위치
   -> 이전 행에서 사자가 왼쪽에 있거나 없어야함
      dp[n][2] = dp[n-1][0] + dp[n-1][1]


dp[1][0] dp[1][1] dp[1][2] = 1;
*/