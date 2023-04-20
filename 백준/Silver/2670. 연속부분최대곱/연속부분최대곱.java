import java.io.*;
import java.util.*;

/**
 * 연속부분 최대곱
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] dp = new double[N];
        double[] nums = new double[N];

        for (int i = 0; i < N; i++) {
            double num = Double.parseDouble(br.readLine());
            nums[i] = num;
        }

        double answer = 0;
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] * nums[i], nums[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.printf("%.3f", answer);
    }
}
