import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] snacks = new int[N];
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        dp[0] = snacks[0];
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = snacks[i];
            for (int j = 0; j < i; j++) {
                if (snacks[j] < snacks[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + snacks[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

/*
가장 긴 증가하는 부분 수열?

dp[i] = i 일까지 간식 평점 중 최대 평점
 */