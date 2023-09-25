import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = nums[0];
        max = dp[0];

        for (int i = 1; i < N; i++) {
            // 이전 dp에 현재 숫자를 더해서 최댓값 비교
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

/*
    [10, 6, 9, 10, 15, 21, -14, 12, 33, 32]
 */