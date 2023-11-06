import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int mod_value = 1_000_000_009;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod_value;
        }

        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
/*
dp[i] = i를 만들기 위한 경우의 수

dp[1] = 1
dp[2] = 2
dp[3] = 4
dp[4] = dp3 + dp2 + dp1 = 7
dp[5] = dp4 + dp3 + dp2 = 13
...
dp[n] = dpn-1 + dpn-2 + dpn-3
 */