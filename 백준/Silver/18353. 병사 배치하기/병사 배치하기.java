import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 병사의 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] power = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (power[i] < power[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}

/**
 * 가장 긴 감소하는 부분 수열 문제 응용해서
 * (총 병사 수) - (가장 긴 부분 수열 크기)
 */