import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[] dp = new int[N];
            int[] p = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = Integer.parseInt(br.readLine());
            }

            dp[0] = p[0];
            int max = p[0];

            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(dp[i - 1] + p[i], p[i]);
                max = Math.max(max, dp[i]);
            }
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}

/*
dp[i] = i 일까지 수익 중 최대 수익
 */