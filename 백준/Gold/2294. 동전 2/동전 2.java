import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j = coin; j < k + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        System.out.println(dp[k] != 100001 ? dp[k] - 1 : -1);
    }
}

/**
 * dp[i] = 입력받은 동전으로 i원을 만들 수 있는 최소 동전 개수
 * dp[i] = dp[i] or dp[i - coin] +1 중 최소값
 * <p>
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 ...
 * 0 1 2 3 4 1 2 3 4 5 2  3  4  5  ...
 * 0 1 2 3 4 1 2 3 4 5 2  3  1  2  ...
 */