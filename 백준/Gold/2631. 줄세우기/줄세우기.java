import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--)
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(N - max - 1);
    }
}


/**
 * 3 5  6
 * 1 2 3 4 5 6 7
 */